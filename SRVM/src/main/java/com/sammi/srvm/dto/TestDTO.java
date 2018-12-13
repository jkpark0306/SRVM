package com.sammi.srvm.dto;

import org.springframework.stereotype.Repository;

@Repository
public class TestDTO {
	private int IDX;
	private String TC1;
	private String TC2;
	private String TC3;
	
	public int getIDX() {
		return IDX;
	}
	public void setIDX(int iDX) {
		IDX = iDX;
	}
	public String getTC1() {
		return TC1;
	}
	public void setTC1(String tC1) {
		TC1 = tC1;
	}
	public String getTC2() {
		return TC2;
	}
	public void setTC2(String tC2) {
		TC2 = tC2;
	}
	public String getTC3() {
		return TC3;
	}
	public void setTC3(String tC3) {
		TC3 = tC3;
	}

}
