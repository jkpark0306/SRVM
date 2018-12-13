package com.sammi.srvm.dto;

import java.util.Date;

public class SrvDTO {
	private String SrvCode;
	private String CusCode;
	private String CusName;
	private String EmpCode;
	private String EmpName;
	private String UniEquCode;
	private String CusEmpCode;
	private String CusEmpName;
	private String SerialNumber;
	private String ProductNumber;
	private String ProcessCode;
	private String Process;
	private String ObtFlag;
	private String OrdFlag;
	private String RelFlag;
	private String PartSrvFlag;
	private String RelExtDate;
	private String CREATE_ID;
	private String CREATE_DT;
	private String MODIFY_ID;
	private String MODIFY_DT;
	public String getCREATE_DT() {
		return CREATE_DT;
	}
	public void setCREATE_DT(String cREATE_DT) {
		CREATE_DT = cREATE_DT;
	}
	public String getMODIFY_DT() {
		return MODIFY_DT;
	}
	public void setMODIFY_DT(String mODIFY_DT) {
		MODIFY_DT = mODIFY_DT;
	}
	private RelDTO reldto;
	private CusDTO cusdto;
	
	public CusDTO getCusdto() {
		return cusdto;
	}
	public void setCusdto(CusDTO cusdto) {
		this.cusdto = cusdto;
	}
	public String getEmpCode() {
		return EmpCode;
	}
	public void setEmpCode(String empCode) {
		EmpCode = empCode;
	}
	public RelDTO getReldto() {
		return reldto;
	}
	public void setReldto(RelDTO reldto) {
		this.reldto = reldto;
	}
	public String getCusName() {
		return CusName;
	}
	public void setCusName(String cusName) {
		CusName = cusName;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getCusEmpName() {
		return CusEmpName;
	}
	public void setCusEmpName(String cusEmpName) {
		CusEmpName = cusEmpName;
	}
	public String getSerialNumber() {
		return SerialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}
	public String getProductNumber() {
		return ProductNumber;
	}
	public void setProductNumber(String productNumber) {
		ProductNumber = productNumber;
	}

	public String getSrvCode() {
		return SrvCode;
	}
	public void setSrvCode(String srvCode) {
		SrvCode = srvCode;
	}
	public String getCusCode() {
		return CusCode;
	}
	public void setCusCode(String cuscode) {
		CusCode = cuscode;
	}
	public String getUniEquCode() {
		return UniEquCode;
	}
	public void setUniEquCode(String uniEquCode) {
		UniEquCode = uniEquCode;
	}
	public String getCusEmpCode() {
		return CusEmpCode;
	}
	public void setCusEmpCode(String cusEmpCode) {
		CusEmpCode = cusEmpCode;
	}
	public String getProcessCode() {
		return ProcessCode;
	}
	public void setProcessCode(String processcode) {
		ProcessCode = processcode;
	}
	public String getProcess() {
		return Process;
	}
	public void setProcess(String process) {
		Process = process;
	}
	public String getObtFlag() {
		return ObtFlag;
	}
	public void setObtFlag(String obtFlag) {
		ObtFlag = obtFlag;
	}
	public String getOrdFlag() {
		return OrdFlag;
	}
	public void setOrdFlag(String ordFlag) {
		OrdFlag = ordFlag;
	}
	public String getRelFlag() {
		return RelFlag;
	}
	public void setRelFlag(String relFlag) {
		RelFlag = relFlag;
	}
	public String getPartSrvFlag() {
		return PartSrvFlag;
	}
	public void setPartSrvFlag(String partSrvFlag) {
		PartSrvFlag = partSrvFlag;
	}
	public String getRelExtDate() {
		return RelExtDate;
	}
	public void setRelExtDate(String relExtDate) {
		RelExtDate = relExtDate;
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
	
	
	
}
