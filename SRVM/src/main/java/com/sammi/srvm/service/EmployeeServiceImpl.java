package com.sammi.srvm.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.CodeMasterDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	SelectDAO selectdao;
	
	public String GetInEmpParam() {
		Gson gson = new Gson();
		//CodeMasterDTO dptdto = selectdao.GetAllDepartCode();
		
		
		
		
		
		return gson.toJson("");
		
	}
	


	
}
