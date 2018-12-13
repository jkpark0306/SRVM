package com.sammi.srvm.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.sammi.srvm.dto.CusDTO;
import com.sammi.srvm.dto.EmpDTO;

@Repository
public interface SelectDAO {
	public ArrayList<CusDTO> GetAllCustomer();
	public ArrayList<EmpDTO> GetAllEmployee();
	public EmpDTO Login(EmpDTO dto);
	
}
