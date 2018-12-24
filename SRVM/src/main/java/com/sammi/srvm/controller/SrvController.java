package com.sammi.srvm.controller;

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
import com.sammi.srvm.dto.UniEquDTO;
import com.sammi.srvm.service.SrvService;
import com.sammi.srvm.service.SrvServiceImpl;


@Controller
public class SrvController {
	
	@Autowired
	SrvService srvservice;
	
	public class tc{
		public String td1;
		public String td2;
		public String td3;
	}	
	
	public class InSrvParam{
		public SrvDTO srvdto;
		public UniEquDTO uniequdto;
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax/InSrv",method=RequestMethod.POST,produces="application/json; charset=UTF-8")
	public String InSrv(HttpSession session, @RequestBody String param,HttpServletResponse response) {
		System.out.println(param);
		
		Gson gson = new Gson();
		
		InSrvParam insrvparam = gson.fromJson(param, InSrvParam.class);
		
		System.out.println(gson.toJson(insrvparam));
		
		int result = srvservice.InsertSrv(insrvparam.srvdto, insrvparam.uniequdto);
		
		System.out.println(result);
		/*
		srvservice.InsertSrv(srvdto, uniequdto)
		*/
		
		return "";
	}
	
	
	@RequestMapping(value="/InSrv",method=RequestMethod.GET)
	public String InSrv(Locale locale, Model model) {
		try {
		Gson gson = new Gson();
		
		Object o = srvservice.GetSrvParam();
		
		String result = gson.toJson(o);
		
	
		
		System.out.println(result);
		
		model.addAttribute("test",result);
		
		
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