package com.sammi.srvm.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sammi.srvm.dto.TestDTO;



@Component
public class TestDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public int InsertTT(TestDTO dto) {
		
		return sqlSession.insert("com.sammi.srvm.dao.TestDAO.InsertTT", dto);
		
		
	}
}
