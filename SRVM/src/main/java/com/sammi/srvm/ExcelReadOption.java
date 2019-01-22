package com.sammi.srvm;

import java.util.ArrayList;
import java.util.List;

public class ExcelReadOption {
	private String filePath;
	
	private List<String> outputColumns;
	
	private int startRow;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filepath) {
		this.filePath = filepath;
	}
	public List<String> getOutputColumn() {
		List<String> temp = new ArrayList<String>();
		temp.addAll(outputColumns);
		return temp;
	}
	
	public void setOutputColumn(List<String> outputColumn) {
		List<String> temp = new ArrayList<String>();
		temp.addAll(outputColumn);
		
		this.outputColumns = temp;
	}
	
	public void setOutputColumn(String ... outputColumns) {
		if(this.outputColumns ==null) {
			this.outputColumns = new ArrayList<String>();
		}
		for(String outputColumn : outputColumns) {
			this.outputColumns.add(outputColumn);
		}
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	
}
