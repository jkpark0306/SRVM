package com.sammi.srvm.dto;

public class UniEquDTO {
	private String UniEquCode;
	private String EquCode;
	private String ProductNumber;
	private String SerialNumber;
	private String WrtFlag;
	private String MakeDate;
	private String CREATE_ID;
	public String getUniEquCode() {
		return UniEquCode;
	}
	public void setUniEquCode(String uniEquCode) {
		UniEquCode = uniEquCode;
	}
	public String getEquCode() {
		return EquCode;
	}
	public void setEquCode(String equCode) {
		EquCode = equCode;
	}
	public String getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}
	public String getWrtFlag() {
		return WrtFlag;
	}
	public void setWrtFlag(String wrtFlag) {
		WrtFlag = wrtFlag;
	}
	public String getMakeDate() {
		return MakeDate;
	}
	public void setMakeDate(String makeDate) {
		MakeDate = makeDate;
	}
	public String getCREATE_ID() {
		return CREATE_ID;
	}
	public void setCREATE_ID(String cREATE_ID) {
		CREATE_ID = cREATE_ID;
	}
	public String getMODIFY_ID() {
		return MODIFY_ID;
	}
	public void setMODIFY_ID(String mODIFY_ID) {
		MODIFY_ID = mODIFY_ID;
	}
	private String MODIFY_ID;
}
