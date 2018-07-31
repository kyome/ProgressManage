package com.pmo.tsis.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pmo.tsis.persistence.UserDAO;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	UserDAO userDAO;

	@Override
	public Workbook getWorkBook(MultipartFile multipartFile) {
		Workbook workbook = null;

		if (multipartFile.getOriginalFilename().toUpperCase().endsWith(".XLS")) {
			try {
				workbook = new HSSFWorkbook(multipartFile.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		} else if (multipartFile.getOriginalFilename().toUpperCase().endsWith(".XLSX")) {
			try {
				workbook = new XSSFWorkbook(multipartFile.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}

		return workbook;
	}

	@Override
	public void insertWorkbook(Workbook workbook) {
		userDAO.insertMember(convertTable(workbook));
	}

	private List<Map<String, String>> convertTable(Workbook workbook) {

		List<Map<String, String>> result = new LinkedList<>();
		Map<String, String> rowMap = null;

		Sheet sheet = workbook.getSheetAt(0);
		Row row = null;
		Cell cell = null;

		int numOfRows = sheet.getPhysicalNumberOfRows();
		int numOfCells = 0;
		if (numOfRows > 0) {
			numOfCells = sheet.getRow(0).getPhysicalNumberOfCells();
		}

		for (int i = 1; i < numOfRows; i++) {
			rowMap = new HashMap<>();
			row = sheet.getRow(i);
			for (int j = 0; j < numOfCells; j++) {
				cell = row.getCell(j);
				rowMap.put(getValue(sheet.getRow(0).getCell(j)), getValue(cell));
			}

			result.add(rowMap);
		}
		return result;
	}

	private static String getValue(Cell cell) {
		String value = "";

		if (cell == null) {
			value = "";
		} else {
			if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				value = cell.getCellFormula();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				value = String.format("%.0f", cell.getNumericCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				value = cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				value = cell.getBooleanCellValue() + "";
			} else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
				value = cell.getErrorCellValue() + "";
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				value = "";
			} else {
				value = cell.getStringCellValue();
			}
		}

		return value;
	}

}
