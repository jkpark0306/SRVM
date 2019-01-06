package com.sammi.srvm.service;

import java.util.List;
import java.util.Map;

import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.UniEquDTO;

public interface EquipmentService {
	
	public int InsertUniEqu(UniEquDTO uniequdto);
	
	public Map<String, Object> GetInEquParam();
	
	public List<UniEquDTO> GetAllUniEqu();
	
	
	public List<EquDTO> GetAllEqu();
}
