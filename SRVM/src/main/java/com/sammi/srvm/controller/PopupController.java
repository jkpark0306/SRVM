package com.sammi.srvm.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.sammi.srvm.dao.SrvDAO_sample;
import com.sammi.srvm.dto.SrvDTO;

@Controller
@RequestMapping("/Popup/*")
public class PopupController {
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/SrvDetailPopup", method = RequestMethod.GET)
	public String SrvPopUp(Model model, @RequestParam(value = "SrvData", defaultValue = "") String SrvData)
			throws Exception {
		System.out.println("Popup");
		System.out.println(SrvData);
		model.addAttribute("SrvData", SrvData);
		
		Gson gson = new Gson();
		Map<String,String> map = gson.fromJson(SrvData, Map.class);
		String test = map.get("ServiceCode");
		
		System.out.println(test);
		
		
		SrvDAO_sample dao = sqlSession.getMapper(SrvDAO_sample.class);
		List<SrvDTO> rdto = dao.GetDetSrv(test);
		/*
		for(SrvDTO dto : rdto) {
			dto.getSrvCode();
			
		}*/
		
		System.out.println("From Query" + rdto.get(0).getReldto().getRelDate());
		
		return "Popup/SrvDetailPopup";
	}

}
