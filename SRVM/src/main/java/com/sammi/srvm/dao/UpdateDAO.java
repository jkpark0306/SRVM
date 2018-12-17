package com.sammi.srvm.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateDAO{
	@Autowired
	SqlSession sqlSession;
	
	public int UpdateSessionID(Map param) {
		return sqlSession.update("com.sammi.srvm.dao.UpdateDAO.UpdateSessionID", param);	
	}
}
