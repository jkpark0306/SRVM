package com.sammi.srvm;

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
	public static List<Map<String, String>> read(ExcelReadOption excelReadOption){
		
		Gson gson = new Gson();
		
		
		try {
		Workbook wb = ExcelFileType.getWorkbook(excelReadOption.getFilePath());
		
		
		Sheet sheet = wb.getSheetAt(5);
		
        System.out.println("Sheet 이름: "+ wb.getSheetName(5)); 
        System.out.println("데이터가 있는 Sheet의 수 :" + wb.getNumberOfSheets());


        int numOfRows = sheet.getPhysicalNumberOfRows();
        int numOfCells = 0;
        
        Row row = null;
        Cell cell = null;
        
        String cellName = "";
        /**
         * 각 row마다의 값을 저장할 맵 객체
         * 저장되는 형식은 다음과 같다.
         * put("A", "이름");
         * put("B", "게임명");
         */
        Map<String, String> map = null;
        /*
         * 각 Row를 리스트에 담는다.
         * 하나의 Row를 하나의 Map으로 표현되며
         * List에는 모든 Row가 포함될 것이다.
         */

        List<Map<String,String>> result = new ArrayList<Map<String,String>>();
        
        System.out.println(numOfRows);
        
        Row headerrow = sheet.getRow(0);
        
        List<String> headers = new ArrayList<String>();
        
        numOfCells = headerrow.getPhysicalNumberOfCells();
        
        for(int cellIndex =0;cellIndex < numOfCells;cellIndex++) {
        	headers.add(ExcelCellRef.getValue(headerrow.getCell(cellIndex)));
        	
        }
        System.out.println(gson.toJson(headers));
        
        
        
        for(int rowIndex = excelReadOption.getStartRow() - 1;rowIndex<numOfRows;rowIndex++) {
        	row = sheet.getRow(rowIndex);
        	
        	
        	
        	if(row != null) {
        		numOfCells = row.getPhysicalNumberOfCells();
        		
        		map = new HashMap<String, String>();
        		
        		
        		
        		
        		
        		for(int cellIndex = 0;cellIndex < numOfCells;cellIndex++) {
        			cell = row.getCell(cellIndex);
        			
        			cellName = ExcelCellRef.getName(cell, cellIndex);
        			//cell.Name = 
        			
        			if(!excelReadOption.getOutputColumn().contains(headers.get(cellIndex))) {
        				continue;
        			}
        			
        			System.out.println("cell value : "+ExcelCellRef.getValue(cell));
        			
        			
        			map.put(headers.get(cellIndex), ExcelCellRef.getValue(cell));
        			
        			
        			
        		}
        		result.add(map);
        	}
        	
        }
        
        return result;
        
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
        
		return null;
        
	}
}
