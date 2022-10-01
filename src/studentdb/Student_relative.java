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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Student_relative
 */
public class Student_relative extends javax.swing.JFrame {
    ImageIcon icojk = new ImageIcon("src\\studentdb\\Untitled-3.png");
        ImageIcon icox = new ImageIcon("src\\studentdb\\Untitled-1.png");
        ImageIcon  icoq = new ImageIcon("src\\studentdb\\Untitled-2.png");
    /**
     * Creates new form NewJFrame1
     */
    String Name;
       void setNameof(String name){
            Name = name;
            //jLab_UserNAME.setText(Name);
        }
        
    boolean validation()  {
        boolean valid=true;
        
        String stuid = jTxt_stuid.getText();
        if(stuid.matches("[0-9]{8}[A-Z][0-9]{5}")){
            jLabV_stuid.setText("Okay");
            jLabV_stuid.setIcon(icojk);
        }
        else{
             jLabV_stuid.setText("Invalid");
            jLabV_stuid.setIcon(icox);
            jLabV_stuid.setToolTipText("Enter a Valid Student ID.");
            valid=false;
        
        }
        
        String name = jTxt_name.getText();
        if(!name.matches("((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+)|((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+ [A-Z][a-z]+)")){
            jLab_name.setText("Invalid");
           jLab_name.setIcon(icox);
           jLab_name.setToolTipText("Name Should Start with upper case and contains space between first and last name");
           valid=false;
        }
         else{
            jLab_name.setIcon(icojk);
           jLab_name.setText("Okay");
           
        }
        /*String Occupation = jTxt_occupation.getText();
        
        if((Occupation.matches("[A-Z a-z]+")||Occupation.isEmpty()) ){
                 if(!Occupation.isEmpty()){
                jLabel18.setIcon(icojk);
                jLabel18.setText("Okay");
            }
            else{
                jLabel18.setIcon(null);
                jLabel18.setText(null);
            }
        }
        else{
            valid=false;
            jLabel18.setText("Invalid");
            jLabel18.setIcon(icox);
            jLabel18.setToolTipText("Occupation should not be empty and Mandatory");
        }*/
        
        
        String phone = jTxt_phone.getText();
        if(!phone.matches("[0-9]{10}")){
            jLabV_phone.setText("Invalid");
           jLabV_phone.setIcon(icox);
           jLabV_phone.setToolTipText("Enter a Valid Mobile no.");
           valid=false;
        }
         else{
            jLabV_phone.setIcon(icojk);
           jLabV_phone.setText("Okay");
           
        }
        
        
        String phone1 = jTxt_phone1.getText();
        if(phone1.matches("[0-9]{10}") || phone1.isEmpty() ){
            if(!phone1.isEmpty()){
            jLabV_phone1.setIcon(icojk);
            jLabV_phone1.setText("Okay");
            }
            else{
            jLabV_phone1.setIcon(null);
            jLabV_phone1.setText(null);
            }
        }
        else{
            jLabV_phone1.setText("Invalid");
            jLabV_phone1.setIcon(icox);
            jLabV_phone1.setToolTipText("Enter a Valid Mobile no.");
            valid=false;
        }
        
        String email = jTxt_mail.getText();
        email = email.toLowerCase();
        if(email.matches("[a-z]([a-zA-Z0-9_.])+[@][a-z0-9]+(([.]{1}[a-z]{2,})|([.]{1}[a-z]{2,}[.]{1}[a-z]{2,}))" )){
            jLabV_mail.setIcon(icojk);
            jLabV_mail.setText("Okay");
            
        }
        else{
            jLabV_mail.setText("Invalid");
            jLabV_mail.setIcon(icox);
            jLabV_mail.setToolTipText("Enter a Valid E-mail.");
            valid=false;
        }
        
        String email1 = jTxt_mail1.getText();
        email1 = email1.toLowerCase();
        if(email1.matches("[a-z]([a-zA-Z0-9_.])+[@][a-z0-9]+(([.]{1}[a-z]{2,})|([.]{1}[a-z]{2,}[.]{1}[a-z]{2,}))" ) || email1.isEmpty() ){
            if(!email1.isEmpty()){
                if(email1.equals(email)){
                    jLabV_mail1.setText("Invalid");
                    jLabV_mail1.setIcon(icoq);
                     jLabV_mail1.setToolTipText("Both emails are same");
                }
                else{
                jLabV_mail1.setIcon(icojk);
                jLabV_mail1.setText("Okay");
                }
            }
            else{
            jLabV_mail1.setIcon(null);
            jLabV_mail1.setText(null);
            }
        }
        else{
           
            jLabV_mail1.setText("Invalid");
            jLabV_mail1.setIcon(icox);
            jLabV_mail1.setToolTipText("Enter a Valid E-mail.");
            valid=false;
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
    public Student_relative() {
        initComponents();
        Student_relative.Ghosttext ghostText = new Student_relative.Ghosttext(jTxt_stuid, "Enter PRN"){};
      Student_relative.Ghosttext ghostText1 = new Student_relative.Ghosttext(jTxt_name, "Your name"){};
        Student_relative.Ghosttext ghostText2 = new Student_relative.Ghosttext(jTxt_phone, "Phone"){};
     Student_relative.Ghosttext ghostText3 = new Student_relative.Ghosttext(jTxt_phone1, "Alternate phone"){};
        Student_relative.Ghosttext ghostText4 = new Student_relative.Ghosttext(jTxt_occupation, "Occuption"){};
        Student_relative.Ghosttext ghostText10 = new Student_relative.Ghosttext(jTxt_address2, "Address line 2"){};
        Student_relative.Ghosttext ghostText5 = new Student_relative.Ghosttext(jTxt_address3, "Address line 3"){};
        Student_relative.Ghosttext ghostText6 = new Student_relative.Ghosttext(jTxt_address1, "Address line 1"){};
        Student_relative.Ghosttext ghostText7 = new Student_relative.Ghosttext(jTxt_mail, "Enter Email address"){};
        Ghosttext ghostText8 = new Ghosttext(jTxt_mail1, "Alternative  Email address"){};
     Student_relative.Ghosttext ghostText9 = new Student_relative.Ghosttext(jTxt_rel, "Enter relation e.g.(Father,Mother)"){};
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxt_stuid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxt_name = new javax.swing.JTextField();
        jTxt_occupation = new javax.swing.JTextField();
        jTxt_phone = new javax.swing.JTextField();
        jTxt_mail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxt_mail1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxt_phone1 = new javax.swing.JTextField();
        jTxt_address2 = new javax.swing.JTextField();
        jTxt_address3 = new javax.swing.JTextField();
        jLabV_stuid = new javax.swing.JLabel();
        jLab_name = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabV_phone = new javax.swing.JLabel();
        jLabV_phone1 = new javax.swing.JLabel();
        jLabV_mail = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabV_mail1 = new javax.swing.JLabel();
        jTxt_address1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxt_rel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("Enter Parents Information:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel2.setText(" Student ID");

        jTxt_stuid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_stuidFocusLost(evt);
            }
        });

        jLabel3.setText("Name");

        jLabel4.setText("Occupation");

        jLabel5.setText("Email ");

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

        jTxt_occupation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_occupationFocusLost(evt);
            }
        });

        jTxt_phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_phoneFocusLost(evt);
            }
        });
        jTxt_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_phoneActionPerformed(evt);
            }
        });

        jTxt_mail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_mailFocusLost(evt);
            }
        });

        jLabel6.setText("Address");

        jTxt_mail1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_mail1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_mail1FocusLost(evt);
            }
        });

        jLabel7.setText("Phone");

        jTxt_phone1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_phone1.setToolTipText("");
        jTxt_phone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_phone1FocusLost(evt);
            }
        });
        jTxt_phone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_phone1ActionPerformed(evt);
            }
        });

        jTxt_address2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_address2ActionPerformed(evt);
            }
        });

        jTxt_address1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_address1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Relation");

        jTxt_rel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_relActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxt_address1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxt_address3, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                            .addComponent(jTxt_address2)
                            .addComponent(jTxt_mail1)
                            .addComponent(jTxt_mail)
                            .addComponent(jTxt_phone1)
                            .addComponent(jTxt_phone)
                            .addComponent(jTxt_occupation)
                            .addComponent(jTxt_name)
                            .addComponent(jTxt_stuid)
                            .addComponent(jTxt_rel))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabV_phone1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addGap(121, 121, 121))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabV_mail1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jLabV_stuid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLab_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabV_phone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabV_mail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(83, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabV_stuid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxt_stuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLab_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxt_occupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jTxt_rel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jLabV_phone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxt_phone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabV_phone1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabV_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabV_mail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxt_mail1))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxt_address1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxt_address2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxt_address3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton2)
                .addGap(198, 198, 198)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_nameActionPerformed

    private void jTxt_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_phoneActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTxt_phoneActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTxt_phone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_phone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_phone1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean valid=validation();
        if(valid)  {
                DBconn dbase = new DBconn();
                BasicDBObject obj = new BasicDBObject();
                obj.put("StudentId",jTxt_stuid.getText());
                obj.put("Name",jTxt_name.getText());
                obj.put("Occupation",jTxt_occupation.getText());
                obj.put("Relation",jTxt_rel.getText());
                obj.put("PhoneNo",jTxt_phone.getText());
                obj.put("PhoneNo1",jTxt_phone1.getText());
                obj.put("EmailId",jTxt_mail.getText());
                obj.put("EmailId1",jTxt_mail1.getText());
                obj.put("Address1",jTxt_address1.getText());
                obj.put("Address2",jTxt_address2.getText());
                obj.put("Address3",jTxt_address3.getText());
                dbase.connect("DB","Relative", obj);
            JOptionPane.showMessageDialog(rootPane,"Submited");  
        }
         else {        
               JOptionPane.showMessageDialog(rootPane,"Not Submited");
        }
            
            
        
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Admin_option home= new Admin_option();
        this.setVisible(false);
        home.setVisible(true);
        home.setNameof(Name);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTxt_stuidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_stuidFocusLost
        // TODO add your handling code here:
        String stuid = jTxt_stuid.getText();
        if(stuid.matches("[0-9]{8}[A-Z][0-9]{5}")|| stuid.isEmpty()){
            if(!stuid.isEmpty()){
            jLabV_stuid.setText("Okay");
            jLabV_stuid.setIcon(icojk);
            }
            else{
            jLabV_stuid.setText(null);
            jLabV_stuid.setIcon(null);
            jLabV_stuid.setToolTipText(null);
            }
        }
        else{
            jLabV_stuid.setText("Invalid");
            jLabV_stuid.setIcon(icox);
            jLabV_stuid.setToolTipText("Enter a Valid Blood Group.");
        }
        
    }//GEN-LAST:event_jTxt_stuidFocusLost

    private void jTxt_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_nameFocusLost
        // TODO add your handling code here:
       String name = jTxt_name.getText();
        if(name.matches("((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+)|((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+ [A-Z][a-z]+)") || name.isEmpty()){
            if(!name.isEmpty()){
                jLab_name.setIcon(icojk);
                jLab_name.setText("Okay");
            }
            else{
                jLab_name.setIcon(null);
                jLab_name.setText(null);
            }

        }
        else{
            jLab_name.setText("Invalid");
            jLab_name.setIcon(icox);
            jLab_name.setToolTipText("Name Should Start with upper case and contains space between first and last name");
        }
        
    }//GEN-LAST:event_jTxt_nameFocusLost

    private void jTxt_occupationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_occupationFocusLost
        // TODO add your handling code here:
        /*String Occupation = jTxt_occupation.getText();
        
        if((Occupation.matches("[A-Z a-z]+")||Occupation.isEmpty()) ){
                 if(!Occupation.isEmpty()){
                jLabel18.setIcon(icojk);
                jLabel18.setText("Okay");
            }
            else{
                jLabel18.setIcon(null);
                jLabel18.setText(null);
            }
        }
        else{
            //valid=false;
            jLabel18.setText("Invalid");
            jLabel18.setIcon(icox);
            jLabel18.setToolTipText("Occupation should not be empty and Mandatory");
        }*/
        
    }//GEN-LAST:event_jTxt_occupationFocusLost

    private void jTxt_phoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_phoneFocusLost
        // TODO add your handling code here:
        String phone = jTxt_phone.getText();
        if(phone.matches("[0-9]{10}") || phone.isEmpty()){
            if(!phone.isEmpty()){
                jLabV_phone.setIcon(icojk);
                jLabV_phone.setText("Okay");
            }
            else{
                jLabV_phone.setIcon(null);
                jLabV_phone.setText(null);
            }
        }
        else{
            jLabV_phone.setText("Invalid");
            jLabV_phone.setIcon(icox);
            jLabV_phone.setToolTipText("Enter a Valid Mobile no.");
        }
    }//GEN-LAST:event_jTxt_phoneFocusLost

    private void jTxt_phone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_phone1FocusLost
        // TODO add your handling code here:
        String phone = jTxt_phone.getText();
        String phone1 = jTxt_phone1.getText();
        if(phone1.matches("[0-9]{10}") || phone1.isEmpty() ){
            if(!phone1.isEmpty()){
                if(phone1.equals(phone)){
                    jLabV_phone1.setIcon(icoq);
                    jLabV_phone1.setText("invalid");
                    jLabV_phone1.setToolTipText("Both Phone no.s are same");
                }
                else{
                    jLabV_phone1.setIcon(icojk);
                    jLabV_phone1.setText("Okay");
                    jLabV_phone1.setToolTipText(null);
                }
            }
            else{
                jLabV_phone1.setIcon(null);
                jLabV_phone1.setText(null);
            }
        }
        else{
            jLabV_phone1.setText("Invalid");
            jLabV_phone1.setIcon(icox);
            jLabV_phone1.setToolTipText("Enter a Valid Mobile no.");
        }
    }//GEN-LAST:event_jTxt_phone1FocusLost

    private void jTxt_mailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_mailFocusLost
        // TODO add your handling code here:
        String email = jTxt_mail.getText();
        email = email.toLowerCase();
        if(email.matches("[a-z]([a-zA-Z0-9_.])+[@][a-z0-9]+(([.]{1}[a-z]{2,})|([.]{1}[a-z]{2,}[.]{1}[a-z]{2,}))" ) || email.isEmpty() ){
            if(!email.isEmpty()){
                jLabV_mail.setIcon(icojk);
                jLabV_mail.setText("Okay");
                jLabV_mail.setToolTipText(null);
            }
            else{

                jLabV_mail.setIcon(null);
                jLabV_mail.setText(null);
                jLabV_mail.setToolTipText(null);

            }
        }
        else{
            jLabV_mail.setText("Invalid");
            jLabV_mail.setIcon(icox);
            jLabV_mail.setToolTipText("Enter a Valid E-mail.");

        }
       
    }//GEN-LAST:event_jTxt_mailFocusLost

    private void jTxt_mail1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_mail1FocusLost
        // TODO add your handling code here:
        
        String email = jTxt_mail.getText();
        email = email.toLowerCase();
        String email1 = jTxt_mail1.getText();
        email1 = email1.toLowerCase();
        if((email1.matches("[a-z][a-z0-9_.]+[@][a-z0-9]+(([.]{1}[a-z]{2,})|([.]{1}[a-z]{2,}[.]{1}[a-z]{2,}))") || email1.isEmpty() )){
            if(!email1.isEmpty()){
                if(email1.equals(email)){
                    jLabV_mail1.setText("Invalid");
                    jLabV_mail1.setIcon(icoq);
                    jLabV_mail1.setToolTipText("Both emails are same");
                }
                else{
                    jLabV_mail1.setIcon(icojk);
                    jLabV_mail1.setText("Okay");
                }
            }
            else{
                jLabV_mail1.setIcon(null);
                jLabV_mail1.setText(null);
            }
        }
        else{
            jLabV_mail1.setText("Invalid");
            jLabV_mail1.setIcon(icox);
            jLabV_mail1.setToolTipText("Enter a Valid E-mail.");
        }
    }//GEN-LAST:event_jTxt_mail1FocusLost

    private void jTxt_address1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_address1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_address1ActionPerformed

    private void jTxt_relActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_relActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_relActionPerformed

    private void jTxt_address2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_address2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_address2ActionPerformed

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
            java.util.logging.Logger.getLogger(Student_relative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_relative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_relative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_relative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_relative().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabV_mail;
    private javax.swing.JLabel jLabV_mail1;
    private javax.swing.JLabel jLabV_phone;
    private javax.swing.JLabel jLabV_phone1;
    private javax.swing.JLabel jLabV_stuid;
    private javax.swing.JLabel jLab_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTxt_address1;
    private javax.swing.JTextField jTxt_address2;
    private javax.swing.JTextField jTxt_address3;
    private javax.swing.JTextField jTxt_mail;
    private javax.swing.JTextField jTxt_mail1;
    private javax.swing.JTextField jTxt_name;
    private javax.swing.JTextField jTxt_occupation;
    private javax.swing.JTextField jTxt_phone;
    private javax.swing.JTextField jTxt_phone1;
    private javax.swing.JTextField jTxt_rel;
    private javax.swing.JTextField jTxt_stuid;
    // End of variables declaration//GEN-END:variables
}
