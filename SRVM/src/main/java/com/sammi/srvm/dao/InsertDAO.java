package com.sammi.srvm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.dto.SrvDTO;
import com.sammi.srvm.dto.TestDTO;

@Component
public class InsertDAO{
	
	@Autowired
	SqlSession sqlSession;

	
	public int InsertSrv(SrvDTO dto) {
		System.out.println(dto.getSrvCode());
		
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
