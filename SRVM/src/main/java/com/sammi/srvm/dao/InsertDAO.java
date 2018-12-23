package com.sammi.srvm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.dto.SrvDTO;

@Component
public class InsertDAO{
	
	@Autowired
	SqlSession sqlSession;

	
	public int InsertSrv(SrvDTO dto) {
		
		return sqlSession.insert("com.sammi.srvm.dao.InsertDAO.InsertSrv", dto);
		
	}
	
	public int ResisterEmployee(EmpDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
