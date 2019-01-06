package com.sammi.srvm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.CusDTO;
import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.UniEquDTO;

@Service
public class EquipmentServiceImpl implements EquipmentService{
	
	@Autowired
	SelectDAO selectdao;
	
	@Override
	public int InsertUniEqu(UniEquDTO uniequdto) {
		
		String UniEquCode = selectdao.GetUniEquCode(uniequdto);		
		
		if(UniEquCode == null || UniEquCode.equals("")) {
			
			UniEquCode = selectdao.GetNewUniEquCode(UniEquCode);
			
		}
		
		return 0;
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
