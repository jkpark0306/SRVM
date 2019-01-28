package com.sammi.srvm.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.UniEquDTO;
import com.sammi.srvm.service.EquipmentService;

@Controller
public class EquipmentController {
	
	@Autowired
	EquipmentService equipmentservice;
	
	@Autowired
	SelectDAO selectdao;
	
	
	Gson gson = new Gson();
	
	
	@ResponseBody
	@RequestMapping(value="/ajax/GetNewUniEquCode", method=RequestMethod.POST)
	public String GetNewUniEquCode(HttpSession session, @RequestBody String UniEquCode, HttpServletResponse response) {
		
		String newUniEquCode = selectdao.GetNewUniEquCode(UniEquCode);
		
		if(newUniEquCode == null || newUniEquCode == "") {
			return UniEquCode;
		}else {
			return newUniEquCode;
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax/GetNewEquCode", method=RequestMethod.POST)
	public String GetNewEquCode(HttpSession session, @RequestBody String EquCode, HttpServletResponse response) {
		
		
		String newEquCode = selectdao.GetNewEquCode(EquCode);
		
		System.out.println("new EquCode = "+newEquCode);
		
		return newEquCode;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax/GetEquDTObyPN", method=RequestMethod.POST)
	public String GetEquDTObyPN(HttpSession session,@RequestBody String ProductNumber, HttpServletResponse response) {
		
		
		EquDTO dto = equipmentservice.GetEquDTObyPN(ProductNumber);
		
		System.out.println(gson.toJson(dto));
		
		return gson.toJson(dto);
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajax/GetEquCatCode", method=RequestMethod.POST)
	public String GetEquCatCode(HttpSession session, @RequestBody String EquCat, HttpServletResponse response) {
		
		
		
		
		EquCat = EquCat.substring(0, EquCat.length()-1);
		String EquCatCode = equipmentservice.GetEquCatCode(EquCat);
		
		return EquCatCode;
		
	}
	

	@ResponseBody
	@RequestMapping(value = "/ajax/InUniEqu", method=RequestMethod.POST)
	public String InsertUniEqu(HttpSession session, @RequestBody String filterJSON, HttpServletResponse response)
	{
		Gson gson = new Gson();
		
		UniEquDTO uniequdto = gson.fromJson(filterJSON, UniEquDTO.class);
		
		int result = equipmentservice.InsertUniEqu(uniequdto,session.getId());
		
		
		
		return "";
	}
	
	@RequestMapping(value = "/ajax/InUniEqubyExcel")
	@ResponseBody
	public String InUniEqubyExcel(MultipartHttpServletRequest request) throws Exception{
		Gson gson = new Gson();
		
		SimpleDateFormat filenameformat = new SimpleDateFormat("yyyyMMddHHmm");
		SimpleDateFormat folderformat = new SimpleDateFormat("yyyyMM");
		
		MultipartFile excelfile = request.getFile("excelFile");
		if(excelfile == null || excelfile.isEmpty()) {
			throw new RuntimeException("파일을 선택하십시오");
		}
		
		String filename = filenameformat.format(new Date())+".xls";
		String foldername = folderformat.format(new Date());
		
		String os = System.getProperty("os.name");
		String windowpath = "C:\\Users\\jkpark\\Documents\\SRVM\\Excel\\InUniEqu\\Import\\";
		String centospath = "/home/jkpark/SRVM/Excel/InUniEqu/Import/";
		
		
		
		
			
		String filepath = "";
		String folderpath = "";
		File Dir = null;
		System.out.println(os);
		
		if(os.toUpperCase().startsWith("WINDOW")) {
			
			folderpath = windowpath +"\\"+ foldername;
			Dir = new File(folderpath);
			
			if(!Dir.exists()) {
				Dir.mkdirs();
			}
			filepath = folderpath+"\\"+filename;
		}else {
			filepath = centospath;
			folderpath = centospath + '/'+foldername;
			Dir = new File(folderpath);
			
			if(!Dir.exists()) {
				Dir.mkdirs();
			}
			filepath = folderpath + '/'+filename;
		}
		
		File destfile = new File(filepath);
		
		
		try {
			excelfile.transferTo(destfile);
		}catch(IllegalStateException | IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		equipmentservice.InUniEqubyExcel(filepath);
		
		
		
		
		
		
		return "s";
		
		
	}
	
	@RequestMapping(value="/ajax/InEqu")
	@ResponseBody
	public String InsertEqu(HttpSession session, @RequestBody String filterJSON, HttpServletResponse response)
	{
		Gson gson = new Gson();
		
	
		
		
		EquDTO dto = gson.fromJson(filterJSON, EquDTO.class);
		
		System.out.println(filterJSON);
		
		int result = equipmentservice.InsertEqu(dto, session.getId());
		
		if(result == 1) {
			return "s";
		}else {
			return "f";
		}
		
		
	}
	
	@RequestMapping(value="/InEqu", method=RequestMethod.GET)
	public String InEqu(Locale locale, Model model) {
		
		Gson gson = new Gson();
		
		Map<String, Object> map = equipmentservice.GetInEquParam();
		
		model.addAttribute("InEquParam",gson.toJson(map));
		
		//List<CusDTO> cusdtos = 
		
		
		
		return "Equipment/InEqu";
	}
	
	@RequestMapping(value="/Equ", method=RequestMethod.GET)
	public String Equ(Locale locale, Model model){
		
		Gson gson = new Gson();
		
		List<EquDTO> dto = equipmentservice.GetAllEqu();
		
		model.addAttribute("equlist",dto);
		
		
		
		return "Equipment/Equ";
	}
	

	
	@RequestMapping(value="/InUniEqu", method=RequestMethod.GET)
	public String InEUniEqu(Locale locale, Model model) {
		
		Gson gson = new Gson();
		
		Map<String, Object> map = equipmentservice.GetInUniEquParam();
		
		System.out.println(gson.toJson(map));
		
		model.addAttribute("InUniEquParam",gson.toJson(map));
		
		return "Equipment/InUniEqu";
	}
	
	@RequestMapping(value="/UniEqu", method=RequestMethod.GET)
	public String UniEqu(Locale locale, Model model) {
		
		System.out.println("requestmapping test");
		
		Gson gson = new Gson();
		
		List<UniEquDTO> uniequlist = equipmentservice.GetAllUniEqu();
		
		String param = gson.toJson(uniequlist);
		
		
		
		
		model.addAttribute("uniequlist",param);
		
		
		
		
		
		
	
		return "Equipment/UniEqu";
	}
}
