package com.sammi.srvm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dao.UpdateDAO;
import com.sammi.srvm.dto.EmpDTO;

public class SessionServiceImpl implements SessionService{
	@Autowired
	SelectDAO seldao;
	UpdateDAO updao;
	
	public class LoginParameter{
		String SessionID;
		EmpDTO dto;
		
	}
	
	@Override
	public String Login(String param) {
		
		Gson gson = new Gson();
		
		LoginParameter LP = gson.fromJson(param, LoginParameter.class);
		
		
		
		EmpDTO resultDTO;
		
		resultDTO = seldao.Login(dto);
		
		if(resultDTO != null) {
			parammap.put("sessionID", resultDTO.getEmpCode());
			parammap.put("EmpCode", resultDTO.getEmpCode());
			int result = updao.updatesession(parammap);
		}
		
		Map<EmpDTO, String> resultmap = new HashMap<EmpDTO,String>();
		resultmap.put("EmpDTO", resultDTO);
		
		
		
		return "";
		
	};
		
}
