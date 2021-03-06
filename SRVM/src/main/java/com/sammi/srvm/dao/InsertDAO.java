package com.sammi.srvm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.SrvDTO;
import com.sammi.srvm.dto.TestDTO;
import com.sammi.srvm.dto.UniEquDTO;

@Component
public class InsertDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	public int InsertUniEqu(UniEquDTO dto, String SessionID) {
		return sqlSession.insert("com.sammi.srvm.InsertDAO.InsertUniEqu");
	}
	
	public int InsertSessionID(String String) {
		
		return sqlSession.insert("com.sammi.srvm.dao.InsertDAO.InsertSession");
	}
	
	
	public int InsertEqu(EquDTO dto) {
		Gson gson = new Gson();
		System.out.println(gson.toJson(dto));
		return sqlSession.insert("com.sammi.srvm.dao.InsertDAO.InsertEqu",dto);
		
	}
	
	public int InsertSrv(SrvDTO dto) {
		Gson gson = new Gson();
		
		System.out.println("//////////from dao////////"+gson.toJson(dto));
		
		return sqlSession.insert("com.sammi.srvm.dao.InsertDAO.InsertSrv", dto);
		
	}
	
	public int InsertTT(TestDTO dto) {
		
		System.out.println("insertdao insertt start");
		
		dto.setTC1("test1");
		dto.setTC2("test2");
		dto.setTC3("test3");
		
		sqlSession.insert("com.sammi.srvm.dao.InsertDAO.InsertTT",dto);
		
		return 0;
	}
	
	public int ResisterEmployee(EmpDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
