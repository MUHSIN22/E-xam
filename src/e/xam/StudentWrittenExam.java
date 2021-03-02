package e.xam;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;


public class StudentWrittenExam extends javax.swing.JFrame {
    
    Connection con;
    
    String url = "jdbc:mysql://localhost/E-xam";
    String user = "root";
    String password = "newpassword";
    
    int questionId = 1;
    
    private int nonAttempted = 0,Attempted = 0;
    
    String subId ,mobileNumber;
    private String questions;
    private int mark;
    private String examName,subName,subCode;
    private int teacherId,maxQuesitonId;
   
    public StudentWrittenExam(String mobile,String subId) {
        this.mobileNumber = mobile;
        this.subId = subId;
        initComponents();
        connect();
        getAndSetExamDetails();
        selectAndShowQuestions();
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
    public void getAndSetQuestions(){
        String query = "SELECT * FROM `writtenQuestions` WHERE subId = '"+subId+"' AND questionId = '"+questionId+"'";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            rs.next();
            questions = rs.getString("question");
            mark = rs.getInt("mark");
            questionLabel.setText(questions);
            markLabel.setText(String.valueOf(mark));
            questionNumLabel.setText(String.valueOf(questionId));
            questionId++;
            
            totalLabel.setText(String.valueOf(maxQuesitonId));
            nonAttemptedLabel.setText(String.valueOf(nonAttempted));
            attemptedLabel.setText(String.valueOf(Attempted));
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentWrittenExam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void getAndSetExamDetails(){
        String query = "SELECT * FROM `subjectDetails` WHERE subId = '"+subId+"'";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            rs.next();
            
            examName = rs.getString("examName");
            subName = rs.getString("subName");
            subCode = rs.getString("subCode");
            teacherId = rs.getInt("teacherId");
            maxQuesitonId = rs.getInt("multipleChoice");
            
            examNameLabel.setText(examName);
            subNameLabel.setText(subName);
            subCodeLabel.setText(subCode);
        } catch (SQLException ex) {
            Logger.getLogger(StudentWrittenExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void checkAttempted(){
        String answer = answerField.getText();
        if(answer.equals("")){
            nonAttempted++;
            nonAttemptedLabel.setText(String.valueOf(nonAttempted));
        }else{
            Attempted++;
            attemptedLabel.setText(String.valueOf(Attempted));
        }
    }
    public void selectAndShowQuestions(){
        if(questionId  < maxQuesitonId){
            getAndSetQuestions();
        }else if(questionId == maxQuesitonId){
            getAndSetQuestions();
            nextButton.setText("Finish");
        }else{
            JOptionPane.showMessageDialog(this, "You are successfully completed exam!!");
            dispose();
        }
    }
    public void uploadAnswer(){
        String answer = answerField.getText();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO `StudentWrittenAnswer` (`siNo`, `questionId`, `answer`, `mark`, `subId`, `mobileNumber`) VALUES (NULL, ?, ?,?, ?, ?)");
            ps.setInt(1, questionId -1);
            ps.setString(2, answer);
            ps.setInt(3, mark);
            ps.setString(4, subId);
            ps.setString(5, mobileNumber);
            int k = ps.executeUpdate();
                
            if(k == 1){
                System.out.println("Successfully added");
                answerField.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Something went wrong \nPlease try again!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentWrittenExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        examNameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        subNameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        questionNumLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        answerField = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        subCodeLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        markLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        attemptedLabel = new javax.swing.JLabel();
        nonAttemptedLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 275, 0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        examNameLabel.setFont(new java.awt.Font("Ubuntu", 1, 30)); // NOI18N
        examNameLabel.setText("Exam Name");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Subject:");

        subNameLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        subNameLabel.setText("DCP");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Question Number:");

        questionNumLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        questionNumLabel.setText("1");

        questionLabel.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        questionLabel.setText("who is father of nation");

        answerField.setColumns(20);
        answerField.setRows(5);
        jScrollPane1.setViewportView(answerField);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Write your answer here:");

        nextButton.setBackground(java.awt.Color.blue);
        nextButton.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("Subject Code:");

        subCodeLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        subCodeLabel.setText("jLabel8");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Mark of the question:");

        markLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        markLabel.setText("6");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(40, 176, 40));
        jLabel5.setText("Attempted:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(java.awt.Color.red);
        jLabel8.setText("Non Attempted:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setForeground(java.awt.Color.black);
        jLabel9.setText("Total Question:");

        attemptedLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        attemptedLabel.setForeground(new java.awt.Color(40, 176, 40));
        attemptedLabel.setText("1");

        nonAttemptedLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nonAttemptedLabel.setForeground(java.awt.Color.red);
        nonAttemptedLabel.setText("2");

        totalLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        totalLabel.setForeground(java.awt.Color.black);
        totalLabel.setText("3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(attemptedLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nonAttemptedLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(questionLabel)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(subNameLabel)
                            .addGap(237, 237, 237)
                            .addComponent(jLabel1))
                        .addComponent(examNameLabel)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(questionNumLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subCodeLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(markLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(examNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(subNameLabel)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(questionNumLabel)
                    .addComponent(jLabel7)
                    .addComponent(subCodeLabel))
                .addGap(33, 33, 33)
                .addComponent(questionLabel)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(markLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(attemptedLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(nonAttemptedLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(totalLabel))))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        checkAttempted();
        uploadAnswer();
        selectAndShowQuestions();
    }//GEN-LAST:event_nextButtonActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentWrittenExam(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea answerField;
    private javax.swing.JLabel attemptedLabel;
    private javax.swing.JLabel examNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel markLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel nonAttemptedLabel;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumLabel;
    private javax.swing.JLabel subCodeLabel;
    private javax.swing.JLabel subNameLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
