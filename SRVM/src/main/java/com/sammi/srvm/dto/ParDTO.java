package com.sammi.srvm.dto;

import org.springframework.stereotype.Repository;

@Repository
public class ParDTO {
	private String PartCode;
	private String PartName;
	private String CorpNumber;
	private String PreName;
	private String PreNumber;
	private String Address1;
	private String Address2;
	private String Address3;
	private String CREATE_ID;
	private String CREATE_DT;
	private String MODIFY_ID;
	private String MODIFY_DT;
	public String getPartCode() {
		return PartCode;
	}
	public void setPartCode(String partCode) {
		PartCode = partCode;
	}
	public String getPartName() {
		return PartName;
	}
	public void setPartName(String partName) {
		PartName = partName;
	}
	public String getCorpNumber() {
		return CorpNumber;
	}
	public void setCorpNumber(String corpNumber) {
		CorpNumber = corpNumber;
	}
	public String getPreName() {
		return PreName;
	}
	public void setPreName(String preName) {
		PreName = preName;
	}
	public String getPreNumber() {
		return PreNumber;
	}
	public void setPreNumber(String preNumber) {
		PreNumber = preNumber;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getAddress3() {
		return Address3;
	}
	public void setAddress3(String address3) {
		Address3 = address3;
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
