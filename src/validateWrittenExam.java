
import e.xam.LoginForm;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;

public class validateWrittenExam extends javax.swing.JFrame {
    Connection con;
    String mobile;
    String subId;
    
    String url = "jdbc:mysql://localhost/E-xam";
    String user = "root";
    String password = "newpassword";
    
    int questionId = 0 ,mark,maxQuestion;
    String answer,question;
    private String studentName;
    
    
    public validateWrittenExam(String subId,String mobile) {
        this.subId = subId;
        this.mobile = mobile;
        initComponents();
        connect();
        cautionMark.setVisible(false);
        getMaxQuestionId();
        getAnswerDetails();
        getQuestion();
        getStudentDetails();
        
    }
    private void connect(){//Function implement connection to database in loginform
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getAnswerDetails(){
        questionId++;
        
        String query = "SELECT * FROM `StudentWrittenAnswer` WHERE mobileNumber = '"+mobile+"' AND subId = '"+subId+"' AND questionId = '"+questionId+"'";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            rs.next();
            answer = rs.getString("answer");
            mark = rs.getInt("mark");
            
            answerLabel.setText(answer);
            markLabel.setText(String.valueOf(mark));
            questionNumLabel.setText(String.valueOf(questionId));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(validateWrittenExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getQuestion(){
        String query = "SELECT * FROM `writtenQuestions` WHERE subId = '"+subId+"' AND questionId = '"+questionId+"'";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            rs.next();
            question = rs.getString("question");
            
            questionLabel.setText(question);
            
        } catch (SQLException ex) {
            Logger.getLogger(validateWrittenExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getStudentDetails(){
        String query = "SELECT * FROM `studentDetails` WHERE mobile = '"+mobile+"'";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            rs.next();
            studentName = rs.getString("name");
            int rollNo = rs.getInt("rollno");
            
            studentNameLabel.setText(studentName);
            studentRollNumLabel.setText(String.valueOf(rollNo));
        } catch (SQLException ex) {
            Logger.getLogger(validateWrittenExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setMarkAndValidated(){
        String markAttain = markField.getText();
        int markGet = Integer.parseInt(markAttain);
        String query = "UPDATE `StudentWrittenAnswer` SET `markAttain`= '"+markAttain+"',`Validated`= '"+1+"' WHERE mobileNumber = '"+mobile+"' AND subId = '"+subId+"' AND questionId = '"+questionId+"'";
        if(markAttain.equals("")){
            cautionMark.setVisible(true);
        }else{
            cautionMark.setVisible(false);
            if(markGet>mark){
                cautionMark.setText("Mark should be less than of "+mark);
                cautionMark.setVisible(true);
            }else{
                try {
                PreparedStatement ps = con.prepareStatement(query);
                int k = ps.executeUpdate();
                if(k == 1){
                    markField.setText("");
                    System.out.println("Added to database");
                    if(questionId == maxQuestion -1){
                        nextButton.setText("Finish");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Something went wrong please try again!!");
                }
                } catch (SQLException ex) {
                Logger.getLogger(validateWrittenExam.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        }
        
    }
    public void getMaxQuestionId(){
        String query = "SELECT MAX(questionId) FROM `writtenQuestions` WHERE subId = '"+subId+"'";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            rs.next();
            maxQuestion = rs.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(validateWrittenExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void checkAndSet(){
        if(questionId < maxQuestion){
            setMarkAndValidated();
            getAnswerDetails();
            getQuestion();
        }else if(questionId == maxQuestion){
            setMarkAndValidated();
            JOptionPane.showMessageDialog(this, "You are successfully added marks of "+studentName);
            dispose();
            new AttendedStudentList(subId).setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        questionNumLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        studentNameLabel = new javax.swing.JLabel();
        studentRollNumLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        answerLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        markField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        markLabel = new javax.swing.JLabel();
        cautionMark = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 300, 0, 0));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Validate written exam");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Question Number:");

        questionNumLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        questionNumLabel.setText("1");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Student Name:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Student Roll no:");

        studentNameLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        studentNameLabel.setText("Manshad");

        studentRollNumLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        studentRollNumLabel.setText("22");

        questionLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        questionLabel.setText("what is that?");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("Answer:");

        answerLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        answerLabel.setText("jLabel6");

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Mark out of ");

        markLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        markLabel.setForeground(java.awt.Color.red);
        markLabel.setText("80");

        cautionMark.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        cautionMark.setForeground(java.awt.Color.red);
        cautionMark.setText("Please give the mark even its zero");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(markLabel))
                    .addComponent(answerLabel)
                    .addComponent(jLabel5)
                    .addComponent(questionLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(questionNumLabel)
                                .addGap(409, 409, 409))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(markField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nextButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(studentNameLabel))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(studentRollNumLabel))))))
                .addGap(67, 67, 67))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cautionMark)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(studentNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(questionNumLabel)
                    .addComponent(jLabel4)
                    .addComponent(studentRollNumLabel))
                .addGap(54, 54, 54)
                .addComponent(questionLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(answerLabel)
                .addGap(109, 109, 109)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(markLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(markField)
                    .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cautionMark)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        checkAndSet();
        
    }//GEN-LAST:event_nextButtonActionPerformed

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel answerLabel;
    private javax.swing.JLabel cautionMark;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField markField;
    private javax.swing.JLabel markLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumLabel;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JLabel studentRollNumLabel;
    // End of variables declaration//GEN-END:variables
}
