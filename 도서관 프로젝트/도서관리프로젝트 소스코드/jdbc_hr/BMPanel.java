package com.blue.jdbc_hr;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.table.*;
/**
 *
 * @author 김예린
 */
public class BMPanel extends javax.swing.JPanel {
      Image background=new ImageIcon(("C:\\Users\\mino5\\eclipse-workspace\\JDBC_HR\\src\\푸른하늘도서관 배경.PNG")).getImage();
       /**
        * Creates new form Bookset
        */
      String[] title = {"도서번호", "도서이름", " 저 자", "대출여부"};
      DefaultTableModel bmModel;
      BMHandler handler;
      
       public BMPanel() {
           initComponents();
           
           handler = new BMHandler(this);
           btBorrow.addActionListener(handler);
           btReturn.addActionListener(handler);
           btDelete.addActionListener(handler);
           btReset.addActionListener(handler);
           btList.addActionListener(handler);
           btSearch.addActionListener(handler);
       }
       
       
       
       @Override
       public void paintComponent(Graphics g) {//그리는 함수
               super.paintComponent(g);
         g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);//background를 그려줌      
       }

    /**
     * Creates new form BMPanel
     */


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        labelMg = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        btBorrow = new javax.swing.JButton();
        btReturn = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btList = new javax.swing.JButton();
        btReset = new javax.swing.JButton();

        labelTitle.setFont(new java.awt.Font("HS유지체 ", 0, 36)); // NOI18N
        labelTitle.setText("푸른하늘 도서관");

        labelMg.setFont(new java.awt.Font("HS유지체 ", 0, 18)); // NOI18N
        labelMg.setText("도서관리");

        tfSearch.setFont(new java.awt.Font("교보 손글씨 2019", 0, 14)); // NOI18N
        tfSearch.setText("검색 할 도서를 입력해 주세여");
        tfSearch.setScrollOffset(1);
        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        btSearch.setFont(new java.awt.Font("교보 손글씨 2019", 0, 18)); // NOI18N
        btSearch.setText("검색");

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "도서번호", "도서이름", " 저 자", "대출여부"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bookTable);
        if (bookTable.getColumnModel().getColumnCount() > 0) {
            bookTable.getColumnModel().getColumn(0).setResizable(false);
            bookTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            bookTable.getColumnModel().getColumn(1).setPreferredWidth(280);
            bookTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            bookTable.getColumnModel().getColumn(3).setResizable(false);
            bookTable.getColumnModel().getColumn(3).setPreferredWidth(55);
        }

        btBorrow.setFont(new java.awt.Font("교보 손글씨 2019", 0, 18)); // NOI18N
        btBorrow.setText("대 출 ");

        btReturn.setFont(new java.awt.Font("교보 손글씨 2019", 0, 18)); // NOI18N
        btReturn.setText("반 납");

        btDelete.setFont(new java.awt.Font("교보 손글씨 2019", 0, 18)); // NOI18N
        btDelete.setText("도서삭제");

        btList.setFont(new java.awt.Font("교보 손글씨 2019", 0, 18)); // NOI18N
        btList.setText("목록보기");

        btReset.setFont(new java.awt.Font("교보 손글씨 2019", 0, 18)); // NOI18N
        btReset.setText("다시쓰기");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(labelTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(labelMg)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btBorrow)
                        .addGap(51, 51, 51)
                        .addComponent(btReturn)
                        .addGap(58, 58, 58)
                        .addComponent(btDelete)
                        .addGap(50, 50, 50)
                        .addComponent(btList)
                        .addGap(55, 55, 55)
                        .addComponent(btReset))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMg,javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btList, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
    }// </editor-fold>                        

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        


    // Variables declaration - do not modify                     
    javax.swing.JTable bookTable;
    javax.swing.JButton btBorrow;
    javax.swing.JButton btDelete;
    javax.swing.JButton btList;
    javax.swing.JButton btReset;
    javax.swing.JButton btReturn;
    javax.swing.JButton btSearch;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JLabel labelMg;
    javax.swing.JLabel labelTitle;
    javax.swing.JTextField tfSearch;
    // End of variables declaration         
    
    public void showbmTable(List<BMVO> arr) {
        if(arr==null) return;
        Object[][] data=new Object[arr.size()][title.length];
        for(int i=0; i<arr.size(); i++) {
           BMVO bm=arr.get(i);
           data[i][0]=bm.getBno();
           data[i][1]=bm.getbtitle();
           data[i][2]=bm.getWriter();
           data[i][3]=bm.getBorrow();
           }
        bmModel=new DefaultTableModel(data,title);
        
        bookTable.setModel(bmModel);
        
     }
    
}