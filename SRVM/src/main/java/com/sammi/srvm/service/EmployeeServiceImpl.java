package com.sammi.srvm.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sammi.srvm.dao.EmployeeDAO;
import com.sammi.srvm.dto.EmployeeDTO;

@Repository
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDAO dao;
	
	

	@Override
	public EmployeeDTO login(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}



	@Override
	public int updatesession(Map<String, String> parammap/*String sessionID, String EmpNumber*/) {
		return dao.updatesession(parammap);
		// TODO Auto-generated method stub
		
	}

	


	
}
