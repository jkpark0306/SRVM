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
import com.sammi.srvm.dto.CusDTO;
import com.sammi.srvm.dto.CusEmpDTO;
import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.RepDetDTO;
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
	
	private class SrvParamObj{
		private List<EmpDTO> empdtos;
		private List<CusDTO> cusdtos;
		private List<CusEmpDTO> cusempdtos;
		private List<EquDTO> equdtos;
	}
	
	@Override
	public Object GetSrvParam() {
		SrvParamObj SPO = new SrvParamObj();
		
		SPO.empdtos = selectdao.GetEmpName();
		SPO.cusdtos = selectdao.GetCusName();
		SPO.cusempdtos = selectdao.GetCusEmpName();
		SPO.equdtos = selectdao.GetPN();
		
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