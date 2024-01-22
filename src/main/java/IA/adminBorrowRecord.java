/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IA;

import static IA.commonClass.borrowColumn;
import static IA.commonClass.borrowHiddenColumn;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shufa
 */
public class adminBorrowRecord extends javax.swing.JFrame {

    /**
     * Creates new form teacherBorrowRecord
     */
    public void updateborrowRecordfromUserMaster(){
        try{
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowrecord","myuser","1222");
            Statement myStmt = myCon.createStatement();
            myStmt.executeUpdate("Update borrowRecord set isStudent = (Select isStudent from "
                    + "usermaster where borrowRecord.userId = usermaster.userId);");
            myStmt.executeUpdate("Update borrowRecord set name = (Select name from usermaster where borrowRecord.userId = usermaster.userId);");
            myStmt.executeUpdate("Update borrowRecord set class = (Select class from usermaster where borrowRecord.userId = usermaster.userId);");
            myStmt.executeUpdate("Update borrowRecord set classNumber = (Select classNumber from usermaster where borrowRecord.userId = usermaster.userId);");
            myStmt.executeUpdate("Update borrowRecord set timesBorrowRecord = (Select gender from usermaster where borrowRecord.userId = usermaster.userId);");
            myStmt.executeUpdate("Update borrowRecord set lateRecord = (Select lateRecord from usermaster where borrowRecord.userId = usermaster.userId);");
            myStmt.executeUpdate("Update borrowRecord set gender = (Select gender from usermaster where borrowRecord.userId = usermaster.userId);");
            myStmt.executeUpdate("Update borrowRecord set borrowAuthorization = (Select borrowAuthorization from usermaster where borrowRecord.userId = usermaster.userId);");
            myStmt.executeUpdate("Update borrowRecord set numberOfBorrowedItems = (Select numberOfBorrowedItems from usermaster where borrowRecord.userId = usermaster.userId);");
        }
        catch(Exception exc){
        exc.printStackTrace();
         }
    }
    public void addRowsInTable(){
    try{
    Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowrecord","myuser","1222");
    int numberOfRows =0;
    Statement myStmt = myCon.createStatement();
    ResultSet myRs6 = myStmt.executeQuery("select count(*) from borrowRecord;");
     while(myRs6.next()){
        numberOfRows = Integer.parseInt (new String (myRs6.getString("count(*)")));
        break;
        }
        int columnlength = borrowColumn.length;
        String data[][]= new String[numberOfRows][columnlength];
        
    ResultSet myRs5 = myStmt.executeQuery("select * from borrowRecord;");
    for (int x=0; myRs5.next();x++){
        for (int y =0; y < columnlength ; y++){
            try {data[x][y] = myRs5.getString(borrowColumn[y]);}
            catch(SQLException exc){data[x][y] = myRs5.getString(borrowColumn[y]);}
        }
    }
    for (int y= 0; y< columnlength; y++){
        System.out.println(borrowColumn[y]);
    }
    int intColumnStatus;
    for (int y= 0; y< columnlength; y++){
        if ("isStudent".equals(borrowColumn[y])){           
            for (int x=0; x < numberOfRows ; x++){
                intColumnStatus = Integer.parseInt(data[x][y]);
                if (intColumnStatus==0){
                    data[x][y] = "teacher";
                }
                if (intColumnStatus==1){
                    data[x][y] = "student";
                }
            }
        }
        if ("lateOrNot".equals(borrowColumn[y])){           
            for (int x=0; x < numberOfRows ; x++){
                intColumnStatus = Integer.parseInt(data[x][y]);
                if (intColumnStatus==0){
                    data[x][y] = "not late";
                }
                if (intColumnStatus==1){
                    data[x][y] = "late";
                }
            }
        }
        if ("gender".equals(borrowColumn[y])){           
            for (int x=0; x < numberOfRows ; x++){
                intColumnStatus = Integer.parseInt(data[x][y]);
                if (intColumnStatus==0){
                    data[x][y] = "male";
                }
                if (intColumnStatus==1){
                    data[x][y] = "female";
                }
            }
        }
        if ("borrowAuthorization".equals(borrowColumn[y])){           
            for (int x=0; x < numberOfRows ; x++){
                intColumnStatus = Integer.parseInt(data[x][y]);
                if (intColumnStatus==0){
                    data[x][y] = "Not Allow";
                }
                if (intColumnStatus==1){
                    data[x][y] = "Allow";
                }
            }
        }
    }
    DefaultTableModel model;
        model = (DefaultTableModel)jTable1.getModel();
        for (int count = 0; count < columnlength; count++){
            model.addColumn(borrowColumn[count]);
        }
        
      for(int n=0;n<numberOfRows;n++){
          model.addRow(new Object[]{data[n][0]});
          System.out.println(data[n][0]);
          for(int count = 0; count < columnlength; count++){
            model.setValueAt(data[n][count], n, count);
          }
        }
        
      
        JTable table = new JTable(model);  
        table.setPreferredScrollableViewportSize(new Dimension(450,63));
        table.setFillsViewportHeight(true);
        JScrollPane js=new JScrollPane(table);
        js.setVisible(true);
        add(js);
        }
        
    catch(Exception exc){
   exc.printStackTrace();
    }
}
    public void comboBox1and2(String[] borrowHiddenColumn, String[] borrowColumn){
    int hiddencolumnlength  = borrowHiddenColumn.length;
    int columnlength  = borrowColumn.length;
    jComboBox1.insertItemAt("", 0);
    for (int count = 0; count < hiddencolumnlength; count++){
        jComboBox1.addItem(borrowHiddenColumn[count]);       
    }
    jComboBox2.insertItemAt("", 0);
    for (int count = 1; count < columnlength; count++){
        jComboBox2.addItem(borrowColumn[count]);       
    }
}
    public adminBorrowRecord() {
        initComponents();
        addRowsInTable();
        jTable1.setAutoCreateRowSorter(true);
        comboBox1and2(borrowHiddenColumn, borrowColumn);
        updateborrowRecordfromUserMaster();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Add Column");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Delete Column");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Main Page");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Borrow Record Page");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(581, 581, 581))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String selectedValue = jComboBox2.getSelectedItem().toString();
        if (selectedValue != ""){
            borrowHiddenColumn = java.util.Arrays.copyOf(borrowHiddenColumn, borrowHiddenColumn.length+1);
            borrowHiddenColumn[borrowHiddenColumn.length-1] = selectedValue;

            for (int count=0; count < borrowColumn.length; count++){
                if (borrowColumn[count] == selectedValue){
                    for(int x = count; x < borrowColumn.length-1 ; x++){
                        borrowColumn[x]=borrowColumn[x+1];
                    }
                    break;
                }
            }
            borrowColumn = java.util.Arrays.copyOf(borrowColumn, borrowColumn.length-1);
            new adminBorrowRecord().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedValue = jComboBox1.getSelectedItem().toString();
        if (selectedValue != ""){
            borrowColumn = java.util.Arrays.copyOf(borrowColumn, borrowColumn.length+1);
            borrowColumn[borrowColumn.length-1] = selectedValue;

            for (int count=0; count < borrowHiddenColumn.length; count++){
                if (borrowHiddenColumn[count] == selectedValue){
                    for(int x = count; x < borrowHiddenColumn.length-1 ; x++){
                        borrowHiddenColumn[x]=borrowHiddenColumn[x+1];
                    }
                    break;
                }
            }
            borrowHiddenColumn = java.util.Arrays.copyOf(borrowHiddenColumn, borrowHiddenColumn.length-1);
            new adminBorrowRecord().setVisible(true);
            dispose();
        }
        //jTextField1.setText(selectedValue);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
new teacherFirstPage().setVisible(true);     
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(adminBorrowRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminBorrowRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminBorrowRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminBorrowRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminBorrowRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
