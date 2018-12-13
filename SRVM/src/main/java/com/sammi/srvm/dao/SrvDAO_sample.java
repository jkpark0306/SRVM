package com.sammi.srvm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sammi.srvm.dto.SrvDTO;

@Repository
public interface SrvDAO_sample {
	public List<SrvDTO> GetSrvList();
	public List<SrvDTO> GetDetSrv(String SrvCode);

}
