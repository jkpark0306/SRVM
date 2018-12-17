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
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.dto.SrvDTO;
import com.sammi.srvm.service.SrvService;
import com.sammi.srvm.service.SrvServiceImpl;

/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	@Autowired
	SrvServiceImpl srvservice;
	
	@Autowired
	private SqlSession sqlSession;

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
	


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		

		
		try {
			System.out.println("1");
			List<SrvDTO> dtos = srvservice.GetAllSrv();
			System.out.println("2");
			ArrayList<Object> paramList = new ArrayList<Object>();
			System.out.println("3");
			
			for(SrvDTO dto : dtos) {
				Map<String,Object> param = new HashMap<String,Object>();
				
				param.put("SrvCode", dto.getSrvCode());
				param.put("UniEquCode", dto.getUniEquCode());
				param.put("InDate", ParDate(dto.getSrvCode().substring(0, 6)));
				param.put("EmpName", dto.getEmpName());
				param.put("CusName", dto.getCusName());
				param.put("CusEmpName", dto.getCusEmpName());
				param.put("SerialNumber", dto.getSerialNumber());
				param.put("ProductNumber", dto.getProductNumber());
				param.put("Process", dto.getProcess());
				
				
				
				paramList.add(param);
			}
			System.out.println("4");
			model.addAttribute("SRVLIST", paramList);
		} catch (Exception e) {
			System.out.println(e.getMessage()+" from home controller");
		}
		return "home";
	}
	
}