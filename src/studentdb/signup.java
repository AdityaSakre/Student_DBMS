/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.jar.Attributes.Name;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import sun.security.util.Password;

/**
 *
 * @author Dhananjay
 */
public class signup extends javax.swing.JFrame {
        ImageIcon icojk = new ImageIcon("src\\studentdb\\Untitled-3.png");
        ImageIcon icox = new ImageIcon("src\\studentdb\\Untitled-1.png");
        ImageIcon  icoq = new ImageIcon("src\\studentdb\\Untitled-2.png");
        boolean validation()  {
            boolean valid=true;
            String name =jTxt_username.getText();
            if(!name.matches("((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+)|((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+ [A-Z][a-z]+)")){
                jLabel9.setIcon(icox);
                jLabel9.setText("Invalid");
                jLabel12.setForeground(Color.red);
                jLabel12.setText("Start with upper case and contains space between first and last name");
                valid=false;
            }
            else{
                jLabel9.setIcon(icojk);
                jLabel9.setText("Okay");
           
            }
            
            String username = jTxt_name.getText();
            if(username.matches("[A-Z a-z 0-9]{6,}")){      
                jLabel10.setText("Okay");
                jLabel10.setIcon(icojk);
            }
            else{
                jLabel10.setIcon(icox);
                jLabel10.setText("Invalid");
                jLabel13.setForeground(Color.red);
                jLabel13.setText("Username must atleast 6 Characters");
                valid=false;
            }
            char[] password = jPassword.getPassword();
            String pass = new String(password);
            if(!pass.matches("[a-z A-Z 0-9 _ - &]{6,}")){
                jLabel11.setText("Invalid");
                jLabel11.setIcon(icox);
                jLabel14.setForeground(Color.red);
                jLabel14.setText("Password must atleast 6 Characters");
                valid=false;
            }
            else{
                jLabel11.setText("Okay");
                jLabel11.setIcon(icojk);
                jLabel14.setForeground(null);
                jLabel14.setText(null);
            }
            String id=jTxt_id.getText();
            String cat = String.valueOf(category.getSelectedItem());
            if(cat.equals("Student") ){
               if(!id.matches("([0-9]{8}[A-Z][0-9]{5})")) {
                jLabel8.setText("Invalid");
                jLabel8.setIcon(icox);
                jLabel15.setForeground(Color.red);
                jLabel15.setText("Valid format eg 12345678L12345");
                valid=false;
                }
                else{
                jLabel8.setText("Okay");
                jLabel8.setIcon(icojk);
                 jLabel15.setForeground(null);
                jLabel15.setText(null);
                }
            }
            else if(cat.equals("Admin")) {
               if(!id.matches("[0-9]{5}[A-Z]")){
                jLabel8.setText("Invalid");
                jLabel8.setIcon(icox);
                jLabel15.setForeground(Color.red);
                jLabel15.setText("Must 5 Digit and a character eg 12345A");
                valid=false;
               }
               else{
                jLabel8.setText("Okay");
                jLabel8.setIcon(icojk);
                }
            }
            else if(cat.equals("Teacher")) {
               if(!id.matches("[0-9]{5}[A-Z]")){
                jLabel8.setText("Invalid");
                jLabel8.setIcon(icox);
                jLabel15.setForeground(Color.red);
                jLabel15.setText("Must 5 Digit and a character eg 12345A");
                valid=false;
               }
               else{
                jLabel8.setText("Okay");
                jLabel8.setIcon(icojk);
                }
            }
       
            
        return valid;
        }
        
    public static abstract class Ghosttext implements FocusListener,DocumentListener,PropertyChangeListener {
         private final JTextField textfield;
        private boolean isEmpty;
        private Color ghostColor;
        private Color foregroundColor;
        private final String ghostText;

        
        protected Ghosttext(final JTextField textfield, String ghostText) {
            super();
            this.textfield = textfield;
            this.ghostText = ghostText;
            this.ghostColor = Color.LIGHT_GRAY;
            textfield.addFocusListener(this);
            registerListeners();
            updateState();
            if (!this.textfield.hasFocus()) {
                focusLost(null);
            }
        }

        public void delete() {
            unregisterListeners();
            textfield.removeFocusListener(this);
        }

        private void registerListeners() {
            textfield.getDocument().addDocumentListener(this);
            textfield.addPropertyChangeListener("foreground", this);
        }

        private void unregisterListeners() {
            textfield.getDocument().removeDocumentListener(this);
            textfield.removePropertyChangeListener("foreground", this);
        }

        public Color getGhostColor() {
            return ghostColor;
        }

        public void setGhostColor(Color ghostColor) {
            this.ghostColor = ghostColor;
        }

        private void updateState() {
            isEmpty = textfield.getText().length() == 0;
            foregroundColor = textfield.getForeground();
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                    textfield.setText("");
                    textfield.setForeground(foregroundColor);
                } finally {
                    registerListeners();
                }
            }

        }

        @Override
        public void focusLost(FocusEvent e) {
            if (isEmpty) {
                unregisterListeners();
                try {
                    textfield.setText(ghostText);
                    textfield.setForeground(ghostColor);
                } finally {
                    registerListeners();
                }
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            updateState();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateState();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateState();  
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateState();
        }

    }
    
    
    public signup() {
        initComponents();
        signup.Ghosttext ghostText = new signup.Ghosttext(jTxt_username, "Enter Name"){};
        signup.Ghosttext ghostText1 = new signup.Ghosttext(jTxt_name, "Your Username"){};
        signup.Ghosttext ghostText2 = new signup.Ghosttext(jPassword, "Password"){};
        signup.Ghosttext ghostText3 = new signup.Ghosttext(jTxt_id, "ID"){};
        
    
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxt_name = new javax.swing.JTextField();
        jTxt_username = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        category = new javax.swing.JComboBox();
        jTxt_id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("SIGNUP FORM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel2.setText("Name");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        jLabel5.setText("Category");

        jLabel6.setText("     ID");

        jTxt_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_nameFocusLost(evt);
            }
        });
        jTxt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_nameActionPerformed(evt);
            }
        });

        jTxt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_usernameFocusLost(evt);
            }
        });
        jTxt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_usernameActionPerformed(evt);
            }
        });

        jPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFocusLost(evt);
            }
        });

        category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Teacher", "Student" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jTxt_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_idFocusLost(evt);
            }
        });
        jTxt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_idActionPerformed(evt);
            }
        });

        jButton1.setText("Sign Up");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(190, 190, 190))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTxt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(jTxt_username)
                                    .addComponent(jPassword)
                                    .addComponent(jTxt_id))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt_name)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTxt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean valid= validation();
        char[] password = jPassword.getPassword();
            String pass = new String(password);
            
            
        if(valid)  {
            DBconn dbase = new DBconn();
            dbase.connect("DB","Signup");
            String rName = dbase.dbsearch("Username",jTxt_name.getText(),"Category",category.getSelectedItem().toString(),"Name");
            if(rName == null){
            BasicDBObject obj = new BasicDBObject();    
            obj.put("Name",jTxt_username.getText());
            obj.put("Username",jTxt_name.getText());
            obj.put("Password",pass);
            obj.put("Category",category.getSelectedItem().toString());
            obj.put("ID",jTxt_id.getText());
            dbase.connect("DB","Signup", obj);
            JOptionPane.showMessageDialog(rootPane,"Submited");  
            Login frame = new Login();
            signup.this.setVisible(false);
            frame.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(rootPane,"Username Already exist. Use a different one");
            }
        }
         else {        
               JOptionPane.showMessageDialog(rootPane,"Not Submited");
        }
       
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTxt_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_idFocusLost
        // TODO add your handling code here:
        String id= jTxt_id.getText();
        
        String cat = String.valueOf(category.getSelectedItem());
            if(cat.equals("Student") ){
               if(!id.matches("([0-9]{8}[A-Z][0-9]{5})")&& !id.isEmpty()) {
                jLabel8.setText("Invalid");
                jLabel8.setIcon(icox);
                jLabel15.setForeground(Color.red);
                jLabel15.setText("Valid format eg 12345678L12345");
               
                }
               else{
                    if(!id.isEmpty()){
                       jLabel8.setIcon(icojk);
                       jLabel8.setText("Okay");
                       jLabel15.setText(null);
                       jLabel15.setForeground(null);
                        jLabel15.setText(null);
                    }
                    else{
                    jLabel8.setText(null);
                    jLabel8.setIcon(null);
                    jLabel15.setForeground(null);
                    jLabel15.setText(null);
                    }
                }
            }
            else if(cat.equals("Admin")) {
               if(!id.matches("[0-9]{5}[A-Z]") && !id.isEmpty()){
                jLabel8.setText("Invalid");
                jLabel8.setIcon(icox);
                jLabel15.setForeground(Color.red);
                jLabel15.setText("Must 5 Digit and a character eg 12345A");
             
               }
               else{
                   if(!id.isEmpty()){
                       jLabel8.setIcon(icojk);
                       jLabel8.setText("Okay");
                       jLabel15.setForeground(null);
                       jLabel15.setText(null);
                    }
                    else{
                    jLabel8.setText(null);
                    jLabel8.setIcon(null);
                    jLabel15.setForeground(null);
                jLabel15.setText(null);
                    }
                   
                }
            }
            else if(cat.equals("Teacher")) {
               if(!id.matches("[0-9]{5}[A-Z]") && !id.isEmpty()){
                jLabel8.setText("Invalid");
                jLabel8.setIcon(icox);
                jLabel15.setForeground(Color.red);
                jLabel15.setText("Must 5 Digit and a character eg 12345A");
             
               }
               else{
               if(!id.isEmpty()){
                       jLabel8.setIcon(icojk);
                       jLabel8.setText("Okay");
                       jLabel15.setText(null);
                       jLabel15.setForeground(null);
                    }
                    else{
                    jLabel8.setText(null);
                    jLabel8.setIcon(null);
                    jLabel15.setForeground(null);
                    jLabel15.setText(null);
                    }
                }
        
            }
    }//GEN-LAST:event_jTxt_idFocusLost

    private void jTxt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_idActionPerformed
        // TODO add your handling code here:
        //jTxt_id.setToolTipText("Subject ID must be no.s and starting with a character");
    }//GEN-LAST:event_jTxt_idActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
        String id= jTxt_id.getText();
        System.out.println(id);
        String cat = String.valueOf(category.getSelectedItem());
            if(cat.equals("Student") ){
               if(!id.matches("([0-9]{8}[A-Z][0-9]{5})") && !id.equals("ID")) {
                jLabel8.setText("Invalid");
                jLabel8.setIcon(icox);
                jLabel15.setForeground(Color.red);
                jLabel15.setText("Valid format eg 12345678L12345");
               
                }
               else{
                    if(!id.equals("ID")){
                       jLabel8.setIcon(icojk);
                       jLabel8.setText("Okay");
                       jLabel15.setText(null);
                       jLabel15.setForeground(null);
                        jLabel15.setText(null);
                    }
                    else{
                    jLabel8.setText(null);
                    jLabel8.setIcon(null);
                    jLabel15.setForeground(null);
                    jLabel15.setText(null);
                    }
                }
            }
            else if(cat.equals("Admin")) {
               if(!id.matches("[0-9]{5}[A-Z]") && !id.equals("ID")){
                jLabel8.setText("Invalid");
                jLabel8.setIcon(icox);
                jLabel15.setForeground(Color.red);
                jLabel15.setText("Must 5 Digit and a character eg 12345A");
             
               }
               else{
                   if(!id.equals("ID")){
                       jLabel8.setIcon(icojk);
                       jLabel8.setText("Okay");
                       jLabel15.setForeground(null);
                       jLabel15.setText(null);
                    }
                    else{
                    jLabel8.setText(null);
                    jLabel8.setIcon(null);
                    jLabel15.setForeground(null);
                jLabel15.setText(null);
                    }
                   
                }
            }
            else if(cat.equals("Teacher")) {
               if(id.matches("[0-9]{5}[A-Z]") || id.equals("ID")){
                   if(!id.equals("ID")){
                       jLabel8.setIcon(icojk);
                       jLabel8.setText("Okay");
                       jLabel15.setText(null);
                       jLabel15.setForeground(null);
                   }
                   else{
                       jLabel8.setText(null);
                       jLabel8.setIcon(null);
                       jLabel15.setForeground(null);
                       jLabel15.setText(null);
                   }
               }
               else{
                   jLabel8.setText("Invalid");
                   jLabel8.setIcon(icox);
                   jLabel15.setForeground(Color.red);
                   jLabel15.setText("Must 5 Digit and a character eg 12345A");
                   
               }
        
            }
        
    }//GEN-LAST:event_categoryActionPerformed

    private void jTxt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_nameActionPerformed
            
    }//GEN-LAST:event_jTxt_nameActionPerformed

    private void jTxt_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_nameFocusLost
        // TODO add your handling code here:
        String name = jTxt_name.getText();
        if(name.matches("[a-z A-Z 0-9]{6,}") || name.isEmpty() ){
           if(!name.isEmpty()){
                jLabel10.setIcon(icojk);
                jLabel10.setText("Okay");
                jLabel13.setText(null);
            }
            else{
                jLabel10.setIcon(null);
                jLabel10.setText(null);
                jLabel13.setForeground(null);
                jLabel13.setText(null);
            }
        }
        else{
            jLabel10.setIcon(icox);
            jLabel10.setText("Invalid");
            jLabel13.setForeground(Color.red);
            jLabel13.setText("Username must atleast 6 Characters");
        }
        
    }//GEN-LAST:event_jTxt_nameFocusLost

    private void jTxt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_usernameFocusLost
        // TODO add your handling code here:
         
       String username = jTxt_username.getText();
        if(username.matches("((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+)|((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+ [A-Z][a-z]+)") || username.isEmpty()){
            if(!username.isEmpty()){
                jLabel9.setIcon(icojk);
                jLabel9.setText("Okay");
                jLabel12.setText(null);
            }
            else{
                jLabel9.setIcon(null);
                jLabel9.setText(null);
                jLabel12.setForeground(null);
                jLabel12.setText(null);
            }

        }
        else{
            jLabel9.setText("Invalid");
            jLabel9.setIcon(icox);
            jLabel12.setForeground(Color.red);
            jLabel12.setText("Start with uppercase and contains space between first and last name");
        } 
    }//GEN-LAST:event_jTxt_usernameFocusLost

    private void jPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusLost
        // TODO add your handling code here:
        
        char[] password = jPassword.getPassword();
        String pass = new String(password);
       if(pass.matches("[a-z A-Z]{6,}")||pass.isEmpty()){
           if(!pass.isEmpty()){
                jLabel11.setIcon(icojk);
                jLabel11.setText("Okay");
                jLabel14.setText(null);
            }
            else{
                jLabel11.setIcon(null);
                jLabel11.setText(null);
                jLabel14.setForeground(null);
                jLabel14.setText(null);
            }
           
           
       }
       else{
            jLabel11.setText("Invalid");
           jLabel11.setIcon(icox);
           jLabel14.setForeground(Color.red);
           jLabel14.setText("Password must atleast 6 Characters");
       
       }
        
    }//GEN-LAST:event_jPasswordFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Login log = new Login();
        this.setVisible(false);
        log.setVisible(true);
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
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox category;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTxt_id;
    private javax.swing.JTextField jTxt_name;
    private javax.swing.JTextField jTxt_username;
    // End of variables declaration//GEN-END:variables
}
