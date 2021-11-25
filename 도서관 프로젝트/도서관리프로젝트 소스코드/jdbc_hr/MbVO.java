package com.blue.jdbc_hr;

import java.sql.Date;

public class MbVO {
	private int myear;
	private String mname;
	private String maddress;
	private java.sql.Date mdate;
	private String mdateStr;
	private int mnumber;
	
	public String getMdateStr() {
		return mdateStr;
	}

	public void setMdateStr(String mdateStr) {
		this.mdateStr = mdateStr;
	}

	public MbVO(){
		
	}

	public MbVO(int myear, String mname, String maddress, Date mdate, int mnumber) {
		super();
		this.myear = myear;
		this.mname = mname;
		this.maddress = maddress;
		this.mdate = mdate;
		this.mnumber = mnumber;
	}

	public int getMyear() {
		return myear;
	}

	public void setMyear(int myear) {
		this.myear = myear;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public java.sql.Date getMdate() {
		return mdate;
	}

	public void setMdate(java.sql.Date mdate) {
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return "MbVO [myear=" + myear + ", mname=" + mname + ", maddress=" + maddress + ", mdate=" + mdate + "mnunmber=" + mnumber + "]";
	}

	public int getMnumber() {
		return mnumber;
	}

	public void setMumber(int mnumber) {
		this.mnumber = mnumber;
	}
	
	
	
	
}
