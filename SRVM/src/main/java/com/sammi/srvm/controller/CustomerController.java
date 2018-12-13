package com.sammi.srvm.controller;


import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sammi.srvm.dao.CustomerDAO;

@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/customer/CustomerMan",method=RequestMethod.GET)
	public String customer(Locale locale, Model model) {
		
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		
		
		return "/customer/CustomerMan";
	}
	
}
