package com.sammi.srvm.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.SrvDTO;

public class SrvServiceImpl implements SrvService {
	@Autowired
	SelectDAO selectdao;

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<SrvDTO> GetAllSrv() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.sammi.srvm.dao.SrvDAO.SrvSelect");
	}
	
	@Override
	public SrvDTO GetDetSrv(String SrvCode) {
		return sqlSession.selectOne("com.sammi.srvm.dao.SrvDAO.GetDetSrv",SrvCode);
	}
}