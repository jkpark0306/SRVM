package com.sammi.srvm.dto;

import org.springframework.stereotype.Repository;

public class EmpDTO {
	private String EmpCode;
	
	private String Department;
	
	private String DepartCode;
	
	private String Name;
	
	private String Rank;
	
	private String Gender;
	
	private String ID;
	
	private String PASSWORD;
	
	private String Permission;
	
	private String SessionID;
	
	private String CREATE_ID;
	
	private String CREATE_DT;
	
	private String MODIFY_ID;
	
	private String MODIFY_DT;
	
	
	
	public String getSessionID() {
		return SessionID;
	}

	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}

	public String getPermission() {
		return Permission;
	}

	public void setPermission(String permission) {
		Permission = permission;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public void setEmpCode(String empCode) {
		EmpCode = empCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
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

	public String getEmpCode() {
		return EmpCode;
	}

	public void setEmpNumber(String empcode) {
		EmpCode = empcode;
	}

	public String getDepartCode() {
		return DepartCode;
	}

	public void setDepartCode(String departCode) {
		DepartCode = departCode;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String rank) {
		Rank = rank;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
}
