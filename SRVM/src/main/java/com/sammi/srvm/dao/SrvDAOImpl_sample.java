package com.sammi.srvm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sammi.srvm.dto.SrvDTO;

@Repository
public class SrvDAOImpl_sample implements SrvDAO_sample{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<SrvDTO> GetSrvList(){
		return sqlSession.selectList("com.sammi.srvm.dao.SrvDAO.SrvSelect");
		
	}
	
	@Override
	public List<SrvDTO> GetDetSrv(String SrvCode) {
		
		return sqlSession.selectList("com.sammi.srvm.dao.SrvDAO.GetDetSrv",SrvCode);
	}

}
