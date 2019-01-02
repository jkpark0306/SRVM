package com.sammi.srvm.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.UniEquDTO;

@Service
public class EquipmentServiceImpl implements EquipmentService{
	
	@Autowired
	SelectDAO selectdao;
	
	
	
	@Override
	public List<UniEquDTO> GetAllUniEqu() {
		
		Gson gson = new Gson();
		
		List<UniEquDTO> dtos = selectdao.GetAllUniEqu();
		
		System.out.println(gson.toJson(dtos));
		
		return dtos;
	}
	
	
	
}
