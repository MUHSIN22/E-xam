package adminpanels;


import adminpanels.QuestionUploadForm;
import e.xam.LoginForm;
import e.xam.OtpGenerator;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;


public class SubjectDetailsForm extends javax.swing.JFrame {
    Connection con;
    
    private String id;
    private int firstClick = 0;
    private String teacherId;
    private String subId;
    
    private String url = "jdbc:mysql://localhost/E-xam";
    private String user = "root";
    private String password = "password";
    
    private String examName,subName,subCode,teacherName,singleChoice;
    
    private boolean empty = false;
    
    public SubjectDetailsForm(String teacherId) {
        initComponents();
        this.teacherId = teacherId;
        cautionExamName.setVisible(false);
        cautionSubjectName.setVisible(false);
        cautionSubCode.setVisible(false);
        cautionSingleChoice.setVisible(false);
        connect();
        getTeacherDetails();
    }

    private SubjectDetailsForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void connect(){//Function implement connection to database in loginform
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void generateId(){
            OtpGenerator generateId = new OtpGenerator();
            id = generateId.generateOtp(8);
            System.out.println(id);
            idField.setText("E-xam//?:"+id);
            generateIdButton.setText("Done");
            firstClick = 1;
    }
    public void insertData(){
        
        String query = "INSERT INTO `subjectDetails` (`subId`, `examName`, `subName`, `subCode`, `teacherId`,`singleChoice`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, subId);
            ps.setString(2, examName);
            ps.setString(3 , subName);
            ps.setString(4, subCode);
            ps.setString(5, teacherId);
            ps.setInt(6,Integer.parseInt(singleChoice));
            int k = ps.executeUpdate();
            if(k == 1){
                System.out.println("succefully added");
            }else{
                System.out.println("Something trouble");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void fieldEmptyCheck(){
        examName = examNameField.getText();
        subName = subjectField.getText();
        subCode = subjectCodeField.getText();
        singleChoice = singleChoiceNumField.getText();
        if(examName.equals("")){
            cautionExamName.setVisible(true);
            empty = true;
        }else if(subName.equals("")){
            cautionSubjectName.setVisible(true);
            empty = true;
        }else if(subCode.equals("")){
            cautionSubCode.setVisible(true);
            empty = true;
        }else if(singleChoice.equalsIgnoreCase("")){
            cautionSingleChoice.setVisible(true);
            empty = true;
        }
        else{
            generateId();
            subId = idField.getText();
        }
    }
    public void getTeacherDetails(){
        String query = "SELECT * FROM teacherDetails WHERE phone = '"+teacherId+"'";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            rs.next();
            
            teacherName = rs.getString("firstname");
            
            System.out.println(teacherName);
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        teacherNameLabel.setText(teacherName);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        examNameField = new javax.swing.JTextField();
        subjectField = new javax.swing.JTextField();
        subjectCodeField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        generateIdButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        teacherNameLabel = new javax.swing.JLabel();
        cautionSubCode = new javax.swing.JLabel();
        cautionSubjectName = new javax.swing.JLabel();
        cautionExamName = new javax.swing.JLabel();
        singleChoiceNumField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cautionSingleChoice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 200, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        idField.setText("Your E-xam  ID will generate here");
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("Please note the ID for share with students:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Name of Examination");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Subject");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Subject code");

        generateIdButton.setBackground(java.awt.Color.blue);
        generateIdButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        generateIdButton.setForeground(new java.awt.Color(255, 255, 255));
        generateIdButton.setText("Generate ID");
        generateIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateIdButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setText("Examination Details");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Conducted by:");

        teacherNameLabel.setText("Admin Name");

        cautionSubCode.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        cautionSubCode.setForeground(java.awt.Color.red);
        cautionSubCode.setText("Please fill this field!! ");

        cautionSubjectName.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        cautionSubjectName.setForeground(java.awt.Color.red);
        cautionSubjectName.setText("Please fill this field!! ");

        cautionExamName.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        cautionExamName.setForeground(java.awt.Color.red);
        cautionExamName.setText("Please fill this field!! ");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("Number single choice questions");

        cautionSingleChoice.setFont(new java.awt.Font("Ubuntu", 2, 14)); // NOI18N
        cautionSingleChoice.setForeground(java.awt.Color.red);
        cautionSingleChoice.setText("Please fill this field!! ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(singleChoiceNumField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(subjectField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(cautionSubjectName))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subjectCodeField)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cautionSubCode)
                                            .addComponent(jLabel4)
                                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(501, 501, 501)
                                        .addComponent(generateIdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addComponent(examNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cautionExamName)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(teacherNameLabel))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(99, 99, 99)
                                        .addComponent(jLabel1))
                                    .addComponent(cautionSingleChoice))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(teacherNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(examNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(cautionExamName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cautionSubCode)
                    .addComponent(cautionSubjectName))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(singleChoiceNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(cautionSingleChoice)
                .addGap(36, 36, 36)
                .addComponent(generateIdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
      
    }//GEN-LAST:event_idFieldActionPerformed

    private void generateIdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateIdButtonActionPerformed
        if(firstClick == 0){
            cautionExamName.setVisible(false);
            cautionSubjectName.setVisible(false);
            cautionSubCode.setVisible(false);
            fieldEmptyCheck();
            
            if(empty){
                JOptionPane.showMessageDialog(this, "All fields are mantidatory\nPlease fill all field!1");
                empty = false;
                
            }else{
                insertData();
            }
        }else{
            try {
                new QuestionUploadForm(subId,teacherId).setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(SubjectDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_generateIdButtonActionPerformed

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectDetailsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cautionExamName;
    private javax.swing.JLabel cautionSingleChoice;
    private javax.swing.JLabel cautionSubCode;
    private javax.swing.JLabel cautionSubjectName;
    private javax.swing.JTextField examNameField;
    private javax.swing.JButton generateIdButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField singleChoiceNumField;
    private javax.swing.JTextField subjectCodeField;
    private javax.swing.JTextField subjectField;
    private javax.swing.JLabel teacherNameLabel;
    // End of variables declaration//GEN-END:variables
}
