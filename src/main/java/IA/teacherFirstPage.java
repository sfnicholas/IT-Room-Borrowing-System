package IA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shufa
 */
public class teacherFirstPage extends javax.swing.JFrame {

    /**
     * Creates new form teacherFirstPage
     */
    public void addRowInList(){
        //https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
        try{
         Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowrecord","myuser","1222");
         Statement myStmt = myCon.createStatement();
             
            int numberOfRows = 0;
            ResultSet myRs6 = myStmt.executeQuery("select count(*) from questionmaster where isRead = 0;");
            while(myRs6.next()){
                numberOfRows = Integer.parseInt (new String (myRs6.getString("count(*)")));
                break;
            }
            String data[][]= new String[numberOfRows][6];
 //https://www.experts-exchange.com/questions/27401815/javax-swing-JList-3-cannot-be-cast-to-javax-swing-DefaultListModel.html
        DefaultListModel dflm = new DefaultListModel();
        jList1.setModel(dflm);
        ListModel lm = jList1.getModel();
        DefaultListModel model = (DefaultListModel)lm;
ResultSet myRs5 = myStmt.executeQuery("select * from questionmaster where isRead = 0;");
    for (int x=0; myRs5.next();x++){
            if (myRs5.getString("questionLocation").equals("0")){
                data[x][0] = myRs5.getString("questionnumber");
                data[x][1] = myRs5.getString("Feedback");
                data[x][2] = myRs5.getString("userId");
                data[x][3] = myRs5.getString("equipmentId");
                data[x][5] = "Return Page";
                if(myRs5.getString("isDamage").equals("0")){
                    model.addElement("Q" + data[x][0] + " ( feedback:" + ")"+ data[x][1] + " (UserId:" + data[x][2] + ")" + 
                            " (Equipment Id:" + data[x][3] + ")" +  " (" + data[x][5] + ")");
                }
                else if(myRs5.getString("isDamage").equals("1")){
                    data[x][4] = "Damaged";
                    model.addElement("Q" + data[x][0] + " ( feedback:" + ")"+ data[x][1] + " (UserId:" + data[x][2] + ")" + 
                            " (Equipment Id:" + data[x][3] + ")" + " (" + data[x][4] + ")" +  " (" + data[x][5] + ")");
                }
            }
            if (myRs5.getString("questionLocation").equals("1")){
                data[x][0] = myRs5.getString("questionnumber");
                data[x][1] = myRs5.getString("Feedback");
                data[x][2] = myRs5.getString("userId");
                data[x][3] = myRs5.getString("replyMethod");
                data[x][4] = "Question Page";
                if((data[x][2])== null){
                    System.out.println("is empty");
                    model.addElement("Q" + data[x][0] + " ( feedback:" + ")"+data[x][1] + " (replyMethod:" + data[x][3] + ")" 
                            +  " (" + data[x][4] + ")");
                }
                else {
                    model.addElement("Q" + data[x][0] + " ( feedback:" + ")"+data[x][1] + " (UserId:" + data[x][2] + ")" + 
                            " (replyMethod:" + data[x][3] + ")" + " (" + data[x][4] + ")");
                }
            }
    }
    JList list = new JList(model);
        JScrollPane js=new JScrollPane(list);
        js.setVisible(true);
        add(js);
    }
            catch(Exception exc){
   exc.printStackTrace();
    }
    }
    public teacherFirstPage() {
        initComponents();
        addRowInList();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonReturning = new javax.swing.JButton();
        jButtonReturning1 = new javax.swing.JButton();
        jButtonReturning2 = new javax.swing.JButton();
        jButtonReturning3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButtonRead = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonReturning4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonReturning.setText("Check, Change & Delete in Inventory");
        jButtonReturning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturningActionPerformed(evt);
            }
        });

        jButtonReturning1.setText("Check Borrow Record");
        jButtonReturning1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturning1ActionPerformed(evt);
            }
        });

        jButtonReturning2.setText("Create new admin");
        jButtonReturning2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturning2ActionPerformed(evt);
            }
        });

        jButtonReturning3.setText("Add new Equipments");
        jButtonReturning3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturning3ActionPerformed(evt);
            }
        });

        jButton1.setText("LogOut");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jButtonRead.setText("Solved");
        jButtonRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Admin Main Page");

        jButtonReturning4.setText("Check, Change User Master");
        jButtonReturning4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturning4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jButtonReturning3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jButtonReturning2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRead))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButtonReturning, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonReturning4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReturning1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReturning4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReturning, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReturning1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReturning3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReturning2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButtonRead)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReturningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturningActionPerformed
new teacherInventory().setVisible(true);     
dispose();
    }//GEN-LAST:event_jButtonReturningActionPerformed

    private void jButtonReturning1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturning1ActionPerformed
      new adminBorrowRecord().setVisible(true);  
      dispose();
    }//GEN-LAST:event_jButtonReturning1ActionPerformed

    private void jButtonReturning2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturning2ActionPerformed
        new createNewAdmin().setVisible(true);  
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButtonReturning2ActionPerformed

    private void jButtonReturning3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturning3ActionPerformed
       new teacherAddInventory1().setVisible(true);  
        dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReturning3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    new firstPage().setVisible(true);
    dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadActionPerformed
        //https://www.w3resource.com/java-exercises/basic/java-basic-exercise-69.php
        String selectedValue = jList1.getSelectedValue(); // read the JList 
        System.out.println("SelectedValue: " + selectedValue);    
        String newSelectedValue =  selectedValue.substring(0, selectedValue.length()/6);
        System.out.println("cutted into 1/6" + newSelectedValue);    
        //https://stackoverflow.com/questions/4030928/extract-digits-from-a-string-in-java
        final StringBuilder sb = new StringBuilder(
            newSelectedValue.length() /* also inspired by seh's comment */);
    for(int i = 0; i < newSelectedValue.length(); i++){
        final char c = newSelectedValue.charAt(i);
        if(c > 47 && c < 58){
            sb.append(c);
        }
    }
        String number = sb.toString();
        System.out.println("The number part of it" + number);
        try{
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowrecord","myuser","1222");
            Statement myStmt = myCon.createStatement();
            PreparedStatement updateisRead = myCon.prepareStatement("Update questionmaster set isRead = 1 where questionNumber = ?;");
            updateisRead.setString(1, number);
            updateisRead.executeUpdate();
            new teacherFirstPage().setVisible(true);
            dispose();
        }   
        catch(Exception exc){
            exc.printStackTrace();
        }
    }//GEN-LAST:event_jButtonReadActionPerformed

    private void jButtonReturning4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturning4ActionPerformed
       new adminUserMaster().setVisible(true);
       dispose();
    }//GEN-LAST:event_jButtonReturning4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(teacherFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teacherFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teacherFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teacherFirstPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new teacherFirstPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonRead;
    private javax.swing.JButton jButtonReturning;
    private javax.swing.JButton jButtonReturning1;
    private javax.swing.JButton jButtonReturning2;
    private javax.swing.JButton jButtonReturning3;
    private javax.swing.JButton jButtonReturning4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
