package com.sammi.srvm.dto;

import org.springframework.stereotype.Repository;

@Repository
public class EquPrtDTO {
	private String EquPrtCode;
	private String PrtCode;
	private String UniEquCode;
	private String CREATE_ID;
	private String CREATE_DT;
	private String MODIFY_ID;
	private String MODIFY_DT;
	public String getEquPrtCode() {
		return EquPrtCode;
	}
	public void setEquPrtCode(String equPrtCode) {
		EquPrtCode = equPrtCode;
	}
	public String getPrtCode() {
		return PrtCode;
	}
	public void setPrtCode(String prtCode) {
		PrtCode = prtCode;
	}
	public String getUniEquCode() {
		return UniEquCode;
	}
	public void setUniEquCode(String uniEquCode) {
		UniEquCode = uniEquCode;
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
	public String getMODIFy_DT() {
		return MODIFY_DT;
	}
	public void setMODIFy_DT(String mODIFy_DT) {
		MODIFY_DT = mODIFy_DT;
	}
	
}
