package com.sammi.srvm.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.CodeMasterDTO;
import com.sammi.srvm.dto.EmpDTO;

@Controller
public class EmployeeController {
	
	@Autowired
	SelectDAO selectdao;
	
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
		
		model.addAttribute("inempparam",dptdto);
		
		
		
		return "Employee/InEmp";
	}

}
