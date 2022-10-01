/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdb;


import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.mongodb.BasicDBObject;

/**
 *
 * @author Aditya
 */
public class Student_insert extends javax.swing.JFrame {
    
    String Name;
       void setNameof(String name){
            Name = name;
            //jLab_UserNAME.setText(Name);
        }  
    boolean validation(){
    String PNR = jtxt_prn.getText();
        boolean valid = true;
        if(!PNR.matches("[0-9]+[A-Z]{1}")){
           jLabel12.setText("Invalid");
           jLabel12.setIcon(icox);
            jLabel12.setToolTipText("PRN must be no.s ending with a character");
            valid=false;
        }
        else{
            jLabel12.setIcon(icojk);
           jLabel12.setText("Okay");
        }
        
        String name = jTxt_name.getText();
        if(!name.matches("((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+)|((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+ [A-Z][a-z]+)")){
            jLabel11.setText("Invalid");
           jLabel11.setIcon(icox);
           jLabel11.setToolTipText("Name Should Start with upper case and contains space between first and last name");
           valid=false;
        }
         else{
            jLabel11.setIcon(icojk);
           jLabel11.setText("Okay");
           
        }
        
        String Rollno =  jTxt_roll.getText();
        if(!Rollno.matches("[A-Z]{2,5}[0-9]{3,}")){
            jLabel13.setText("Invalid");
           jLabel13.setIcon(icox);
           jLabel13.setToolTipText("Roll is Invalid  Enter complete Roll no Example TEIT146");
           valid=false;
        }
         else{
            jLabel13.setIcon(icojk);
           jLabel13.setText("Okay");
           
        }
        String phone = jTxt_phone.getText();
        if(!phone.matches("[0-9]{10}")){
            jLabel14.setText("Invalid");
           jLabel14.setIcon(icox);
           jLabel14.setToolTipText("Enter a Valid Mobile no.");
           valid=false;
        }
         else{
            jLabel14.setIcon(icojk);
           jLabel14.setText("Okay");
           
        }
        
        
        String phone1 = jTxt_phone1.getText();
        if(phone1.matches("[0-9]{10}") || phone1.isEmpty() ){
            if(!phone1.isEmpty()){
            jLabel15.setIcon(icojk);
            jLabel15.setText("Okay");
            }
            else{
            jLabel15.setIcon(null);
            jLabel15.setText(null);
            }
        }
        else{
            jLabel15.setText("Invalid");
            jLabel15.setIcon(icox);
            jLabel15.setToolTipText("Enter a Valid Mobile no.");
            valid=false;
        }
        
        String email = jTxt_mail.getText();
        email = email.toLowerCase();
        if(email.matches("[a-z]([a-zA-Z0-9_.])+[@][a-z0-9]+(([.]{1}[a-z]{2,})|([.]{1}[a-z]{2,}[.]{1}[a-z]{2,}))" )){
            jLabel16.setIcon(icojk);
            jLabel16.setText("Okay");
            
        }
        else{
            jLabel16.setText("Invalid");
            jLabel16.setIcon(icox);
            jLabel16.setToolTipText("Enter a Valid E-mail.");
            valid=false;
        }
        
        String email1 = jTxt_mail1.getText();
        email1 = email1.toLowerCase();
        if(email1.matches("[a-z]([a-zA-Z0-9_.])+[@][a-z0-9]+(([.]{1}[a-z]{2,})|([.]{1}[a-z]{2,}[.]{1}[a-z]{2,}))" ) || email1.isEmpty() ){
            if(!email1.isEmpty()){
                if(email1.equals(email)){
                     jLabel21.setText("Invalid");
                     jLabel21.setIcon(icoq);
                     jLabel21.setToolTipText("Both emails are same");
                }
                else{
                jLabel21.setIcon(icojk);
                jLabel21.setText("Okay");
                }
            }
            else{
            jLabel21.setIcon(null);
            jLabel21.setText(null);
            }
        }
        else{
           
            jLabel21.setText("Invalid");
            jLabel21.setIcon(icox);
            jLabel21.setToolTipText("Enter a Valid E-mail.");
            valid=false;
        }
        
        String blood = jTxt_Blood.getText();
        if(blood.matches("([ABO]{1}|(AB))[+ -]{1}" )){
            jLabel17.setIcon(icojk);
            jLabel17.setText("Okay");
            
        }
        else{
            jLabel17.setText("Invalid");
            jLabel17.setIcon(icox);
            jLabel17.setToolTipText("Enter a Valid Blood Group.");
            valid=false;
         }
        
         String Collid = jTxt_CoId.getText();
         if(Collid.matches("[0-9]+")){
            jLabel19.setIcon(icojk);
            jLabel19.setText("Okay");
            
        }
        else{
            jLabel19.setText("Invalid");
            jLabel19.setIcon(icox);
            jLabel19.setToolTipText("Enter a Valid College Id.");
            valid=false;
         }
         
        String stuid = jTxt_Stuid.getText();
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
        
        Date date= jXDatePicker1.getDate();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String DOB = formatter.format(date);
        
        if(DOB.matches("(([012][0-9])|([(30)(31)]))-(([0][1-9])|([1][0-2]))-(19|20)[0-9]{2}")){
            jLabV_dob.setText("Okay");
            jLabV_dob.setIcon(icojk);
            
        }
        else{
            JOptionPane.showMessageDialog(rootPane, DOB);
             jLabV_dob.setText("Invalid");
            jLabV_dob.setIcon(icox);
            jLabV_dob.setToolTipText("Enter a Valid DOB");
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

    
    
    ImageIcon icojk = new ImageIcon("src\\studentdb\\Untitled-3.png");
        ImageIcon icox = new ImageIcon("src\\studentdb\\Untitled-1.png");
        ImageIcon  icoq = new ImageIcon("src\\studentdb\\Untitled-2.png");
    /**
     * Creates new form NewJFrame1
     */
    public Student_insert() {
        initComponents();
        Ghosttext ghostText = new Ghosttext(jtxt_prn, "Enter PRN"){};
        Ghosttext ghostText1 = new Ghosttext(jTxt_name, "Your name"){};
        Ghosttext ghostText2 = new Ghosttext(jTxt_phone1, "Alternate phone"){};
        Ghosttext ghostText3 = new Ghosttext(jTxt_Blood, "Enter blood type"){};
        Ghosttext ghostText4 = new Ghosttext(jTxt_add1, "Address line 1"){};
        Ghosttext ghostText5 = new Ghosttext(jTxt_add2, "Address line 2"){};
        Ghosttext ghostText6 = new Ghosttext(jTxt_add3, "Address line 3"){};
        Ghosttext ghostText7 = new Ghosttext(jTxt_mail, "Enter Email address"){};
        Ghosttext ghostText8 = new Ghosttext(jTxt_mail1, "Alternative  Email address"){};
        Ghosttext ghostText9 = new Ghosttext(jTxt_phone, "Enter Mobile no."){};
        Ghosttext ghostText10 = new Ghosttext(jTxt_roll, "Enter Roll no. Ex TEIT123"){};
        Ghosttext ghostText11 = new Ghosttext(jTxt_CoId, "Enter College ID"){};
        Ghosttext ghostText12 = new Ghosttext(jTxt_Stuid, "Enter Student ID"){};
    
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxt_prn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxt_name = new javax.swing.JTextField();
        jTxt_roll = new javax.swing.JTextField();
        jTxt_phone = new javax.swing.JTextField();
        jTxt_mail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxt_mail1 = new javax.swing.JTextField();
        jTxt_add3 = new javax.swing.JTextField();
        jTxt_add1 = new javax.swing.JTextField();
        jTxt_add2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxt_phone1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxt_Blood = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTxt_CoId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTxt_Stuid = new javax.swing.JTextField();
        jLabV_stuid = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabV_dob = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Enter Student Detail: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel2.setText("PRN");

        jtxt_prn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxt_prnFocusLost(evt);
            }
        });

        jLabel3.setText("Name");

        jLabel4.setText("Roll No.");

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

        jTxt_roll.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_rollFocusLost(evt);
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
        jTxt_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_mailActionPerformed(evt);
            }
        });

        jLabel6.setText("Address");

        jTxt_mail1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTxt_mail1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_mail1FocusLost(evt);
            }
        });
        jTxt_mail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_mail1ActionPerformed(evt);
            }
        });

        jTxt_add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_add3ActionPerformed(evt);
            }
        });

        jTxt_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_add1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Phone no.");

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

        jLabel8.setText("Blood Group");

        jTxt_Blood.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_BloodFocusLost(evt);
            }
        });

        jLabel9.setText("Date of Birth");

        jLabel10.setText("College Id.");

        jTxt_CoId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_CoIdFocusLost(evt);
            }
        });

        jLabel12.setToolTipText("");

        jLabel22.setText("Student Id");

        jTxt_Stuid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxt_StuidFocusLost(evt);
            }
        });

        jButton1.setText("Submit");
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel22)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jButton2)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTxt_Blood, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_add3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_add2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_add1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_mail1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(jTxt_mail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_phone1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_phone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_roll, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_name, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_prn, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_CoId)
                            .addComponent(jTxt_Stuid)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabV_stuid, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabV_dob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxt_prn)
                        .addComponent(jLabel2))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTxt_roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTxt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt_phone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxt_mail1)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt_add1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxt_add2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxt_add3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTxt_Blood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(69, 69, 69))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabV_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabV_stuid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxt_Stuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTxt_CoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean valid= validation();
        if(valid){
           DBconn dbase = new DBconn();
           BasicDBObject obj = new BasicDBObject();
           obj.put("PRN",jtxt_prn.getText());
           obj.put("NAME",jTxt_name.getText());
           obj.put("ROLLNO",jTxt_roll.getText());
           obj.put("EMAIL",jTxt_mail.getText());
           obj.put("PHONE",jTxt_phone.getText());
           obj.put("PHONE1",jTxt_phone1.getText());
           obj.put("EMAIL1",jTxt_mail1.getText());
           obj.put("ADDRESS1",jTxt_add1.getText());
           obj.put("ADDRESS2",jTxt_add2.getText());
           obj.put("ADDRESS3",jTxt_add3.getText());
            Date date= jXDatePicker1.getDate();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String DOB = formatter.format(date);
           obj.put("DOB",DOB);
           obj.put("BLOODGROUP",jTxt_Blood.getText());
           obj.put("STUDENTID",jTxt_Stuid.getText());
           obj.put("COLLEGEID",jTxt_CoId.getText());
           
           dbase.connect("DB","Student", obj);
           JOptionPane.showMessageDialog(rootPane,"Submited");
           
        }
        else{
           
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTxt_CoIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_CoIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_CoIdFocusLost

    private void jTxt_BloodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_BloodFocusLost
        // TODO add your handling code here:
        String blood = jTxt_Blood.getText();
        if(blood.matches("([ABO]|(AB))[+-]" )|| blood.isEmpty()){
            if(!blood.isEmpty()){
                jLabel17.setIcon(icojk);
                jLabel17.setText("Okay");
                jLabel17.setToolTipText(null);
            }
            else{
                jLabel17.setIcon(null);
                jLabel17.setText(null);
                jLabel17.setToolTipText(null);
            }

        }
        else{
            jLabel17.setText("Invalid");
            jLabel17.setIcon(icox);
            jLabel17.setToolTipText("Enter a Valid Blood Group.");
        }
    }//GEN-LAST:event_jTxt_BloodFocusLost

    private void jTxt_phone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_phone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_phone1ActionPerformed

    private void jTxt_phone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_phone1FocusLost
        // TODO add your handling code here:
        String phone = jTxt_phone.getText();
        String phone1 = jTxt_phone1.getText();
        if(phone1.matches("[0-9]{10}") || phone1.isEmpty() ){
            if(!phone1.isEmpty()){
                if(phone1.equals(phone)){
                    jLabel15.setIcon(icoq);
                    jLabel15.setText("invalid");
                    jLabel15.setToolTipText("Both Phone no.s are same");
                }
                else{
                    jLabel15.setIcon(icojk);
                    jLabel15.setText("Okay");
                    jLabel15.setToolTipText(null);
                }
            }
            else{
                jLabel15.setIcon(null);
                jLabel15.setText(null);
            }
        }
        else{
            jLabel15.setText("Invalid");
            jLabel15.setIcon(icox);
            jLabel15.setToolTipText("Enter a Valid Mobile no.");
        }
    }//GEN-LAST:event_jTxt_phone1FocusLost

    private void jTxt_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_add1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_add1ActionPerformed

    private void jTxt_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_add3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_add3ActionPerformed

    private void jTxt_mail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_mail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_mail1ActionPerformed

    private void jTxt_mail1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_mail1FocusLost
        // TODO add your handling code here:
        String email = jTxt_mail.getText();
        email = email.toLowerCase();
        String email1 = jTxt_mail1.getText();
        email1 = email1.toLowerCase();
        if((email1.matches("[a-z][a-z0-9_.]+[@][a-z0-9]+(([.]{1}[a-z]{2,})|([.]{1}[a-z]{2,}[.]{1}[a-z]{2,}))") || email1.isEmpty() )){
            if(!email1.isEmpty()){
                if(email1.equals(email)){
                    jLabel21.setText("Invalid");
                    jLabel21.setIcon(icoq);
                    jLabel21.setToolTipText("Both emails are same");
                }
                else{
                    jLabel21.setIcon(icojk);
                    jLabel21.setText("Okay");
                }
            }
            else{
                jLabel21.setIcon(null);
                jLabel21.setText(null);
            }
        }
        else{
            jLabel21.setText("Invalid");
            jLabel21.setIcon(icox);
            jLabel21.setToolTipText("Enter a Valid E-mail.");
        }
    }//GEN-LAST:event_jTxt_mail1FocusLost

    private void jTxt_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_mailActionPerformed

    private void jTxt_mailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_mailFocusLost
        // TODO add your handling code here:
        String email = jTxt_mail.getText();
        email = email.toLowerCase();
        if(email.matches("[a-z]([a-zA-Z0-9_.])+[@][a-z0-9]+(([.]{1}[a-z]{2,})|([.]{1}[a-z]{2,}[.]{1}[a-z]{2,}))" ) || email.isEmpty() ){
            if(!email.isEmpty()){
                jLabel16.setIcon(icojk);
                jLabel16.setText("Okay");
                jLabel16.setToolTipText(null);
            }
            else{

                jLabel16.setIcon(null);
                jLabel16.setText(null);
                jLabel16.setToolTipText(null);

            }
        }
        else{
            jLabel16.setText("Invalid");
            jLabel16.setIcon(icox);
            jLabel16.setToolTipText("Enter a Valid E-mail.");

        }

    }//GEN-LAST:event_jTxt_mailFocusLost

    private void jTxt_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_phoneActionPerformed

    private void jTxt_phoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_phoneFocusLost
        // TODO add your handling code here:
        String phone = jTxt_phone.getText();
        if(phone.matches("[0-9]{10}") || phone.isEmpty()){
            if(!phone.isEmpty()){
                jLabel14.setIcon(icojk);
                jLabel14.setText("Okay");
            }
            else{
                jLabel14.setIcon(null);
                jLabel14.setText(null);
            }
        }
        else{
            jLabel14.setText("Invalid");
            jLabel14.setIcon(icox);
            jLabel14.setToolTipText("Enter a Valid Mobile no.");
        }
    }//GEN-LAST:event_jTxt_phoneFocusLost

    private void jTxt_rollFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_rollFocusLost
        // TODO add your handling code here:
        String Rollno =  jTxt_roll.getText();
        if(Rollno.matches("[A-Z]{2,5}[0-9]{3,}") || Rollno.isEmpty()){
            if(!Rollno.isEmpty()){
                jLabel13.setIcon(icojk);
                jLabel13.setText("Okay");
            }
            else{
                jLabel13.setIcon(null);
                jLabel13.setText(null);
            }
        }
        else{
            jLabel13.setText("Invalid");
            jLabel13.setIcon(icox);
            jLabel13.setToolTipText("Roll is Invalid  Enter complete Roll no Example TEIT146");
        }
    }//GEN-LAST:event_jTxt_rollFocusLost

    private void jTxt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_nameActionPerformed

    private void jTxt_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_nameFocusLost
        // TODO add your handling code here:
        String name = jTxt_name.getText();
        if(name.matches("((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+)|((([A-Z][.])|[A-Z][a-z]+) [A-Z][a-z]+ [A-Z][a-z]+)") || name.isEmpty()){
            if(!name.isEmpty()){
                jLabel11.setIcon(icojk);
                jLabel11.setText("Okay");
            }
            else{
                jLabel11.setIcon(null);
                jLabel11.setText(null);
            }

        }
        else{
            jLabel11.setText("Invalid");
            jLabel11.setIcon(icox);
            jLabel11.setToolTipText("Name Should Start with upper case and contains space between first and last name");
        }
    }//GEN-LAST:event_jTxt_nameFocusLost

    private void jtxt_prnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxt_prnFocusLost
        // TODO add your handling code here:
        String PNR = jtxt_prn.getText();

        if((PNR.matches("[0-9]+[A-Z]{1}") || PNR.isEmpty()) ){
            if(!PNR.isEmpty()){
                jLabel12.setIcon(icojk);
                jLabel12.setText("Okay");
            }
            else{
                jLabel12.setIcon(null);
                jLabel12.setText(null);
            }
        }
        else{
            jLabel12.setText("Invalid");
            jLabel12.setIcon(icox);
            jLabel12.setToolTipText("PNR must be no.s ending with a character");
        }
    }//GEN-LAST:event_jtxt_prnFocusLost

    private void jTxt_StuidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxt_StuidFocusLost
        // TODO add your handling code here:
        String stuid = jTxt_Stuid.getText();
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
            jLabV_stuid.setToolTipText("Enter a Valid Studentid.");
        }
    }//GEN-LAST:event_jTxt_StuidFocusLost

    private void jXDatePicker1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jXDatePicker1FocusLost
        // TODO add your handling code here:
         
        Date date= jXDatePicker1.getDate();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String DOB = formatter.format(date);
        if(DOB.matches("(([012][0-9])|([(30)(31)]))-(([0][1-9])|([1][0-2]))-(19|20)[0-9]{2}")){
            jLabV_dob.setText("Okay");
            jLabV_dob.setIcon(icojk);    
        }
        else{
            JOptionPane.showMessageDialog(rootPane, DOB);
            jLabV_dob.setText("Invalid");
            jLabV_dob.setIcon(icox);
            jLabV_dob.setToolTipText("Enter a Valid DOB");
        
        }
    }//GEN-LAST:event_jXDatePicker1FocusLost

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void jXDatePicker1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jXDatePicker1FocusGained
        // TODO add your handling code here:
         Date date= jXDatePicker1.getDate();
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        String DOB = formatter.format(date);
        if(DOB.matches("(([012][0-9])|([(30)(31)]))-(([0][1-9])|([1][0-2]))-(19|20)[0-9]{2}")){
            jLabV_dob.setText("Okay");
            jLabV_dob.setIcon(icojk);    
        }
        else{
            JOptionPane.showMessageDialog(rootPane, DOB);
            jLabV_dob.setText("Invalid");
            jLabV_dob.setIcon(icox);
            jLabV_dob.setToolTipText("Enter a Valid DOB");
        
        }
    }//GEN-LAST:event_jXDatePicker1FocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Admin_home home= new Admin_home();
        this.setVisible(false);
        home.setNameof(Name);
        home.setVisible(true);
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
            java.util.logging.Logger.getLogger(Student_insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_insert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabV_dob;
    private javax.swing.JLabel jLabV_stuid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTxt_Blood;
    private javax.swing.JTextField jTxt_CoId;
    private javax.swing.JTextField jTxt_Stuid;
    private javax.swing.JTextField jTxt_add1;
    private javax.swing.JTextField jTxt_add2;
    private javax.swing.JTextField jTxt_add3;
    private javax.swing.JTextField jTxt_mail;
    private javax.swing.JTextField jTxt_mail1;
    private javax.swing.JTextField jTxt_name;
    private javax.swing.JTextField jTxt_phone;
    private javax.swing.JTextField jTxt_phone1;
    private javax.swing.JTextField jTxt_roll;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTextField jtxt_prn;
    // End of variables declaration//GEN-END:variables
}
