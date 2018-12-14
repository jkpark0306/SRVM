package com.sammi.srvm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sammi.srvm.dto.CusDTO;
import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.dto.SrvDTO;

public class SelectDAO{
	@Autowired
	SqlSession sqlSession;
	
	
	public EmpDTO Login(EmpDTO dto) {
		System.out.println("this is daoimpl");
		return sqlSession.selectOne("com.sammi.srvm.dao.EmployeeDAO.login",dto);
	}
	

	public ArrayList<EmpDTO> GetAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<CusDTO> GetAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<SrvDTO> GetSrvList() {
		// TODO Auto-generated method stub
		return null;
	}

}
