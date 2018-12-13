package com.sammi.srvm.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;
import com.sammi.srvm.SecurityUtil;
import com.sammi.srvm.dao.TestDAO;
import com.sammi.srvm.dto.TestDTO;

@Controller
public class TestController {

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	PlatformTransactionManager tx;

	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	public String Test(Locale locale, Model model) {
		
		System.out.println("TestController");
		try {
		TestDAO dao = sqlSession.getMapper(TestDAO.class);
		ArrayList<TestDTO> dtos = dao.TestSelect();
		model.addAttribute("TestList", dtos);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return "Test";
	}

	
	
	private class TestDeleteReq{
		public String IDX1;
		public String IDX2;
		public String IDX3;
	}
	
	private class TestDeleteRes{
		public String Message;
		public int Result;
	}
	

	
	
	@ResponseBody
	@RequestMapping(value = "/ajax/test_delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String testdelete(@RequestBody String filterJSON, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		
		TestDeleteReq TRQ = gson.fromJson(filterJSON, TestDeleteReq.class);
		TestDeleteRes TRS = new TestDeleteRes();
		
		DefaultTransactionDefinition df = new DefaultTransactionDefinition();
		df.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus ts = tx.getTransaction(new DefaultTransactionDefinition(df));
		
		try {
			int ret = -1;
			
			for(int i = 0;i<3;i++)
			{
				
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "";
	}

	private class TestInsertReq {
		public TestDTO InsertDTO;
		public String QTY;
	}

	private class TestInsertRes {
		public int Result = 0;
		public String Message = "";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajax/test_insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String testinsert(@RequestBody String filterJSON, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		
		SecurityUtil SU = new SecurityUtil();
		
		TestInsertReq TIR = gson.fromJson(filterJSON, TestInsertReq.class);
		TestInsertRes TIS = new TestInsertRes();
		
		TIR.InsertDTO.setTC1(SU.encryptSHA256(TIR.InsertDTO.getTC1()));
		
		SU = new SecurityUtil();
		TIR.InsertDTO.setTC2(SU.encryptSHA256(TIR.InsertDTO.getTC2()));
		String TC1 =TIR.InsertDTO.getTC1();
		String TC2 = TIR.InsertDTO.getTC2();
		if(TC1.equals(TC2))
		{
			TIR.InsertDTO.setTC3("true");
		}
		else {
			TIR.InsertDTO.setTC3("false");
		}
		
	

		DefaultTransactionDefinition df = new DefaultTransactionDefinition();
		df.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus ts = tx.getTransaction(new DefaultTransactionDefinition(df));
		
		try {
			int ret = 1;

			int qty = Integer.parseInt(TIR.QTY);

			TestDAO tdao = sqlSession.getMapper(TestDAO.class);

			for (int i = 0; i < qty; i++) {
				ret = tdao.TestInsert(TIR.InsertDTO);
				if (ret <= 0)
					break;
			}
			tx.commit(ts);

			TIS.Result = 0;
			
			return gson.toJson(TIS);

		} catch (RuntimeException re) {
			tx.rollback(ts);
			System.out.println(re.getMessage());
		}
		
		TIS.Result = -1;

		return gson.toJson(TIS);

	}
}
