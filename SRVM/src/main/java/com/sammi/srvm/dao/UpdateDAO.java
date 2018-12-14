package com.sammi.srvm.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateDAO{
	@Autowired
	SqlSession sqlSession;
	
	public int UpdateSessionID(Map param) {
		return sqlSession.update("com.sammi.srvm.dao.EmployeeDAO.UpdateSessionID", param);	
	}
}
