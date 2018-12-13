package com.sammi.srvm.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.sammi.srvm.dao.EmployeeDAO;
import com.sammi.srvm.dao.SrvDAO_sample;
import com.sammi.srvm.dto.EmployeeDTO;
import com.sammi.srvm.dto.SrvDTO;

/**
 * Handles requests for the application home page.
 */



@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public String ParDate(String DateTimeValue)
    {
        String dt = DateTimeValue;
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        String Resultstr = "";
         
        try
        {
            Date date = format.parse(DateTimeValue);
            SimpleDateFormat resultFormat = new SimpleDateFormat("yyyy-MM-dd");
            Resultstr = resultFormat.format(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
         
        return Resultstr;
    }
	
	@Autowired
	private SqlSession sqlSession;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println("this is Homecontroller");
		try {
			SrvDAO_sample dao = sqlSession.getMapper(SrvDAO_sample.class);
			List<SrvDTO> dtos = dao.GetSrvList();
			ArrayList<Object> paramList = new ArrayList<Object>();
			
			for(SrvDTO dto : dtos) {
				Map<String,Object> param = new HashMap<String,Object>();
				
				param.put("SrvCode", dto.getSrvCode());
				param.put("UniEquCode", dto.getUniEquCode());
				System.out.println("Unicode from HomeController = "+dto.getUniEquCode());
				param.put("InDate", ParDate(dto.getSrvCode().substring(0, 6)));
				param.put("EmpName", dto.getEmpName());
				param.put("CusName", dto.getCusName());
				param.put("CusEmpName", dto.getCusEmpName());
				param.put("SerialNumber", dto.getSerialNumber());
				param.put("ProductNumber", dto.getProductNumber());
				param.put("Process", dto.getProcess());
				
				
				
				paramList.add(param);
			}
			
			model.addAttribute("SRVLIST", paramList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
	
}