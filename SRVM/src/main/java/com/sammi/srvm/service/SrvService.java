package com.sammi.srvm.service;

import java.util.List;

import com.sammi.srvm.dto.SrvDTO;

public interface SrvService {
	public List<SrvDTO> GetSrvList();
	public SrvDTO GetDetSrv(String SrvCode);
	

}
