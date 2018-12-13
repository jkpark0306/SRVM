package com.sammi.srvm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dao.UpdateDAO;
import com.sammi.srvm.dto.EmpDTO;

public class SessionService {
	@Autowired
	SelectDAO seldao;
	UpdateDAO updao;
	
	
	
	public Map<String, Object> Login(EmpDTO dto, Map<String,String> parammap) {
		
		EmpDTO resultDTO;
		
		resultDTO = seldao.Login(dto);
		
		if(resultDTO != null) {
			parammap.put("sessionID", resultDTO.getEmpCode());
			parammap.put("EmpCode", resultDTO.getEmpCode());
			int result = updao.updatesession(parammap);
		}
		
		Map<EmpDTO, String> resultmap = new HashMap<EmpDTO,String>();
		resultmap.put("EmpDTO", resultDTO);
		
		
		
		return resultmap;
		
	};
		
}
