package com.sammi.srvm.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateDAOImpl implements UpdateDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int updatesession(Map parammap/* @Param("sessionID") String sessionID, @Param("EmpNumber") String EmpNumber*/) {
		return sqlSession.update("com.sammi.srvm.dao.EmployeeDAO.updatesession", parammap);	
	}
}
