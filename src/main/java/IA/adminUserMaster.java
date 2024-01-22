/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IA;


import static IA.commonClass.usermasterColumn;
import static IA.commonClass.usermasterHiddenColumn;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shufa
 */
public class adminUserMaster extends javax.swing.JFrame {
int numberOfRows =0;
int columnlength;
public void addRowsInTable(){
    try{
    Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowrecord","myuser","1222");
    Statement myStmt = myCon.createStatement();
    ResultSet myRs6 = myStmt.executeQuery("select count(*) from usermaster;");
    while(myRs6.next()){
        numberOfRows = Integer.parseInt (new String (myRs6.getString("count(*)")));
        break;
        }
        columnlength = usermasterColumn.length;
        String data[][] = new String[numberOfRows][columnlength];
    ResultSet myRs5 = myStmt.executeQuery("select * from usermaster;");
    for (int x=0; myRs5.next();x++){
        for (int y =0; y < columnlength ; y++){
            data[x][y] = myRs5.getString(usermasterColumn[y]);
        }
    }
    int intColumnStatus;
    for (int y= 0; y< columnlength; y++){
        if ("isStudent".equals(usermasterColumn[y])){           
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
        if ("lateOrNot".equals(usermasterColumn[y])){           
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
        if ("gender".equals(usermasterColumn[y])){           
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
        if ("borrowAuthorization".equals(usermasterColumn[y])){           
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
    
//Then the Table is constructed using these data and columnNames:
     
    DefaultTableModel model;
        model = (DefaultTableModel)jTable1.getModel();       
        for (int count = 0; count < columnlength; count++){
            model.addColumn(usermasterColumn[count]);
        }
      for(int n=0;n<numberOfRows;n++){
          model.addRow(new Object[]{data[n][0]});
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
    /**
     * Creates new form userMaster
     */
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
    
    public adminUserMaster() {
        initComponents();
        addRowsInTable();
        jTable1.setAutoCreateRowSorter(true);
        comboBox1and2(usermasterHiddenColumn, usermasterColumn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldEequipmentId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldBorrowIdChangeStatesColumnName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldBorrowIdChangeTo = new javax.swing.JTextField();
        jButtonChange = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldUserId = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButtonChange1 = new javax.swing.JButton();
        jComboBoxChangeBorrowAuthorization = new javax.swing.JComboBox<>();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Change Value");

        jLabel13.setText("EquipmentID");

        jTextFieldEequipmentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEequipmentIdActionPerformed(evt);
            }
        });

        jLabel12.setText("Change States Column Name");

        jTextFieldBorrowIdChangeStatesColumnName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBorrowIdChangeStatesColumnNameActionPerformed(evt);
            }
        });

        jLabel14.setText("Change To ");

        jTextFieldBorrowIdChangeTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBorrowIdChangeToActionPerformed(evt);
            }
        });

        jButtonChange.setText("Change");
        jButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Add Column");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Delete Column");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton2.setText("Main Page");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("User Master Page");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Change Value");

        jLabel15.setText("User ID");

        jTextFieldUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserIdActionPerformed(evt);
            }
        });

        jLabel16.setText("Change borrowAutohorization");

        jButtonChange1.setText("Change");
        jButtonChange1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChange1ActionPerformed(evt);
            }
        });

        jComboBoxChangeBorrowAuthorization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allow", "Not Allow" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldUserId, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                            .addComponent(jComboBoxChangeBorrowAuthorization, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonChange1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxChangeBorrowAuthorization)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButtonChange1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedValue = jComboBox1.getSelectedItem().toString();
        if (selectedValue != ""){
            usermasterColumn = java.util.Arrays.copyOf(usermasterColumn, usermasterColumn.length+1);
            usermasterColumn[usermasterColumn.length-1] = selectedValue;

            for (int count=0; count < usermasterHiddenColumn.length; count++){
                if (usermasterHiddenColumn[count] == selectedValue){
                    for(int x = count; x < usermasterHiddenColumn.length-1 ; x++){
                        usermasterHiddenColumn[x]=usermasterHiddenColumn[x+1];
                    }
                    break;
                }
            }
            usermasterHiddenColumn = java.util.Arrays.copyOf(usermasterHiddenColumn, usermasterHiddenColumn.length-1);
            new adminUserMaster().setVisible(true);
            dispose();
        }
        //jTextField1.setText(selectedValue);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String selectedValue = jComboBox2.getSelectedItem().toString();
        if (selectedValue != ""){
            usermasterHiddenColumn = java.util.Arrays.copyOf(usermasterHiddenColumn, usermasterHiddenColumn.length+1);
            usermasterHiddenColumn[usermasterHiddenColumn.length-1] = selectedValue;

            for (int count=0; count < usermasterColumn.length; count++){
                if (usermasterColumn[count] == selectedValue){
                    for(int x = count; x < usermasterColumn.length-1 ; x++){
                        usermasterColumn[x]=usermasterColumn[x+1];
                    }
                    break;
                }
            }
            usermasterColumn = java.util.Arrays.copyOf(usermasterColumn, usermasterColumn.length-1);
            new adminUserMaster().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new teacherFirstPage().setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldEequipmentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEequipmentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEequipmentIdActionPerformed

    private void jTextFieldBorrowIdChangeStatesColumnNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBorrowIdChangeStatesColumnNameActionPerformed

    }//GEN-LAST:event_jTextFieldBorrowIdChangeStatesColumnNameActionPerformed

    private void jTextFieldBorrowIdChangeToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBorrowIdChangeToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBorrowIdChangeToActionPerformed

    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
       
    }//GEN-LAST:event_jButtonChangeActionPerformed

    private void jTextFieldUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUserIdActionPerformed

    private void jButtonChange1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChange1ActionPerformed
        String userIdText = jTextFieldUserId.getText();
        
        String borrowAuthorizationBox = (String) jComboBoxChangeBorrowAuthorization.getSelectedItem();
       
                if (borrowAuthorizationBox.equals("Not Allow")){
                    borrowAuthorizationBox = "0";
                }
                if (borrowAuthorizationBox.equals("Allow")){
                    borrowAuthorizationBox = "1";
                }
                System.out.println(borrowAuthorizationBox);
        try{
            Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowrecord","myuser","1222");
            Statement myStmt = myCon.createStatement();
            PreparedStatement updateValue = myCon.prepareStatement("Update usermaster set borrowAuthorization = ? where userId = ? ;");
            updateValue.setString(1, borrowAuthorizationBox);
            updateValue.setString(2, userIdText);
            updateValue.executeUpdate();
            JOptionPane.showMessageDialog(null,"Changed Successfully");
            new adminUserMaster().setVisible(true);
            dispose();
        }
        
        catch(Exception exc){
            exc.printStackTrace();
        }
    }//GEN-LAST:event_jButtonChange1ActionPerformed

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
            java.util.logging.Logger.getLogger(adminUserMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminUserMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminUserMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminUserMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminUserMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonChange;
    private javax.swing.JButton jButtonChange1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxChangeBorrowAuthorization;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldBorrowIdChangeStatesColumnName;
    private javax.swing.JTextField jTextFieldBorrowIdChangeTo;
    private javax.swing.JTextField jTextFieldEequipmentId;
    private javax.swing.JTextField jTextFieldUserId;
    // End of variables declaration//GEN-END:variables
}
