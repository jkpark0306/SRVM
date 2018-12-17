package com.sammi.srvm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.SrvDTO;

@Service
public class SrvServiceImpl implements SrvService {
	@Autowired
	SelectDAO selectdao;

	@Autowired
	SqlSession sqlSession;
	
	

	@Override
	public List<SrvDTO> GetAllSrv() {
		// TODO Auto-generated method stub
		
		return selectdao.GetAllSrv();
	}
	
	@Override
	public SrvDTO GetDetSrv(String SrvCode) {
		return sqlSession.selectOne("com.sammi.srvm.dao.SrvDAO.GetDetSrv",SrvCode);
	}
}