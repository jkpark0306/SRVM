package com.sammi.srvm.dto;

public class CodeMasterDTO {
	private int IDX;
	private String CodeID;
	private String CodeGroupName;
	private String CodeDescription;
	private String BelCodeGroupName;
	private String BelCodeID;
	private String CREATE_ID;
	private String MODIFY_ID;
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public String getCodeID() {
		return CodeID;
	}
	public void setCodeID(String codeID) {
		CodeID = codeID;
	}
	public String getCodeGroupName() {
		return CodeGroupName;
	}
	public void setCodeGroupName(String codeGroupName) {
		CodeGroupName = codeGroupName;
	}
	public String getCodeDescription() {
		return CodeDescription;
	}
	public void setCodeDescription(String codeDescription) {
		CodeDescription = codeDescription;
	}
	public String getBelCodeGroupName() {
		return BelCodeGroupName;
	}
	public void setBelCodeGroupName(String belCodeGroupName) {
		BelCodeGroupName = belCodeGroupName;
	}
	public String getBelCodeID() {
		return BelCodeID;
	}
	public void setBelCodeID(String belCodeID) {
		BelCodeID = belCodeID;
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
