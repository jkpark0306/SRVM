package com.sammi.srvm.controller;

import java.util.HashMap;
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

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.CodeMasterDTO;
import com.sammi.srvm.dto.EmpDTO;

@Controller
public class EmployeeController {
	
	@Autowired
	SelectDAO selectdao;
	
	@RequestMapping(value="/ajax/CheckEmpCode", method=RequestMethod.POST)
	@ResponseBody
	public String CheckEmpCode(HttpSession session, @RequestBody String EmpCode, HttpServletResponse response)
	{
		EmpCode = EmpCode.substring(0, EmpCode.length()-1);
		
		
		
		try {
		String empcode = selectdao.CheckEmpCode(EmpCode);
		
		if(empcode == null || !empcode.equals(EmpCode)) {
			return 
					"G";
		}else {
			return "B";
		}
			
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "";
		}
	}
	
	@RequestMapping(value="/Employee", method=RequestMethod.GET)
	public String Employee(Locale locale, Model model) {
		
		Gson gson = new Gson();
		
		List<EmpDTO> dtos = selectdao.GetAllEmp();
		
		String dtosjson = gson.toJson(dtos);
		
		System.out.println(dtosjson);
		
		model.addAttribute("emplist",dtosjson);
		
		
		return "Employee/Employee";
		
	}
	
	@RequestMapping(value="/InEmp", method=RequestMethod.GET)
	public String InEmp(Locale locale, Model model) {
		
		
		
		Gson gson = new Gson();
		
		List<CodeMasterDTO> dptdto = selectdao.GetAllDepartCode();
		/*
		Map<String, Object> map = new HashMap<String, Object>();
		
		for(int i=0;i<dptdto.size();i++) {
			String DepartCode =dptdto.get(i).getDepartCode();
			dptdto.get(i).setDepartCode(null);
			map.put(DepartCode, dptdto.get(i));
		}
		
		System.out.println(gson.toJson(map));*/
		
		model.addAttribute("inempparam",gson.toJson(dptdto));
		
		
		
		return "Employee/InEmp";
	}

}
