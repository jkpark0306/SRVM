package com.sammi.srvm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sammi.srvm.dto.SrvDTO;


public interface SrvService {
	public List<SrvDTO> GetAllSrv();
	public Object GetDetSrv(String SrvCode);
}
