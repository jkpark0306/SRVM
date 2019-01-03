package com.sammi.srvm.service;

import java.util.List;

import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.UniEquDTO;

public interface EquipmentService {
	public List<UniEquDTO> GetAllUniEqu();
	
	
	public List<EquDTO> GetAllEqu();
}
