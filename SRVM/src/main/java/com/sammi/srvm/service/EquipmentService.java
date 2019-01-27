package com.sammi.srvm.service;

import java.util.List;
import java.util.Map;

import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.UniEquDTO;

public interface EquipmentService {
	
	public int InsertUniEqu(UniEquDTO uniequdto, String SessionID);
	
	public Map<String, Object> GetInEquParam();
	
	public List<UniEquDTO> GetAllUniEqu();
	
	
	public List<EquDTO> GetAllEqu();

	int InsertEqu(EquDTO equdto, String SessionID);
	
	public String GetEquCatCode(String EquCat);
	
	public EquDTO GetEquDTObyPN(String ProductNumber);

	Map<String, Object> GetInUniEquParam();
	
	public int InUniEqubyExcel(String filepath);
	
	
	
}
