package IA;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author shufa
 */
public class inventory extends javax.swing.JFrame {
    public void addRowsInTable(){
      try{
    //connect to mysql
    Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowrecord","myuser","1222");
    int numberOfRows =0;
    Statement myStmt = myCon.createStatement();
    //find the number of rows
    ResultSet myRs6 = myStmt.executeQuery("select count(*) from equipmentmaster where equipmentStatus =3;");
     while(myRs6.next()){
        numberOfRows = Integer.parseInt (myRs6.getString("count(*)"));
        break;
        }
     //creating the 2d array 
        String data[][]= new String[numberOfRows][6];
    ResultSet myRs5 = myStmt.executeQuery("select equipmentId, category, name, currentStatus, "
            + "itRoom, specificStoredLocation from equipmentmaster where equipmentStatus =3;");
    // save the data into array
    for (int x = 0;myRs5.next();x++){
        data[x][0]= myRs5.getString("equipmentId");
        data[x][1]= myRs5.getString("category");
        data[x][2]= myRs5.getString("name");
          if (Integer.parseInt(myRs5.getString("currentStatus")) == 0){
                data[x][3]="free to borrow";
            }
          else{
                data[x][3]= "borrowed";
            }
        data[x][4]= myRs5.getString("itRoom");
        data[x][5]= myRs5.getString("specificStoredLocation");
    }
        //creating table
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
      for(int n=0;n<numberOfRows;n++){
        model.addRow(new Object[]{data[n][0],data[n][1],data[n][2],data[n][3],data[n][4],data[n][5]});
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
   public inventory() {
        initComponents();
        addRowsInTable();
        jTable1.setAutoCreateRowSorter(true);//Done adding sort function
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonBorrow = new javax.swing.JButton();
        jTextFieldUserId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonBack = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldBorrowId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jLabel7.setText("User ID:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel8.setText("User ID:");

        jLabel6.setText("Password:");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID", "Category", "Name", "Status", "IT Room", "Specific Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonBorrow.setText("Borrow");
        jButtonBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrowActionPerformed(evt);
            }
        });

        jTextFieldUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserIdActionPerformed(evt);
            }
        });

        jLabel9.setText("User ID:");

        jLabel10.setText("Password:");

        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jButtonBack.setText("Main Page");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabel11.setText("Equipment ID:");

        jTextFieldBorrowId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBorrowIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(97, 97, 97))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldBorrowId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBorrowId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed

    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextFieldUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserIdActionPerformed

    }//GEN-LAST:event_jTextFieldUserIdActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed

    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void jTextFieldBorrowIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBorrowIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBorrowIdActionPerformed

    private void jButtonBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrowActionPerformed
      

    try{
        String userNameValue = jTextFieldUserId.getText();
        String borrowId = jTextFieldBorrowId.getText();
        Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/borrowrecord","myuser","1222");
        Statement myStmt;
        myStmt = myCon.createStatement();
        ResultSet myRs5 = myStmt.executeQuery("select userId,password, borrowAuthorization, numberOfBorrowedItems from usermaster");
        String userId = null;
        int password = 0;
        int activateKey=0;
        int borrowAuthroization =0;
        int numberOfBorrowedItems = 0;
            while (myRs5.next()){
                userId = myRs5.getString("userId");
                password = myRs5.getInt("password");
                if (userId.equals(userNameValue) && password == Integer.parseInt(new String(jPasswordField.getPassword()))){
                    activateKey=1;
                    borrowAuthroization = myRs5.getInt("borrowAuthorization");
                    numberOfBorrowedItems = myRs5.getInt("numberOfBorrowedItems");
                    break;
                }
            }
            if (activateKey==1){
                 if (borrowAuthroization == 0 || numberOfBorrowedItems >= 2){
                     if (borrowAuthroization == 0 )
                        JOptionPane.showMessageDialog(null, "You have no authroization to borrow equipment. Please find responsible computer"
                                + " sceince teacher in Room 705 to get help" );
                     else if (numberOfBorrowedItems >= 2)
                        JOptionPane.showMessageDialog(null, "You borrowed more then 2 items, please return it before you borrowed a new one" );
                    }
                 else{
                ResultSet myRs6 = myStmt.executeQuery("select equipmentId from equipmentmaster where equipmentStatus = 3 && currentStatus = 0");
                int integerBorrowId = Integer.parseInt(borrowId);
                int activateKey2 =0;
                while (myRs6.next()){
                    if (myRs6.getInt("equipmentId")== integerBorrowId){
                        activateKey2 = 1;
                        break;
                    }
                }
                if (activateKey2 == 1){
                        PreparedStatement currentStatusToBorrow = myCon.prepareStatement("UPDATE equipmentmaster SET currentStatus = 1 where "
                                + "equipmentID = ?;");
                        currentStatusToBorrow.setString(1, borrowId);
                        currentStatusToBorrow.executeUpdate();
                        PreparedStatement borrowTimeLimit = myCon.prepareStatement("Select maxAllowDuration from equipmentmaster where "
                                + "equipmentID = ?;");
                        borrowTimeLimit.setString(1, borrowId);
                        ResultSet myRs8 = borrowTimeLimit.executeQuery();
                        int maxAllowDuration = 0;
                        while (myRs8.next()){
                            maxAllowDuration = myRs8.getInt("maxAllowDuration");
                            break;
                        }
                        PreparedStatement saveToBorrowRecord = myCon.prepareStatement("insert into borrowRecord( equipmentId, userId, dateEnd)values"
                                + " ( ? , ?, curdate()+interval ? day);");
                        saveToBorrowRecord.setInt(1, integerBorrowId);
                        saveToBorrowRecord.setString(2, userNameValue);
                        saveToBorrowRecord.setInt (3, maxAllowDuration);
                        saveToBorrowRecord.execute();
                        
                        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                        try{
                            tableModel.getDataVector().removeAllElements();
                            tableModel.fireTableDataChanged();
                        }
                         catch(Exception E){
                            JOptionPane.showMessageDialog(null,E.getMessage());
                        }
                        addRowsInTable();
                        PreparedStatement updateTimesBorrowRecord = myCon.prepareStatement("Update usermaster set timesBorrowRecord = "
                                + "timesBorrowRecord+1 where userId = ?;");
                        updateTimesBorrowRecord.setString(1, userId);
                        updateTimesBorrowRecord.executeUpdate();
                        PreparedStatement updateNumberOfBorrowedItems = myCon.prepareStatement("Update usermaster set numberOfBorrowedItems = "
                                + "numberOfBorrowedItems+1 where userId = ?;");
                        updateNumberOfBorrowedItems.setString(1, userId);
                        updateNumberOfBorrowedItems.executeUpdate();
                        JOptionPane.showMessageDialog(null,"success in borrowing. Please return it in " + maxAllowDuration + " days");
                }
                else{JOptionPane.showMessageDialog(null,"Item unavailable to be borrowed");};
            }
            }
            else{
                JOptionPane.showMessageDialog(null,"UserID or password incorrect");
            }
            
    }       
    

catch(Exception exc){
    exc.printStackTrace();
}

    }//GEN-LAST:event_jButtonBorrowActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        new firstPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonBorrow;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldBorrowId;
    private javax.swing.JTextField jTextFieldUserId;
    // End of variables declaration//GEN-END:variables
}
