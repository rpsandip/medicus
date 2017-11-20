package com.medicus.report.portlet.portlet.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.util.StringPool;
import com.medicus.common.service.bean.StudentBean;
import com.medicus.common.service.model.Student;

public class ReportFileUtil {
		public static File generateReport(List<Student> studentList) throws IOException{
			
			int index=0;
			
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet();
			
			XSSFFont boldFont = wb.createFont();
			boldFont.setFontHeightInPoints((short) 14);
			boldFont.setBold(true);
			boldFont.setFontName("Arial");
			
			XSSFFont normalFont = wb.createFont();
			boldFont.setFontHeightInPoints((short) 12);
			boldFont.setFontName("Arial");
			
			index = createMainHeaderRow(sheet, wb, boldFont, index);
			
			for(Student student  : studentList){
				StudentBean studentBean = new StudentBean(student,true);
				index = createStudentRow(sheet, wb, normalFont, studentBean, index);
			}
			
			// Write the output to a file
	 		String fileName = "Medicus_Export_Students.xlsx";
	 		File file = new File(System.getProperty("catalina.home")+"/temp/"+fileName);
	 		
	 		FileOutputStream fileOut = new FileOutputStream(file);
	 		wb.write(fileOut);
	 		fileOut.close();
	 		
	 		return file; 
		}
		
		private static int createMainHeaderRow(XSSFSheet sheet, XSSFWorkbook wb, XSSFFont boldFont,int index){
			XSSFRow headerRow = sheet.createRow(index);	
			XSSFCellStyle style = wb.createCellStyle();
			style.setFont(boldFont);
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			
			XSSFCell cell1=  headerRow.createCell(1);
			cell1.setCellValue("Name");
			cell1.setCellStyle(style);
			
			XSSFCell cell2=  headerRow.createCell(2);
			cell2.setCellValue("Student Id");
			cell2.setCellStyle(style);
			
			XSSFCell cell3=  headerRow.createCell(3);
			cell3.setCellValue("Gender");
			cell3.setCellStyle(style);
			
			XSSFCell cell4=  headerRow.createCell(4);
			cell4.setCellValue("Zipcode");
			cell4.setCellStyle(style);
			
			XSSFCell cell5=  headerRow.createCell(5);
			cell5.setCellValue("Profession");
			cell5.setCellStyle(style);
			
			
			XSSFCell cell6=  headerRow.createCell(6);
			cell6.setCellValue("Languages");
			cell6.setCellStyle(style);
			
			XSSFCell cell7=  headerRow.createCell(7);
			cell7.setCellValue("School");
			cell7.setCellStyle(style);

			XSSFCell cell8=  headerRow.createCell(8);
			cell8.setCellValue("Campus");
			cell8.setCellStyle(style);
			
			
			index++;
			return index;
		}
		
		private static int createStudentRow(XSSFSheet sheet, XSSFWorkbook wb, XSSFFont normalFont, StudentBean studentBean,int index){
			
			XSSFRow studentRow = sheet.createRow(index);
			XSSFCellStyle style = wb.createCellStyle();
			style.setFont(normalFont);
			
			XSSFCell cell1=  studentRow.createCell(1);
			cell1.setCellValue(studentBean.getFirstName()+StringPool.SPACE+studentBean.getLastName());
			cell1.setCellStyle(style);
			
			XSSFCell cell2=  studentRow.createCell(2);
			cell2.setCellValue(studentBean.getStundetCampusId());
			cell2.setCellStyle(style);
			
			XSSFCell cell3=  studentRow.createCell(3);
			cell3.setCellValue(studentBean.getGender());
			cell3.setCellStyle(style);
			
			
			XSSFCell cell4=  studentRow.createCell(4);
			cell4.setCellValue(studentBean.getZipcode());
			cell4.setCellStyle(style);
			
			XSSFCell cell5=  studentRow.createCell(5);
			cell5.setCellValue(studentBean.getProfession());
			cell5.setCellStyle(style);
			
			XSSFCell cell6=  studentRow.createCell(6);
			cell6.setCellValue(studentBean.getPrimaryLanguages());
			cell6.setCellStyle(style);
			
			XSSFCell cell7=  studentRow.createCell(7);
			cell7.setCellValue(studentBean.getSchoolName());
			cell7.setCellStyle(style);
			
			XSSFCell cell8=  studentRow.createCell(8);
			cell8.setCellValue(studentBean.getCampusName());
			cell8.setCellStyle(style);
			
			index++;
			return index;
		}
}
