package com.sammi.srvm.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.sammi.srvm.dto.UniEquDTO;
import com.sammi.srvm.service.EquipmentService;

@Controller
public class EquipmentController {
	
	@Autowired
	EquipmentService equipmentservice;
	
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
