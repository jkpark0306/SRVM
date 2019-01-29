package com.sammi.srvm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.google.gson.Gson;
import com.sammi.srvm.dto.ExcelDTO;

public class ExcelRead {
	public static Map<String, Object> read(ExcelReadOption excelReadOption) {

		Gson gson = new Gson();
		
		Map<String, Object> result;

		try {
			Workbook wb = ExcelFileType.getWorkbook(excelReadOption.getFilePath());

			int numOfSheet = wb.getNumberOfSheets();

			System.out.println("데이터가 있는 Sheet의 수 :" + wb.getNumberOfSheets());


			result = new LinkedHashMap<String, Object>();
			/*
			 * result -> 최종적으로 리턴받을 객체
			 * Map<String, String> map -> 한 행의 데이터('헤더 이름(칼럼명)','데이터')
			 * List<Map<String,String>> -> 한 시트의 데이터(한 행의 데이터의 List)
			 * 
			 */
			
			
			
			//시트 반복문 시작지점
			for (int i = 0; i < numOfSheet; i++) {
				
				Sheet sheet = null;
				
				String sheetname = null;
				
				sheet = wb.getSheetAt(i);
				
				sheetname = wb.getSheetName(i);
				
				if (sheetname.startsWith("부품") || sheetname.startsWith("인사말") || sheetname.startsWith("업체")) {
					continue;
				}
				
				System.out.println("Sheet 이름: " + sheetname);

				int numOfRows = sheet.getPhysicalNumberOfRows();
				int numOfCells = 0;

				Row row = null;
				Cell cell = null;

				
				Map<String, String> rowdata = null;
				
				List<Map<String, String>> sheetdata = null;

				

				// List<List<Map<String,String>>> result = new
				// ArrayList<List<Map<String,String>>>();
				//System.out.println(sheetname + "의 Row 수 : " + numOfRows);

				Row headerrow = sheet.getRow(0);

				sheetdata = new ArrayList<Map<String, String>>();
				System.out.println("sheetdata test " + gson.toJson(sheetdata));
				numOfCells = headerrow.getPhysicalNumberOfCells();
				
				//헤더 List 만드는 부분(RowMap에서 Key로 사용)
				List<String> headers = new ArrayList<String>();
				for (int cellIndex = 0; cellIndex < numOfCells; cellIndex++) {
					headers.add(ExcelCellRef.getValue(headerrow.getCell(cellIndex)));

				}
				//헤더 List 만드는 부분
				
				for (int rowIndex = excelReadOption.getStartRow() - 1; rowIndex < numOfRows; rowIndex++) {//로우 반복문 시작 지점
					
					rowdata = new HashMap<String, String>();
					
					row = sheet.getRow(rowIndex);

					if (row != null) {
						numOfCells = row.getPhysicalNumberOfCells();
						
						
						
						
						for (int cellIndex = 0; cellIndex < headers.size(); cellIndex++) {//셀 반복문 시작 지점
							
							cell = row.getCell(cellIndex);

							String cellvalue = ExcelCellRef.getValue(cell);
							

							if (!excelReadOption.getOutputColumn().contains(headers.get(cellIndex))) {
								continue;
							}
							if (cellvalue == null || cellvalue == "" || cellvalue == " ") {
								continue;
							}
							
							rowdata.put(headers.get(cellIndex), ExcelCellRef.getValue(cell));

						}//셀 반복문 종료 지점
						
						if(!rowdata.isEmpty()) {
							sheetdata.add(rowdata);//한 row 만들어지면 sheet에 추가
						}
					}
					
					
					
					

				}//로우 반복문 종료 지점
				
				//System.out.println(gson.toJson(sheetdata));
				
				
				result.put(sheetname, sheetdata);//한 sheet 만들어지면 result에 추가
				
					
				
				System.out.println(result.size());

				

			}//시트 반복문 종료 지점
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
			ex.printStackTrace();
			
			return null;
		}
		
		
		return result;
		

	}
}