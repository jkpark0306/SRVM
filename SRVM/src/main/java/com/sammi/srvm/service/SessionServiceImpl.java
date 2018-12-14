package com.sammi.srvm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dao.UpdateDAO;
import com.sammi.srvm.dto.EmpDTO;

public class SessionServiceImpl implements SessionService{
	
	@Autowired
	SelectDAO seldao;
	UpdateDAO updao;
	
	@Autowired
	PlatformTransactionManager tx;
	
	public class LoginParameter{
		String SessionID;
		EmpDTO dto;
		
	}
	
	@Override
	public EmpDTO Login(EmpDTO dto, String sessionID) {
		

		
		DefaultTransactionDefinition df = new DefaultTransactionDefinition();
		df.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus ts = tx.getTransaction(new DefaultTransactionDefinition(df));

		
		EmpDTO resultDTO;
		
		resultDTO = seldao.Login(dto);
		
		Map <String, String> SessionIDparam = new HashMap<String, String>();
		
		if(resultDTO != null) {
			SessionIDparam.put("sessionID", sessionID);
			SessionIDparam.put("EmpCode", resultDTO.getEmpCode());
			updao.UpdateSessionID(SessionIDparam);
			tx.commit(ts);
		}else {
			tx.rollback(ts);
		}
		
		return resultDTO;
		
	};
		
}
