package com.sammi.srvm.service;

import java.util.HashMap;
import java.util.Map;

import com.sammi.srvm.dto.EmpDTO;

public interface SessionService {
	
	
	public EmpDTO Login(EmpDTO dto, String sessionID);
	
	
}
