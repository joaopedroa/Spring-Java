package br.com.projetospring.controllers;



import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.projetospring.models.UserInfo;



@Controller
public class ExcelController {

	
	
	@RequestMapping("/produtos/excel")
	public String teste() {
		return "produtos/excel";
	}
	
	
	
	 
	@RequestMapping("/uploadExcelFile")
	public String uploadFile(Model model, @RequestParam("file") MultipartFile  file) throws IOException {
		try {
			List<UserInfo> lstUser = new ArrayList<>();
			int i = 0;
			// Creates a workbook object from the uploaded excelfile
			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
			// Creates a worksheet object representing the first sheet
			XSSFSheet worksheet = workbook.getSheetAt(0);
			// Reads the data in excel file until last row is encountered
			while (i <= worksheet.getLastRowNum()) {
				// Creates an object for the UserInfo Model
				UserInfo user = new UserInfo();
				// Creates an object representing a single row in excel
				XSSFRow row = worksheet.getRow(i++);
				// Sets the Read data to the model class
				user.setId((int) row.getCell(0).getNumericCellValue());
				user.setUsername(row.getCell(1).getStringCellValue());
				user.setInputDate(row.getCell(2).getDateCellValue());
				// persist data into database in here
				lstUser.add(user);
			}
			System.out.println(lstUser);
			workbook.close();
			model.addAttribute("lstUser", lstUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "upload/sucesso";	
	}
}
	