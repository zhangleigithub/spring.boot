package com.example.webuploaderDemo;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

@Controller
@SpringBootApplication
public class WebuploaderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebuploaderDemoApplication.class, args);
	}
	
	private String serverPath = "G:\\Upload";

	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
	
	@RequestMapping(value = "/checkChunk", method = RequestMethod.POST)
	@ResponseBody
	public Boolean checkChunk(@RequestParam("fileMd5") String fileMd5, @RequestParam("chunk") String chunk,
			@RequestParam("chunkSize") String chunkSize) {

		File checkFile = new File(serverPath + "/" + fileMd5 + ".dt");

		// 检查文件是否存在
		if (checkFile.exists()) {
			return true;
		}

		File checkFilechunk = new File(serverPath + "/" + fileMd5 + "/" + chunk);

		// 检查文件是否存在，且大小是否一致
		if (checkFilechunk.exists() && checkFilechunk.length() == Integer.parseInt(chunkSize)) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/fileUploadsPage", method = RequestMethod.POST)
	@ResponseBody
	public String fileUploadsPage(HttpServletRequest request, Model model) throws FileUploadException, IOException {

		MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request,
				MultipartHttpServletRequest.class);
		MultipartFile file = multipartRequest.getFile("file");

		String chunk = multipartRequest.getParameter("chunk");
		String fileMd5 = multipartRequest.getParameter("fileMd5");

		if (chunk == null) {
			chunk = "";
		}

		File fileDir = new File(serverPath + "/" + fileMd5);
		if (!fileDir.exists()) {
			fileDir.mkdir();
		}

		file.transferTo(new File(serverPath + "/" + fileMd5 + "/" + chunk));
		System.out.println("fileUploadsPage" + chunk);
		return "file-upload";
	}

	@RequestMapping(value = "/mergeChunks", method = RequestMethod.POST)
	@ResponseBody
	public Boolean mergeChunks(@RequestParam("fileMd5") String fileMd5) throws IOException {
		
		File checkFile = new File(serverPath + "/" + fileMd5);

		// 检查文件是否存在
		if (!checkFile.exists()) {
			return false;
		}
		
		// 读取目录里的所有文件
		File f = new File(serverPath + "/" + fileMd5);
		File[] fileArray = f.listFiles(new FileFilter() {
			// 排除目录只要文件
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				if (pathname.isDirectory()) {
					return false;
				}
				return true;
			}
		});

		// 转成集合，便于排序
		List<File> fileList = new ArrayList<File>(Arrays.asList(fileArray));
		Collections.sort(fileList, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				// TODO Auto-generated method stub
				if (Integer.parseInt(o1.getName()) < Integer.parseInt(o2.getName())) {
					return -1;
				}
				return 1;
			}
		});
		// UUID.randomUUID().toString()-->随机名
		File outputFile = new File(serverPath + "/" + fileMd5 + ".dt");
		// 创建文件
		outputFile.createNewFile();
		// 输出流
		@SuppressWarnings("resource")
		FileChannel outChnnel = new FileOutputStream(outputFile).getChannel();
		// 合并
		FileChannel inChannel;
		for (File file : fileList) {
			inChannel = new FileInputStream(file).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChnnel);
			inChannel.close();
			// 删除分片
			file.delete();
		}
		outChnnel.close();
		// 清除文件夹
		File tempFile = new File(serverPath + "/" + fileMd5);
		if (tempFile.isDirectory() && tempFile.exists()) {
			tempFile.delete();
		}

		System.out.println("合并成功");

		return true;
	}
}
