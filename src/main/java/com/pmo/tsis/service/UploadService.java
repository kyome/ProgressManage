package com.pmo.tsis.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	Workbook getWorkBook(MultipartFile file);
	void insertWorkbook(Workbook workbook);	
}
