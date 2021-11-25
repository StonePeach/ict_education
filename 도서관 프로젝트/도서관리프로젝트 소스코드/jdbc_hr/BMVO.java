package com.blue.jdbc_hr;

public class BMVO {
	   private int bno;
	   private String btitle;
	   private String writer;
	   private String borrow;

	   public BMVO() {
	      this(0, "", "", "");
	   }

	   public BMVO(int bno, String borrow) {
		      super();
		      this.bno = bno;
		      this.borrow = borrow;
		   }
	   
	   public BMVO(int bno, String btitle, String writer, String borrow) {
	      super();
	      this.bno = bno;
	      this.btitle = btitle;
	      this.writer = writer;
	      this.borrow = borrow;
	   }

	   public int getBno() {
	      return bno;
	   }

	   public void setBno(int bno) {
	      this.bno = bno;
	   }

	   public String getbtitle() {
	      return btitle;
	   }

	   public void setbtitle(String btitle) {
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
