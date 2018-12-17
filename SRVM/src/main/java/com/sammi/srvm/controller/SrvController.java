package com.sammi.srvm.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sammi.srvm.dto.SrvDTO;
import com.sammi.srvm.service.SrvService;
import com.sammi.srvm.service.SrvServiceImpl;


@Controller
public class SrvController {
	
	@Autowired
	SrvService srvservice;
	
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