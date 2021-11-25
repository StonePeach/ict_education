package com.blue.jdbc_hr;

public class VO {
	   private int bno;
	   private String btitle;
	   private String writer;
	   private String borrow;

	   public VO(int bno, String btitle, String writer) {
	      super();
	      this.bno = bno;
	      this.btitle = btitle;
	      this.writer = writer;
	     // this.borrow = borrow;
	   }

	public int getBno() {
	      return bno;
	   }

	   public void setBno(int bno) {
	      this.bno = bno;
	   }
	   
		public void setBno(String bno2) {
			// TODO Auto-generated method stub
			
		}

	   public String getBtitle() {
	      return btitle;
	   }

	   public void setBtitle(String btitle) {
	      this.btitle = btitle;
	   }

	   public String getWriter() {
	      return writer;
	   }

	   public void setWriter(String writer) {
	      this.writer = writer;
	   }

	   public String getBorrow() {
	      return borrow;
	   }

	   public void setBorrow(String borrow) {
	      this.borrow = borrow;
	   }



	}