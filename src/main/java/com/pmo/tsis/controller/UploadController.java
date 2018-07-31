package com.pmo.tsis.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pmo.tsis.service.UploadService;

@RestController
public class UploadController {

	@Autowired
	UploadService uploadService;
	
	@RequestMapping(value = "/userUpload",  method = RequestMethod.POST)
	public String upload(@RequestParam("excelFile") MultipartFile file){
		Workbook workbook = uploadService.getWorkBook(file);
		uploadService.insertWorkbook(workbook);

		return "upload";
	}
	
}
