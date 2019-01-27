package com.sammi.srvm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.gson.Gson;

public class ExcelRead {
	public static Map<String, Object> read(ExcelReadOption excelReadOption) {

		Gson gson = new Gson();

		try {
			Workbook wb = ExcelFileType.getWorkbook(excelReadOption.getFilePath());

			int numOfSheet = wb.getNumberOfSheets();

			System.out.println("데이터가 있는 Sheet의 수 :" + wb.getNumberOfSheets());

			System.out.println(numOfSheet);

			Map<String, Object> result = new HashMap<String, Object>();

			for (int i = 0; i < numOfSheet; i++) {
				Sheet sheet = null;
				String sheetname = null;
				sheet = wb.getSheetAt(i);
				sheetname = sheet.getSheetName();
				if (sheetname.startsWith("부품") || sheetname.startsWith("인사말") || sheetname.startsWith("업체")) {
					System.out.println("continue on " + sheetname);
					continue;
				}

				System.out.println("Sheet 이름: " + wb.getSheetName(i));

				int numOfRows = sheet.getPhysicalNumberOfRows();
				int numOfCells = 0;

				Row row = null;
				Cell cell = null;

				String cellName = "";
				/**
				 * 각 row마다의 값을 저장할 맵 객체 저장되는 형식은 다음과 같다. put("A", "이름"); put("B", "게임명");
				 */
				Map<String, String> map = null;
				/*
				 * 각 Row를 리스트에 담는다. 하나의 Row를 하나의 Map으로 표현되며 List에는 모든 Row가 포함될 것이다.
				 */

				List<Map<String, String>> sheets = null;

				List<String> headers = new ArrayList<String>();

				// List<List<Map<String,String>>> result = new
				// ArrayList<List<Map<String,String>>>();
				System.out.println(sheetname + "의 Row 수 : " + numOfRows);

				Row headerrow = sheet.getRow(0);

				sheets = new ArrayList<Map<String, String>>();

				numOfCells = headerrow.getPhysicalNumberOfCells();

				for (int cellIndex = 0; cellIndex < numOfCells; cellIndex++) {
					headers.add(ExcelCellRef.getValue(headerrow.getCell(cellIndex)));

				}

				map = new HashMap<String, String>();

				for (int rowIndex = excelReadOption.getStartRow() - 1; rowIndex < numOfRows; rowIndex++) {
					row = sheet.getRow(rowIndex);

					if (row != null) {
						numOfCells = row.getPhysicalNumberOfCells();

						for (int cellIndex = 0; cellIndex < headers.size(); cellIndex++) {

							cell = row.getCell(cellIndex);

							cellName = ExcelCellRef.getName(cell, cellIndex);

							if (!excelReadOption.getOutputColumn().contains(headers.get(cellIndex))) {
								continue;
							}
							if (ExcelCellRef.getValue(cell) == null || ExcelCellRef.getValue(cell) == "") {

								continue;
							}

							map.put(headers.get(cellIndex), ExcelCellRef.getValue(cell));

						}

					}

				}
				sheets.add(map);

				result.put(sheet.getSheetName(), sheets);

				System.out.println(result.size());

				return result;

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			
			return null;
		}

	}
}