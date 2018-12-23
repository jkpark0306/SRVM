package com.sammi.srvm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sammi.srvm.dto.CusDTO;
import com.sammi.srvm.dto.CusEmpDTO;
import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.RepDetDTO;
import com.sammi.srvm.dto.SrvDTO;

@Component
public class SelectDAO{
	@Autowired
	SqlSession sqlSession;
	
	public List<EmpDTO> GetEmpName(){
		return sqlSession.selectList("com.sammi.srvm.dao.SelectDAO.GetEmpName");
	}
	
	public List<CusDTO> GetCusName(){
		return sqlSession.selectList("com.sammi.srvm.dao.SelectDAO.GetCusName");
	}
	
	public List<CusEmpDTO> GetCusEmpName(){
		return sqlSession.selectList("com.sammi.srvm.dao.SelectDAO.GetCusEmpName");
	}
	
	public List<EquDTO> GetPN(){
		return sqlSession.selectList("com.sammi.srvm.dao.SelectDAO.GetPN");
	}
	
	public SrvDTO GetCurSrv(String SrvCode) {
		return sqlSession.selectOne("com.sammi.srvm.dao.SelectDAO.GetCurSrv");
	}

	
	public EmpDTO Login(EmpDTO dto) {
		return sqlSession.selectOne("com.sammi.srvm.dao.SelectDAO.Login",dto);
	}
	

	public ArrayList<EmpDTO> GetAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<CusDTO> GetAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<RepDetDTO> GetRepDet(String SrvCode){
		return sqlSession.selectList("com.sammi.srvm.dao.SelectDAO.GetRepDet",SrvCode);
	}
	
	public List<SrvDTO> GetAllSrv() {
		return sqlSession.selectList("com.sammi.srvm.dao.SelectDAO.GetAllSrv");
	}
	
	public SrvDTO GetDetSrv(String SrvCode) {
		return sqlSession.selectOne("com.sammi.srvm.dao.SelectDAO.GetDetSrv",SrvCode);
	}

}
