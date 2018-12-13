package com.sammi.srvm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sammi.srvm.dto.EmpDTO;
import com.sammi.srvm.service.SessionService;

@Controller
public class SessionController {

	@Autowired
	SessionService sessionservice;

	@Autowired
	PlatformTransactionManager tx;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "Login/login";
	}

	private class LoginReq {
		public EmpDTO empdto;
	}

	private class LoginRes {
		public String Message;
		public int Result;
		public String SessionID;
	}
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
	@ResponseBody
	@RequestMapping(value = "/ajax/logintry", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String Login(HttpSession session, @RequestBody String filterJSON, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		System.out.println("starting login process..");
		Gson gson = new Gson();
		
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		LoginReq LQ = gson.fromJson(filterJSON, LoginReq.class);
		LoginRes LR = new LoginRes();
		
		System.out.println(filterJSON);
		System.out.println(gson.toJson(LQ));

		Map<String, String> parammap = new HashMap<String, String>();
		
		
		session.setAttribute("login", sessionservice.Login(LQ.empdto, session.getId()));
		
		if(LQ.empdto != null) {
			return "S";
		}else
		{
			return "F";
		}
		
		
		
		/*
		try {

			LR.Result = 1;

			if (session.getAttribute("login") != null) {
				session.removeAttribute("login");
			}

			EmployeeDTO dto = service.login(LQ.empdto);

			if (dto != null) {
				System.out.println(dto.getEmpCode());
				session.setAttribute("login", dto);
				parammap.put("sessionID", session.getId());
				parammap.put("EmpCode", dto.getEmpCode());
				int result = service.updatesession(parammap);
				System.out.println("id = "+dto.getID() );
				System.out.println("empcode = "+dto.getEmpCode());
				System.out.println("updatesession return " + result);
				if (result == 1) {
					LR.Result = result;
					LR.Message = "Login Success";
					LR.SessionID = session.getId();
					session.setAttribute("login", LQ.empdto);
					tx.commit(ts);
				}
				else {
					LR.Result = -1;
					LR.Message = "Login Failed";
					LR.SessionID = session.getId();
					tx.rollback(ts);
				}

			} else {
				LR.Result = -1;
				LR.Message = "Login Failed";
				LR.SessionID = session.getId();
				tx.rollback(ts);

			}
		} catch (Exception e) {

			System.out.println("Exception from Contorller");
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		System.out.println(gson.toJson(LR));
		return gson.toJson(LR);
		*/
		
	}

	@RequestMapping(value = "/Login/Logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
/*	@ResponseBody
	@RequestMapping(value = "/ajax/logintry", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String loginProcess(HttpSession session, @RequestBody String filterJSON, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
*/

}
