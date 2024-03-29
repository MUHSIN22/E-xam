/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpanels;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import javax.swing.JOptionPane;

//nothing
public class SignupPageForAdmin extends javax.swing.JFrame {
    String OTP;
    public SignupPageForAdmin() {
        initComponents();
        connect ();
    }
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pst= null;
    
    public void connect(){
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con= DriverManager.getConnection("jdbc:mysql://localhost/E-xam","root","password");
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(SignupPageForAdmin.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(SignupPageForAdmin.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
     public static boolean isPhoneValid(String phone) {
            String regex = "\\d{10}";
            //Creating a pattern object
            Pattern pattern = Pattern.compile(regex);
            //Creating a Matcher object
            Matcher matcher = pattern.matcher(phone);
            return matcher.matches();
     }
    
    
    
     public boolean isEmailAlreadyExist(){
           
           String email=EmailFieldAdmin.getText(); 
           String query = "SELECT * FROM teacherDetails WHERE email = '"+email+"'";
           
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next()){
               return true;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(SignupPageForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return false;
     }
     
     
      public boolean isPhoneAlreadyExist(){
           
           String phone=mobiletxtfield.getText();
           String query = "SELECT * FROM teacherDetails WHERE phone = '"+phone+"'";
           
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            if(rs.next()){
               return true;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(SignupPageForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return false;
     }
     
    
    public static boolean isEmailValid(String email) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        signUpButtonAdmin = new javax.swing.JButton();
        FirstNameFieldAdmin = new javax.swing.JTextField();
        LogInButtonAdmin = new javax.swing.JButton();
        LastNameFieldAdmin = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        mobiletxtfield = new javax.swing.JTextField();
        otptxtfield = new javax.swing.JTextField();
        sendotpbtn = new javax.swing.JButton();
        verifyotpbtn = new javax.swing.JButton();
        EmailFieldAdmin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 61, 89));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("E-XAM");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(254, 254, 254));
        jLabel13.setText("ADMIN PANEL");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("– Benjamin Franklin");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Involve me and I learn.\"");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Teach me and I remember.");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("\"Tell me and I forget.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)))
                            .addComponent(jLabel8))))
                .addGap(116, 116, 116))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(38, 38, 38)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 61, 89));
        jLabel5.setText("Create Your Account");

        jLabel7.setForeground(new java.awt.Color(63, 64, 66));
        jLabel7.setText("First name");

        jLabel12.setForeground(new java.awt.Color(63, 64, 66));
        jLabel12.setText(" Lastname");

        jLabel14.setForeground(new java.awt.Color(63, 64, 66));
        jLabel14.setText("mobile no.");

        jLabel15.setForeground(new java.awt.Color(63, 64, 66));
        jLabel15.setText("OTP");

        jLabel16.setForeground(new java.awt.Color(63, 64, 66));
        jLabel16.setText("Email");

        signUpButtonAdmin.setBackground(new java.awt.Color(30, 61, 89));
        signUpButtonAdmin.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        signUpButtonAdmin.setForeground(new java.awt.Color(254, 254, 254));
        signUpButtonAdmin.setText("Sign Up");
        signUpButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonAdminActionPerformed(evt);
            }
        });

        FirstNameFieldAdmin.setBackground(new java.awt.Color(254, 254, 254));
        FirstNameFieldAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        FirstNameFieldAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstFirstNameFieldAdminActionPerformed(evt);
            }
        });

        LogInButtonAdmin.setBackground(new java.awt.Color(30, 61, 89));
        LogInButtonAdmin.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        LogInButtonAdmin.setForeground(new java.awt.Color(254, 254, 254));
        LogInButtonAdmin.setText("Log In");
        LogInButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonAdminActionPerformed(evt);
            }
        });

        LastNameFieldAdmin.setBackground(new java.awt.Color(254, 254, 254));
        LastNameFieldAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        LastNameFieldAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameFieldAdminActionPerformed(evt);
            }
        });

        jLabel17.setText("or");

        mobiletxtfield.setBackground(new java.awt.Color(254, 254, 254));
        mobiletxtfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        mobiletxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstmobiletxtfieldActionPerformed(evt);
            }
        });

        otptxtfield.setBackground(new java.awt.Color(254, 254, 254));
        otptxtfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        otptxtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstotptxtfieldActionPerformed(evt);
            }
        });

        sendotpbtn.setBackground(new java.awt.Color(30, 61, 89));
        sendotpbtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        sendotpbtn.setForeground(new java.awt.Color(254, 254, 254));
        sendotpbtn.setText("send otp");
        sendotpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendotpbtnActionPerformed(evt);
            }
        });

        verifyotpbtn.setBackground(new java.awt.Color(30, 61, 89));
        verifyotpbtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        verifyotpbtn.setForeground(new java.awt.Color(254, 254, 254));
        verifyotpbtn.setText("verify");
        verifyotpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyotpbtnActionPerformed(evt);
            }
        });

        EmailFieldAdmin.setBackground(new java.awt.Color(254, 254, 254));
        EmailFieldAdmin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        EmailFieldAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(sendotpbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(verifyotpbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signUpButtonAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogInButtonAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(61, 61, 61))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(EmailFieldAdmin)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(FirstNameFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(mobiletxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastNameFieldAdmin)
                            .addComponent(otptxtfield)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addGap(0, 209, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastNameFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobiletxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(otptxtfield, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendotpbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifyotpbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(signUpButtonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogInButtonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FirstFirstNameFieldAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstFirstNameFieldAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstFirstNameFieldAdminActionPerformed

    private void signUpButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonAdminActionPerformed
     try {
        
         String OTPCheck = otptxtfield.getText();
         String firstname=FirstNameFieldAdmin.getText();
         String lastname=LastNameFieldAdmin.getText();
         String email=EmailFieldAdmin.getText();
         String phone=mobiletxtfield.getText();
         
         
    if(OTPCheck.equals(OTP)){
         boolean ap =isEmailValid(email);
         if(ap==false){
             JOptionPane.showMessageDialog(this, "enter the valied email");
             EmailFieldAdmin.setText("");
             
         } else{ 
         
            pst =con.prepareStatement("INSERT INTO teacherDetails VALUES(?,?,?,?)");
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setString(3, email);
            pst.setString(4, phone);

            int k= pst.executeUpdate();
               
            if (k==1){
                JOptionPane.showMessageDialog(this,"record added successfully");
                FirstNameFieldAdmin.requestFocus();
                new AdminDashboard().setVisible(true);

            }else{
                JOptionPane.showMessageDialog(this,"record added failed");
            }
         }
    }
    else{
         JOptionPane.showMessageDialog(this, "entered OTP is incorrect");
        }
         
     } catch (SQLException ex) {
         Logger.getLogger(SignupPageForAdmin.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_signUpButtonAdminActionPerformed

    private void LastNameFieldAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameFieldAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameFieldAdminActionPerformed

    private void LogInButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonAdminActionPerformed
      new LoginPageForAdmin().setVisible(true);

        this.dispose();
    }//GEN-LAST:event_LogInButtonAdminActionPerformed

    private void FirstmobiletxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstmobiletxtfieldActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_FirstmobiletxtfieldActionPerformed

    private void FirstotptxtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstotptxtfieldActionPerformed
        // TODO add your handling code here:
        System.out.println(mobiletxtfield.getText());
    }//GEN-LAST:event_FirstotptxtfieldActionPerformed

    private void sendotpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendotpbtnActionPerformed
                boolean isEmailAlreadyExist= isEmailAlreadyExist();
                boolean isPhoneAlreadyExist= isPhoneAlreadyExist();
                
                String phone=mobiletxtfield.getText();
                boolean pv=isPhoneValid(phone);
                
                if(isEmailAlreadyExist || isPhoneAlreadyExist){
                
                    JOptionPane.showMessageDialog(this, "The email or Phone number is already exist");
                    mobiletxtfield.setText("");
                    EmailFieldAdmin.setText("");
                    
                    
                }else{
                    
                    if(pv==false){

                        JOptionPane.showMessageDialog(this, "please enter valied phone number");
                        mobiletxtfield.setText(""); 
                        
                    
                    }else{
        
                        OtpGenerator otpGenerator = new OtpGenerator();

                        OTP = otpGenerator.generateOtp(6);//Generate OTP of length 6

                        System.out.println("OTP="+OTP);
                    
                    }
                    
                    
                    
                }
                
                
    }//GEN-LAST:event_sendotpbtnActionPerformed

    private void verifyotpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyotpbtnActionPerformed
//        String OTPCheck = otptxtfield.getText();
//        if(OTPCheck.equals(OTP)){
//            JOptionPane.showMessageDialog(this, "Otp verified Successfully");
//            
//        }else{
//            JOptionPane.showMessageDialog(this, "Please enter valid OTP!");
//            otptxtfield.setText("");
//        }

        try {
        
         String OTPCheck = otptxtfield.getText();
         String firstname=FirstNameFieldAdmin.getText();
         String lastname=LastNameFieldAdmin.getText();
         String email=EmailFieldAdmin.getText();
         String phone=mobiletxtfield.getText();
         
         
    if(OTPCheck.equals(OTP)){
         boolean ap =isEmailValid(email);
         if(ap==false){
             JOptionPane.showMessageDialog(this, "enter the valied email");
             EmailFieldAdmin.setText("");
             
         } else{ 
         
            pst =con.prepareStatement("INSERT INTO teacherDetails VALUES(?,?,?,?)");
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setString(3, email);
            pst.setString(4, phone);

            int k= pst.executeUpdate();
               
            if (k==1){
                JOptionPane.showMessageDialog(this,"The OTP verification successfully finished \n record added successfully");
                FirstNameFieldAdmin.requestFocus();
                new AdminDashboard().setVisible(true);

            }else{
                JOptionPane.showMessageDialog(this,"record added failed");
            }
         }
    }
    else{
         JOptionPane.showMessageDialog(this, "entered OTP is incorrect");
        }
         
     } catch (SQLException ex) {
         Logger.getLogger(SignupPageForAdmin.class.getName()).log(Level.SEVERE, null, ex);
     }
    

    }//GEN-LAST:event_verifyotpbtnActionPerformed

    private void EmailFieldAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFieldAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFieldAdminActionPerformed

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
            java.util.logging.Logger.getLogger(SignupPageForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPageForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPageForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPageForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPageForAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailFieldAdmin;
    private javax.swing.JTextField FirstNameFieldAdmin;
    private javax.swing.JTextField LastNameFieldAdmin;
    private javax.swing.JButton LogInButtonAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField mobiletxtfield;
    private javax.swing.JTextField otptxtfield;
    private javax.swing.JButton sendotpbtn;
    private javax.swing.JButton signUpButtonAdmin;
    private javax.swing.JButton verifyotpbtn;
    // End of variables declaration//GEN-END:variables
}
