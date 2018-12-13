package com.sammi.srvm.dto;

import org.springframework.stereotype.Repository;

@Repository
public class ParSerDTO {
	private String SrvCode;
	private String CusCode;
	private String SendDate;
	private String RtnDate;
	private String CREATE_ID;
	private String CREATE_DT;
	private String MODIFY_ID;
	private String MODIFY_DT;
	public String getSrvCode() {
		return SrvCode;
	}
	public void setSrvCode(String srvCode) {
		SrvCode = srvCode;
	}
	public String getCusCode() {
		return CusCode;
	}
	public void setCusCode(String cusCode) {
		CusCode = cusCode;
	}
	public String getSendDate() {
		return SendDate;
	}
	public void setSendDate(String sendDate) {
		SendDate = sendDate;
	}
	public String getRtnDate() {
		return RtnDate;
	}
	public void setRtnDate(String rtnDate) {
		RtnDate = rtnDate;
	}
	public String getCREATE_ID() {
		return CREATE_ID;
	}
	public void setCREATE_ID(String cREATE_ID) {
		CREATE_ID = cREATE_ID;
	}
	public String getCREATE_DT() {
		return CREATE_DT;
	}
	public void setCREATE_DT(String cREATE_DT) {
		CREATE_DT = cREATE_DT;
	}
	public String getMODIFY_ID() {
		return MODIFY_ID;
	}
	public void setMODIFY_ID(String mODIFY_ID) {
		MODIFY_ID = mODIFY_ID;
	}
	public String getMODIFY_DT() {
		return MODIFY_DT;
	}
	public void setMODIFY_DT(String mODIFY_DT) {
		MODIFY_DT = mODIFY_DT;
	}
	
}
