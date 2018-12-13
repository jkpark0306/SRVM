package com.sammi.srvm.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.google.gson.Gson;
import com.sammi.srvm.dao.EmployeeDAO;
import com.sammi.srvm.dto.EmployeeDTO;
import com.sammi.srvm.service.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	PlatformTransactionManager tx;
	
	@Autowired
	EmployeeService service;
	


	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/ajax/logintry", method = RequestMethod.POST, produces = "application/json;charset=UTF-8") public String LoginTry(@RequestBody String filterJSON, HttpServletResponse response) { response.setCharacterEncoding("UTF-8"); Gson gson = new Gson();
	 * 
	 * 
	 * 
	 * return ""; }
	 */

	// 로그인 처리부분

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/employee/RegEmpID", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		
		return "RegEmpID";
	}
	
	private class InsertEmpReq{
		public EmployeeDTO EmpDTO;
		public ArrayList<EmployeeDTO> EmpList;
		
	}
	
	private class InsertEmpRes{
		int Result = 0;
		public String Message = "";
		public String EmployeeNumber = "";
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/ajax/RegisterEmployee",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String InsertEmployee(@RequestBody String filterJSON, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		InsertEmpReq insertEmpreq = gson.fromJson(filterJSON, InsertEmpReq.class);
		InsertEmpRes insertEmpres = new InsertEmpRes();
		
		DefaultTransactionDefinition df = new DefaultTransactionDefinition();
		df.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus ts = tx.getTransaction(new DefaultTransactionDefinition(df));
		
		try {
			int ret = 1;
			
			//if(insertEmpreq.EmpDTO.getEmpNumber() == )
			EmployeeDAO EmpDAO = sqlSession.getMapper(EmployeeDAO.class);
			for(EmployeeDTO EmpDTO : insertEmpreq.EmpList) {
				ret = EmpDAO.ResisterEmployee(EmpDTO);
				if(ret <= 0) break;
			}
		
			if(ret <= 0) {
				tx.rollback(ts);
				insertEmpres.Result = -1;
				insertEmpres.Message = "rollback!";
				return gson.toJson(insertEmpres);
				
			}
			
			tx.commit(ts);
			
			insertEmpres.Result = 0;
			insertEmpres.EmployeeNumber = insertEmpreq.EmpDTO.getEmpCode();
			return gson.toJson(insertEmpres);
			
		}
		catch(RuntimeException e) {
			tx.rollback(ts);
		}
		
		insertEmpres.Result = -1;
		
		
		return gson.toJson(insertEmpres);
		
	}
	/* Ajax*/
	
	 
	 
	/*
	@ResponseBody
	@RequestMapping(value = "/ajax/update_input_order", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String updateInputOrder(@RequestBody String filterJSON, HttpServletResponse response) {
	    response.setCharacterEncoding("UTF-8");
	    Gson gson = new Gson();
		UpdateInputOrderReq updateIOreq = gson.fromJson(filterJSON, UpdateInputOrderReq.class);
		UpdateInputOrderRes updateIOres = new UpdateInputOrderRes();
        
		DefaultTransactionDefinition df = new DefaultTransactionDefinition();
        df.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus ts = tx.getTransaction(new DefaultTransactionDefinition(df));
        
        try {
        	int ret = 1;
        	
        	if (updateIOreq.InputOrder.getIO_CODE() == 0) {
				InputOrderDAO ioDAO = sqlSession.getMapper(InputOrderDAO.class);
				ret = ioDAO.insertInputOrderDAO(updateIOreq.InputOrder);
				if (ret <= 0) {
					tx.rollback(ts);
					updateIOres.Result = -1;
					updateIOres.Message = "�԰����ü� DB ��� ���� �Դϴ�.";
				    return gson.toJson(updateIOres);
				}
        	}
			        	
			InputDAO inputDAO = sqlSession.getMapper(InputDAO.class);
			for (InputDTO inputDTO : updateIOreq.InputList) {
				inputDTO.getInputOrder().setIO_CODE(updateIOreq.InputOrder.getIO_CODE());
				if (inputDTO.getI_CODE() == 0) {
					ret = inputDAO.insertInputDAO(inputDTO);
					if (ret <= 0) break;
				}
				else {
					ret = inputDAO.updateInputDAO(inputDTO);
					if (ret <= 0) break;
				}
			}
			
			if (ret <= 0) {
				tx.rollback(ts);
				updateIOres.Result = -1;
				updateIOres.Message = "�԰� DB ��� ���� �Դϴ�.";
			    return gson.toJson(updateIOres);
			}

		    tx.commit(ts);
		    
		    updateIOres.Result = 0;
		    updateIOres.IO_CODE = updateIOreq.InputOrder.getIO_CODE();
		    return gson.toJson(updateIOres);
        } catch(RuntimeException re) {
	        tx.rollback(ts);
        }       

        updateIOres.Result = -1;
        return gson.toJson(updateIOres);
	}
	*/
}
