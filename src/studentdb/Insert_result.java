package studentdb;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.awt.Color;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author INTEL
 */
public class Insert_result extends javax.swing.JFrame {
    ImageIcon icojk = new ImageIcon("src\\studentdb\\Untitled-3.png");
    ImageIcon icox = new ImageIcon("src\\studentdb\\Untitled-1.png");
    ImageIcon  icoq = new ImageIcon("src\\studentdb\\Untitled-2.png");
    /**
     * Creates new form in_result
     */String Name;
       void setNameof(String name){
            Name = name;
            //jLab_UserNAME.setText(Name);
        } 
     boolean validation()  {
         
         boolean valid=true;
        String stuid = jTextField1.getText();
        if(stuid.matches("[0-9]{8}[A-Z][0-9]{5}")){
            
            jLabel6.setText("Okay");
            jLabel6.setIcon(icojk);
        }
        else{
            jLabel6.setText("Invalid");
            jLabel6.setIcon(icox);
            jLabel6.setToolTipText("Enter a Student Id.");
            valid=false;
        }
        
        String resultid=jTextField2.getText();
        if(resultid.matches("[A-Z]{1}[0-9]{9}")){
            
            jLabel8.setText("Okay");
            jLabel8.setIcon(icojk);
            
        }
        else{
            jLabel8.setText("Invalid");
            jLabel8.setIcon(icox);
            jLabel8.setToolTipText("Enter a ResultId.");
            valid=false;
        
        }
        
          String ROLLNO = jtxt_roll.getText();
        
        if(ROLLNO.matches("[A-Z]+{2,}[0-9]{3}") ) {
        
                jLbl_roll.setIcon(icojk);
                jLbl_roll.setText("Okay");
        }
        else{
            
            jLbl_roll.setText("Invalid");
            jLbl_roll.setIcon(icox);
            jLbl_roll.setText("Enter Proper Rollno Ex:TEIT146");
            valid=false;
            //jLabel5.setForeground(Color.red);
            //jLabel5.setText("Enter Proper Rollno Ex:TEIT146");
        }
        String VALUE = jtxt_val.getText();
        
        if((VALUE.matches("[0-9]+{1,2}[.][0-9]+{1,2}")) ) {

            jlbl_val.setIcon(icojk);
            jlbl_val.setText("Okay");
            jLabel6.setText(null);
        }
        else{
            jlbl_val.setText("Invalid");
            jlbl_val.setIcon(icox);
            jlbl_val.setToolTipText("Enter vaild mark eg 88.00");
            valid=false;
        }
        return valid;
     }
    public Insert_result() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxt_roll = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jtxt_val = new javax.swing.JTextField();
        jLbl_roll = new javax.swing.JLabel();
        jlbl_val = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Enter the Rollno :");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setRequestFocusEnabled(false);

        jtxt_roll.setName("jtxt_ROLLNO"); // NOI18N
        jtxt_roll.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_rollFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Enter Marks");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7" }));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Choose the sem");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtxt_val.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_valFocusLost(evt);
            }
        });

        jLbl_roll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLbl_rollMouseReleased(evt);
            }
        });
        jLbl_roll.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLbl_rollFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLbl_rollFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("Student Id");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Result Id");

        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jtxt_val, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxt_roll)
                            .addComponent(jComboBox1, 0, 128, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2))))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLbl_roll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                    .addComponent(jlbl_val, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLbl_roll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxt_roll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxt_val, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_val, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel2.setBackground(java.awt.Color.cyan);

        jLabel1.setBackground(java.awt.Color.cyan);
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Insert Result ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            boolean valid=validation();
            if(valid)  {
            String ROLLNO = jtxt_roll.getText();
            String VALUE = jtxt_val.getText();
            String SELECT= jComboBox1.getSelectedItem().toString();             
             DBconn dbase = new DBconn();
            BasicDBObject obj=new BasicDBObject();
            obj.put("SubjectId",jTextField1.getText());
            obj.put("ResultId",jTextField2.getText());
            obj.put("Rollno",ROLLNO);
            obj.put("Semester",SELECT);
            obj.put("Result",VALUE);
            dbase.connect("DB","Result", obj);
           JOptionPane.showMessageDialog(rootPane,"Submited");
           
        }
        else{
           JOptionPane.showMessageDialog(rootPane,"Not Submited");
        }
          
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLbl_rollFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLbl_rollFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLbl_rollFocusLost

    private void jLbl_rollFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLbl_rollFocusGained
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jLbl_rollFocusGained

    private void jLbl_rollMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbl_rollMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLbl_rollMouseReleased

    private void jtxt_rollFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_rollFocusLost
         //TODO add your handling code here:

          String ROLLNO = jtxt_roll.getText();
        
        if((ROLLNO.matches("[A-Z]+{2,}[0-9]{3}") || ROLLNO.isEmpty()) ) {
            if(!ROLLNO.isEmpty()){
                jLbl_roll.setIcon(icojk);
                jLbl_roll.setText("Okay");
                //jLabel5.setText(null);
                jLbl_roll.setToolTipText(null);
            }
            else{
                jLbl_roll.setIcon(null);
                jLbl_roll.setText(null);
            }
    }
        else{
            
            jLbl_roll.setText("Invalid");
            jLbl_roll.setIcon(icox);
            //jLabel5.setForeground(Color.red);
            jLbl_roll.setToolTipText("Enter Proper Rollno Ex:TEIT146");
        }
    }//GEN-LAST:event_jtxt_rollFocusLost

    private void jtxt_valFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_valFocusLost
        // TODO add your handling code here:
      
          String VALUE = jtxt_val.getText();
        
        if((VALUE.matches("[0-9]+{1,2}[.][0-9]+{1,2}") || VALUE.isEmpty()) ) {
            if(!VALUE.isEmpty()){
                jlbl_val.setIcon(icojk);
                jlbl_val.setText("Okay");
                jlbl_val.setToolTipText(null);
            }
            else{
                jlbl_val.setIcon(null);
                jlbl_val.setText(null);
                jlbl_val.setToolTipText(null);
            }
    }
        else{
            jlbl_val.setText("Invalid");
            jlbl_val.setIcon(icox);
            jlbl_val.setToolTipText("Enter vaild mark eg 88.00");
            //jLabel6.setForeground(Color.red);
            //jLabel6.setText("Enter proper Percentage");
        }
    }//GEN-LAST:event_jtxt_valFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Admin_option home= new Admin_option();
        this.setVisible(false);
        home.setNameof(Name);
        home.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
         String stuid = jTextField1.getText();
        if(stuid.matches("[0-9]{8}[A-Z][0-9]{5}")|| stuid.isEmpty()){
            if(!stuid.isEmpty()){
            jLabel6.setText("Okay");
            jLabel6.setIcon(icojk);
            }
            else{
            jLabel6.setText(null);
            jLabel6.setIcon(null);
            jLabel6.setToolTipText(null);
            }
        }
        else{
            jLabel6.setText("Invalid");
            jLabel6.setIcon(icox);
            jLabel6.setToolTipText("Enter a Valid Blood Group.");
        }
        
        
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
         String resultid=jTextField2.getText();
        if(resultid.matches("[A-Z]{1}[0-9]{9}")|| resultid.isEmpty()){
            if(!resultid.isEmpty()){
            jLabel8.setText("Okay");
            jLabel8.setIcon(icojk);
            }
            else{
            jLabel8.setText(null);
            jLabel8.setIcon(null);
            jLabel8.setToolTipText(null);
            }
        }
        else{
            jLabel8.setText("Invalid");
            jLabel8.setIcon(icox);
            jLabel8.setToolTipText("Enter a Valid resultid eg.:A123456789");
        }
        
    }//GEN-LAST:event_jTextField2FocusLost
  
   
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
            java.util.logging.Logger.getLogger(Insert_result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insert_result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insert_result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insert_result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new Insert_result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLbl_roll;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jlbl_val;
    private javax.swing.JTextField jtxt_roll;
    private javax.swing.JTextField jtxt_val;
    // End of variables declaration//GEN-END:variables
}
