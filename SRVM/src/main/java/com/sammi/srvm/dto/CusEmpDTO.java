package com.sammi.srvm.dto;

import org.springframework.stereotype.Repository;

@Repository
public class CusEmpDTO{
	private String CusEmpCode;
	private String Cuscode;
	private String CusName;
	private String Number1;
	private String Number2;
	private String EmailAddress;
	private String Name;
	private String CREATE_ID;
	private String CREATE_DT;
	private String MODIFY_ID;
	private String MODIFY_DT;
	
	public String getCusEmpCode() {
		return CusEmpCode;
	}
	public void setCusEmpCode(String cusEmpCode) {
		CusEmpCode = cusEmpCode;
	}
	public String getCuscode() {
		return Cuscode;
	}
	public void setCuscode(String cuscode) {
		Cuscode = cuscode;
	}
	public String getNumber1() {
		return Number1;
	}
	public void setNumber1(String number1) {
		Number1 = number1;
	}
	public String getNumber2() {
		return Number2;
	}
	public void setNumber2(String number2) {
		Number2 = number2;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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