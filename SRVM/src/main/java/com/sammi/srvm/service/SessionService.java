package com.sammi.srvm.service;

import com.sammi.srvm.dto.EmpDTO;

public interface SessionService {
	public EmpDTO Login(EmpDTO dto, String sessionID);
}
