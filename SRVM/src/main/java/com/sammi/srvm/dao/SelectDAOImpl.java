package com.sammi.srvm.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sammi.srvm.dto.CusDTO;
import com.sammi.srvm.dto.EmpDTO;

public class SelectDAOImpl implements SelectDAO{
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public EmpDTO Login(EmpDTO dto) {
		System.out.println("this is daoimpl");
		return sqlSession.selectOne("com.sammi.srvm.dao.EmployeeDAO.login",dto);

	}
	

	@Override
	public ArrayList<EmpDTO> GetAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<CusDTO> GetAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
