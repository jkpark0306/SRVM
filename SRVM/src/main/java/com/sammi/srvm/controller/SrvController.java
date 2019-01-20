package com.sammi.srvm.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.SrvDTO;
import com.sammi.srvm.dto.UniEquDTO;
import com.sammi.srvm.service.SrvService;
import com.sammi.srvm.service.SrvServiceImpl;


@Controller
public class SrvController {
	
	
	@Autowired
	SrvService srvservice;
	
	@Autowired
	SelectDAO selectdao;
	
	Gson gson = new Gson();
	
	public class tc{
		public String td1;
		public String td2;
		public String td3;
	}	
	
	public class InSrvParam{
		public SrvDTO srvdto;
		public UniEquDTO uniequdto;
	}
	
	public String GetCellData(HSSFCell cell) {
		
		String value="";
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		

		
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				value = sd.format((cell.getDateCellValue()));
			}else {
				value = cell.getNumericCellValue() + "";
			}
			
			break;
		case HSSFCell.CELL_TYPE_STRING:
			value = cell.getStringCellValue() + "";
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			value = cell.getBooleanCellValue() + "";
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			value = cell.getErrorCellValue() + "";
			break;
		
		}
		
		return value;
		
		
	}
	
	public String[] GetColumnMap(HSSFRow row) {

		int cellcount = row.getPhysicalNumberOfCells();
		String[] header = new String[cellcount];

		for (int idx = 0; idx < cellcount; idx++) {
			HSSFCell cell = row.getCell(idx);
			
			String data = GetCellData(cell);
			
			header[idx] = data;
		}

		for (int idx = 0; idx < header.length; idx++) {
			
			switch (header[idx]) {
			case "입고일":
				header[idx] = "Indate";
				break;
			case "수리일":
				header[idx] = "Repdate";
				break;
			case "출고일":
				header[idx] = "Reldate";
				break;
			case "운송장번호":
				header[idx] = "RelInvNumber";
				break;
			case "장비명":
				header[idx] = "ProductNumber";
				break;
			case "S/N":
				header[idx] = "SerialNumber";
				break;
			case "업체":
				header[idx] = "CusName";
				break;
			case "담당자":
				if (header[idx - 1] == "Process" || header[idx - 1] == "진행상황") {
					header[idx] = "EmpName";
				} else {
					header[idx] = "CusEmpName";
				}
				break;
			case "연락처":
				header[idx] = "Number";
				break;
			case "주소":
				header[idx] = "Address";
				break;
			case "전자세금계산서 주소":
				header[idx] = "EmailAddress";
				break;
			case "진행상황":
				header[idx] = "Process";
				break;
			case "증상내역":
				header[idx] = "Symptom";
				break;
			case "수리내역":
				header[idx] = "Action1";
				break;
			case "외부 수리 입고":
				header[idx] = "Action2";
				break;
			case "진행사항1":
				header[idx] = "Action3";
				break;
			case "진행사항2":
				header[idx] = "Action4";
				break;
			case "비고":
				header[idx] = "Note";
				break;
			}

		}

		return header;

	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/ajax/ImportExcel",method=RequestMethod.POST,produces="application/json; charset=UTF-8")
	public String ImportExcel(HttpSession session, @RequestBody String param, HttpServletResponse response) throws IOException {
		
		
		String filepath = param;
		
		System.out.println(param);
		
		FileInputStream fis = new FileInputStream(filepath);

		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		
		int sheetcount = workbook.getNumberOfSheets();
		
		HSSFSheet sheet = workbook.getSheetAt(4);
		
		HSSFRow header = sheet.getRow(0);
		
		int cellcount = header.getPhysicalNumberOfCells();
		
		Map<String, String> map = new HashMap<String, String>();
		
		String[] headerst = null;
		
		for(int i =0;i<header.getPhysicalNumberOfCells();i++) {
			headerst = GetColumnMap(header);
			
			System.out.println(headerst[i]);
		}
		
		HSSFRow row = sheet.getRow(1);
		
		for(int i =0;i<headerst.length;i++) {
			String value = "";
			if(row.getCell(i)==null) {
				
				
			}else {
				value = GetCellData(row.getCell(i)).replaceAll("\"","");
			}
			
			map.put(headerst[i], value);
			
			
		}
		
		System.out.println(gson.toJson(map));
		
		
		
		
		return "";
	}
	
	public SrvDTO maptodto(Map<String, String> map) throws ParseException {
		SrvDTO dto = new SrvDTO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		
		String SrvCode = sdf.format(sdf.parse(map.get("Indate")));
		
		SrvCode = SrvCode + "01000";
		
		SrvCode = (selectdao.GetNewSrvCode(SrvCode)).getSrvCode();
		
		dto.setSrvCode(SrvCode);
		
		
		
		return dto;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/ajax/InSrv",method=RequestMethod.POST,produces="application/json; charset=UTF-8")
	public String InSrv(HttpSession session, @RequestBody String param,HttpServletResponse response) {
		System.out.println(param);
		
		Gson gson = new Gson();
		
		InSrvParam insrvparam = gson.fromJson(param, InSrvParam.class);
		
		
		System.out.println(gson.toJson(insrvparam.srvdto));
		
		System.out.println(gson.toJson(insrvparam.uniequdto));
		
		try {
		int result = srvservice.InsertSrv(insrvparam.srvdto, insrvparam.uniequdto);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		/*
		srvservice.InsertSrv(srvdto, uniequdto)
		*/
		
		return "";
	}
	
	@RequestMapping(value="/SrvIO",method=RequestMethod.GET)
	public String SrvIO(Locale locale, Model model) {
		
		
		Gson gson = new Gson();
		
		model.addAttribute("SrvList",gson.toJson(srvservice.GetAllSrv()));
		
		
		
		return "/Service/SrvIO";
		
	}
	
	@RequestMapping(value="/InSrv",method=RequestMethod.GET)
	public String InSrv(Locale locale, Model model) {
		try {
		Gson gson = new Gson();
		
		Object o = srvservice.GetSrvParam();
		
		String result = gson.toJson(o);
		
	
		
		
		model.addAttribute("insrvparam",result);
		
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "/Service/InSrv";
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/ajax/GetDetSrv",method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public String GetDetSrv(HttpSession session, @RequestBody String SrvCode, HttpServletResponse response) {
		
		Gson gson = new Gson();
		
		Object o = srvservice.GetDetSrv(SrvCode);
		
		
		System.out.println("from ajax request parameter : "+SrvCode);
		
		String result = gson.toJson(o);
		
		System.out.println(result);
		
		return result;
	}
	
	
}