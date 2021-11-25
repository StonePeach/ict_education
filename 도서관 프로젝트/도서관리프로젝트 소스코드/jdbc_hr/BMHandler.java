package com.blue.jdbc_hr;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class BMHandler implements ActionListener{

   private BMPanel bmP;
   private BMVO vo;
   private BMDAO bmDao;
   
   public BMHandler(BMPanel bmP) {
      this.bmP = bmP;
      this.bmDao = new BMDAO();
      list();
   }
   
   private void list() {
      java.util.List<BMVO> arr = bmDao.listBook();
      if(arr == null) return;
      bmP.showbmTable(arr);
      
   }
   
   private void searchBook() {
      String btitle = bmP.tfSearch.getText();
      java.util.List<BMVO> arr = bmDao.searchBook(btitle);
      if(arr == null) return;
      bmP.showbmTable(arr);
   }
   
   public void clearTf() {
      bmP.tfSearch.setText("");
      bmP.tfSearch.requestFocus();
   }//-----------------------------------------------
   
   public void deleteBm() {
      String bno = JOptionPane.showInputDialog("삭제할 도서번호를 입력하세요");
      if(bno == null) return;
      int yn = JOptionPane.showConfirmDialog(bmP, 
            bno+"번 도서정보를 정말 삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
      System.out.println("yn: " + yn);
      if(yn == JOptionPane.YES_OPTION) {
         int bnum = Integer.parseInt(bno.trim());
         int n = bmDao.deleteBook(bnum);
         
         String msg = (n>0) ? bnum+"번 도서정보 삭제처리 완료" : "삭제 실패";
         show(msg);
         if(n>0) {
            list();
         }
      }
   }//-----------------------------------------------
   
   private void show(String msg) {
      JOptionPane.showMessageDialog(bmP, msg);
   }
   
   private void borrow() {
      String bno = JOptionPane.showInputDialog("대출할 도서의 도서번호를 입력하세요");
      if(bno == null) return;
      int yn = JOptionPane.showConfirmDialog(bmP, 
            bno+"번 도서를 대출하시겠습니까?", "대출 확인", JOptionPane.YES_NO_OPTION);
      System.out.println("yn: " + yn);
      
      if(yn == JOptionPane.YES_OPTION) {
         int bookNo = Integer.parseInt(bno.trim());
         
         BMVO vo 
         = new BMVO(bookNo, "false");
         int n = bmDao.updateBM(vo);
         
         String msg = (n>0) ? bno +"번 도서 대출 완료" : "대출 실패";
         show(msg);
         if(n>0) {
            list();
         }
      }
      
      
   }
   
   private void returnBook() {
      String bno = JOptionPane.showInputDialog("반납할 도서의 도서번호를 입력하세요");
      if(bno == null) return;
      int yn = JOptionPane.showConfirmDialog(bmP, 
            bno+"번 도서를 반납하시겠습니까?", "반납 확인", JOptionPane.YES_NO_OPTION);
      System.out.println("yn: " + yn);
      
      if(yn == JOptionPane.YES_OPTION) {
         int bookNo = Integer.parseInt(bno.trim());
         
         BMVO vo = new BMVO(bookNo, "true");
         int n = bmDao.updateBM(vo);
         
         String msg = (n>0) ? bno +"번 도서 반납 완료" : "반납 실패";
         show(msg);
         if(n>0) {
            list();
         }
      }
      
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if(obj == bmP.btBorrow) {
         borrow();
      } else if(obj == bmP.btDelete) {
         deleteBm();
      } else if(obj == bmP.btReset) {
         clearTf();
      } else if(obj == bmP.btList) {
         list();
         clearTf();
      } else if(obj == bmP.btReturn) {
         returnBook();
      } else if(obj == bmP.btSearch) {
         searchBook();
      }
   }

}