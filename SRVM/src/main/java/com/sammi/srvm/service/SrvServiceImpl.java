package com.sammi.srvm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sammi.srvm.dao.InsertDAO;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.CusDTO;
import com.sammi.srvm.dto.CusEmpDTO;
import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.RepDetDTO;
import com.sammi.srvm.dto.SrvDTO;
import com.sammi.srvm.dto.UniEquDTO;


@Service
public class SrvServiceImpl implements SrvService {
	@Autowired
	SelectDAO selectdao;
	InsertDAO insertdao;

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int InsertSrv(SrvDTO srvdto, UniEquDTO uniequdto) {
		
		
		try {
		String UniEquCode = selectdao.GetUniEquCode(uniequdto);
		
		
		
		if(UniEquCode != null) {
			srvdto.setUniEquCode(UniEquCode);
		}else {
		    srvdto.setUniEquCode(selectdao.GetNewUniEquCode(srvdto.getProductNumber()));
		}

		try {
			SrvDTO dto = selectdao.GetNewSrvCode(srvdto.getSrvCode());
			System.out.println(dto.getSrvCode());
		String SrvCode = (selectdao.GetNewSrvCode(srvdto.getSrvCode())).getSrvCode();
		}catch(Exception e) {
			System.out.println("ttt");-
		}
		int result = insertdao.InsertSrv(srvdto);
		return result;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public List<SrvDTO> GetAllSrv() {
		// TODO Auto-generated method stub
		
		return selectdao.GetAllSrv();
	}
	
	private class SrvParamObj{
		private List<EmpDTO> empnames;
		private List<CusDTO> cusnames;
		private List<CusEmpDTO> cusempnames;
		private List<EquDTO> equnames;
	}
	
	@Override
	public Object GetSrvParam() {
		SrvParamObj SPO = new SrvParamObj();
		
		SPO.empnames = selectdao.GetEmpName();
		SPO.cusnames = selectdao.GetCusName();
		SPO.cusempnames = selectdao.GetCusEmpName();
		SPO.equnames = selectdao.GetPN();
		
		EquDTO equdto = SPO.equnames.get(0);
		
		
		System.out.println(equdto.getName());
		
		return SPO;
	}
	
	public class DetSrvObj{
		private SrvDTO srvdto;
		private List<RepDetDTO> repdetdtos;
	}
	
	@Override
	public Object GetDetSrv(String SrvCode) {
		DetSrvObj DSO = new DetSrvObj();
		
		try {
		
		
		
		
		DSO.srvdto = selectdao.GetDetSrv(SrvCode);
		DSO.repdetdtos = selectdao.GetRepDet(SrvCode);
		
		return DSO;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return DSO;
		}
		
		
	}
}