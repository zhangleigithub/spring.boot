package com.example.demo.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class SampleXlsView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		Map<String, String> userData = (Map<String, String>) model.get("userData");

		// Create a blank sheet
		HSSFSheet spreadsheet = (HSSFSheet) workbook.createSheet("userInfo");
		// Create row object
		HSSFRow row;

		int rowid = 0;

		for (Map.Entry<String, String> entry : userData.entrySet()) {
			
			row = spreadsheet.createRow(rowid++);

			HSSFCell cell = row.createCell(0);
			cell.setCellValue((String) entry.getKey());
			cell = row.createCell(1);
			cell.setCellValue((String) entry.getValue());
		}
	}

}
