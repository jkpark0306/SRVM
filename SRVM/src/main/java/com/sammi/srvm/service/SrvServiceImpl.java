package com.sammi.srvm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sammi.srvm.ExcelRead;
import com.sammi.srvm.ExcelReadOption;
import com.sammi.srvm.dao.InsertDAO;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dao.TestDAO;
import com.sammi.srvm.dto.CusDTO;
import com.sammi.srvm.dto.CusEmpDTO;
import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.dto.EquDTO;
import com.sammi.srvm.dto.RepDetDTO;
import com.sammi.srvm.dto.SrvDTO;
import com.sammi.srvm.dto.TestDTO;
import com.sammi.srvm.dto.UniEquDTO;


@Service
public class SrvServiceImpl implements SrvService {
	@Autowired
	SelectDAO selectdao;
	
	@Autowired
	InsertDAO insertdao;
	
	@Autowired
	TestDAO testdao;
	

	@Autowired
	SqlSession sqlSession;

	@Override
	public int InsertByExcel(String filepath) {
		
		
		
		ExcelReadOption option = new ExcelReadOption();
		
		option.setFilePath(filepath);

		List<String> columnlist = new ArrayList<String>();
		
		columnlist.add("SrvCode");
		
		columnlist.add("�엯怨좎씪");
		
		columnlist.add("�닔由ъ씪");
		
		columnlist.add("異쒓퀬�씪");
		
		columnlist.add("�옣鍮꾨챸");
		
		option.setOutputColumn(columnlist);
		
		option.setStartRow(0);
		
		
		
		
		
		
		//List<Map<String,String>> excellist =  ExcelRead.read(option);
		
		Gson gson = new Gson();
		
		//System.out.println(gson.toJson(excellist));
		
		
		
		
		
		return 0;
	}
	@Override
	public int InsertSrv(SrvDTO srvdto, UniEquDTO uniequdto) {
		
		Gson gson = new Gson();
		
		try {
		String UniEquCode = selectdao.GetUniEquCode(uniequdto);

		
		if(UniEquCode != null) {
			srvdto.setUniEquCode(UniEquCode);
		}else {
		    srvdto.setUniEquCode(selectdao.GetNewUniEquCode(srvdto.getProductNumber()));
		}

		try {
			SrvDTO dto = selectdao.GetNewSrvCode(srvdto.getSrvCode());
			if(dto == null) {
				System.out.println("null checked");
				
			}else {
				srvdto.setSrvCode(dto.getSrvCode());
				System.out.println("this is new SRVCODE "+dto.getSrvCode());
			}
			
		}catch(Exception e) {
		}
		
		srvdto.setEmpCode("1509011");
		
		srvdto.setCREATE_ID("jkpark");
		
		srvdto.setUniEquCode(UniEquCode);
		
		srvdto.setObtFlag("Y");
		
		srvdto.setOrdFlag("Y");
		
		srvdto.setRelFlag("N");
		
		srvdto.setPartSrvFlag("N");
		
		System.out.println(gson.toJson(srvdto));
		
		
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
		
		List<SrvDTO> srvdtos = selectdao.GetAllSrv();
		for(int i=0;i<srvdtos.size();i++) {
			
			SrvDTO dto = srvdtos.get(i);
			
			String SrvCode = dto.getSrvCode();
			
			String y = "20" +SrvCode.substring(0, 2);
			String m = SrvCode.substring(2,4);
			String d = SrvCode.substring(4,6);
			
			String Indate = y+'-'+m+'-'+d;
			
			dto.setInDate(Indate);
			
			srvdtos.set(i, dto);
		}
		
		System.out.println(srvdtos.get(0).getInDate());
		
		
		
		
		return srvdtos;
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
		
		
		
		SPO.empnames = selectdao.GetAllEmpName();
		SPO.cusnames = selectdao.GetAllCusName();
		SPO.cusempnames = selectdao.GetAllCusEmpName();
		SPO.equnames = selectdao.GetAllPN();
		
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