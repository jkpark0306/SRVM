package com.sammi.srvm.dto;

import org.springframework.stereotype.Repository;

@Repository
public class PrtDTO {
	private String PrtCode;
	private String MainSup;
	private String Qty;
	private String PrtBel;
	private String CREATE_ID;
	private String CREATE_DT;
	private String MODIFY_ID;
	private String MODIFY_DT;
	public String getPrtCode() {
		return PrtCode;
	}
	public void setPrtCode(String prtCode) {
		PrtCode = prtCode;
	}
	public String getMainSup() {
		return MainSup;
	}
	public void setMainSup(String mainSup) {
		MainSup = mainSup;
	}
	public String getQty() {
		return Qty;
	}
	public void setQty(String qty) {
		Qty = qty;
	}
	public String getPrtBel() {
		return PrtBel;
	}
	public void setPrtBel(String prtBel) {
		PrtBel = prtBel;
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
