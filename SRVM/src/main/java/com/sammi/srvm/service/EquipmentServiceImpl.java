package com.sammi.srvm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sammi.srvm.dao.InsertDAO;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.CusDTO;
import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.UniEquDTO;

@Service
public class EquipmentServiceImpl implements EquipmentService{
	
	@Autowired
	SelectDAO selectdao;
	
	@Autowired
	InsertDAO insertdao;
	
	
	
	@Override
	public EquDTO GetEquDTObyPN(String ProductNumber) {
		
		return selectdao.GetEquDTObyPN(ProductNumber);
		
	}
	
	@Override
	public String GetEquCatCode(String EquCat) {
		return selectdao.GetEquCatCode(EquCat);
	}
	
	@Override
	public int InsertEqu(EquDTO equdto, String SessionID) {
		
		
		String id = selectdao.GetID(SessionID);
		
		equdto.setCREATE_ID(id);
		
		//String EquCat = equdto.getEquCat();
		
		
		//String EquCatCode = selectdao.GetEquCatCode(EquCat);
		
		
		
		
		int result = insertdao.InsertEqu(equdto);
		
		
		return result;
		
	}
	
	
	
	@Override
	public int InsertUniEqu(UniEquDTO uniequdto, String SessionID) {
		
		Gson gson = new Gson();
		
		 
		uniequdto.setCREATE_ID(selectdao.GetID(SessionID));
		
		
		
		System.out.println(gson.toJson(uniequdto));
		
		
		return 0;
	}
	
	@Override
	public Map<String, Object> GetInUniEquParam(){
		
		List<CusDTO> cusdtos = selectdao.GetAllCusName();
		
		List<EquDTO> equdtos = selectdao.GetAllEqu();
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cusdtos", cusdtos);
		
		map.put("equdtos", equdtos);
		
		return map;
	
	}
	
	@Override
	public Map<String, Object> GetInEquParam(){
		Gson gson = new Gson();
		
		List<CusDTO> cusdtos = selectdao.GetAllCusName();
		
		List<EquDTO> equdtos = selectdao.GetAllPN();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cusdtos", cusdtos);
		
		map.put("equdtos", equdtos);
		
		System.out.println(gson.toJson(map));
		
		return map;
		
	}
	
	
	@Override
	public List<EquDTO> GetAllEqu(){
		Gson gson = new Gson();
		
		List<EquDTO> dtos = selectdao.GetAllEqu();
		
		System.out.println(gson.toJson(dtos));
		
		return dtos;
		//List<EquDTO> dtos = selectdao.get
	}
	
	@Override
	public List<UniEquDTO> GetAllUniEqu() {
		
		Gson gson = new Gson();
		
		List<UniEquDTO> dtos = selectdao.GetAllUniEqu();
		
		System.out.println(gson.toJson(dtos));
		
		return dtos;
	}
	
	
	
}
