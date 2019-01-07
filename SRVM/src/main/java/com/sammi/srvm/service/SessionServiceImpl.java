package com.sammi.srvm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dao.UpdateDAO;
import com.sammi.srvm.dto.EmpDTO;

@Service
public class SessionServiceImpl implements SessionService{
	
	@Autowired
	SelectDAO seldao;
	
	@Autowired
	UpdateDAO updao;
	
	@Autowired
	PlatformTransactionManager tx;
	
	public class LoginParameter{
		String SessionID;
		EmpDTO dto;
		
	}
	
	
	
	@Override
	public EmpDTO Login(EmpDTO dto, String sessionID) {
		
		System.out.println("Login Service Start");
		
		try {
		DefaultTransactionDefinition df = new DefaultTransactionDefinition();
		df.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus ts = tx.getTransaction(new DefaultTransactionDefinition(df));
		
		EmpDTO resultDTO;
		
		resultDTO = seldao.Login(dto);
		
		System.out.println(resultDTO.getEmpCode());
		
		Map <String, String> SessionIDparam = new HashMap<String, String>();
		
		SessionIDparam.put("SessionID", sessionID);
		SessionIDparam.put("EmpCode", resultDTO.getEmpCode());
		
		int i = updao.UpdateSessionID(SessionIDparam);
		
		System.out.println("affected rows "+i);
		
		
		/*
		try {
		if(resultDTO != null) {
			SessionIDparam.put("sessionID", sessionID);
			SessionIDparam.put("EmpCode", resultDTO.getEmpCode());
			updao.UpdateSessionID(SessionIDparam);
			tx.commit(ts);
		}else {
			tx.rollback(ts);
			
		}
		}catch(Exception ex) {
			System.out.println("Exception from update");
		}*/
		return resultDTO;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			return null;
		}
		
	};
		
}
