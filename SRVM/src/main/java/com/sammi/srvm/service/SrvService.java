package com.sammi.srvm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sammi.srvm.dto.SrvDTO;
import com.sammi.srvm.dto.UniEquDTO;

@Service
public interface SrvService {
	public List<SrvDTO> GetAllSrv();
	public Object GetDetSrv(String SrvCode);
	public Object GetSrvParam();
	public int InsertSrv(SrvDTO srvdto,UniEquDTO uniequdto);
	public int InsertByExcel(String filepath);
}
