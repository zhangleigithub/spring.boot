package com.example.demo.view;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Component  
public class SamplePdfView extends AbstractPdfView {  
  
  @Override  
  protected void buildPdfDocument(Map<String, Object> model,  
          Document document, PdfWriter writer, HttpServletRequest request,  
          HttpServletResponse response) throws Exception {  
      document.add(new Paragraph(((Date)model.get("serverTime")).toString()));  
  }  
} 