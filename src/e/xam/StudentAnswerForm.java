package e.xam;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public final class StudentAnswerForm extends javax.swing.JFrame {
     
    Connection con;
    ButtonGroup group = new ButtonGroup();

    
     
    
    private int maxQuestionId;//
    private int questionId = 1 ;//for select questions and display questions
    private String questionIn,optionOneIn,optionTwoIn,optionThreeIn,optionFourIn;
    private int correctAnswer;//for compare student answer with correct answer
    private int radioAction = 0;
    private int score = 0;
    private int nonAttemptedArray[] = new int[50];//for count non attempted question
    private int i = 0; //for array position
    private String mobile,examId;
    private int Attempted = 0 , nonAttempted = 0;
    
    private String name;//for get student name from database
    private int rollNo;//for get student roll number from database
    
    private String examName,subName,subCode;
    private String teacherId;
    
    public StudentAnswerForm(String mobile,String examId) {
        this.mobile = mobile;
        this.examId = examId;
        initComponents();
        connect();
        lastQuestionId();
        selectAndShow();
        getStudentDetails();
        getSubjectDetails();
        showSubjectDetials();
        totalQuestionsLabel.setText(String.valueOf(maxQuestionId));
        attemptedAndNonAttempted();
        
        }

    private StudentAnswerForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void connect(){ //Function for connection of database
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/E-xam","root","password");
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
   }
   public void lastQuestionId(){//select totalnumber of questions have
      
       Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(questionId) FROM questions where subId = '"+examId+"'");
            rs.next();
            maxQuestionId = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(StudentAnswerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void  selectQuestions(){
       Statement st = null;
       
        try {
            st = con.createStatement();
            String query = "SELECT * FROM questions WHERE questionId = "+questionId+" AND subId LIKE '"+examId+"'"; 
            ResultSet rs = st.executeQuery(query);
            System.err.println(query);
            rs.next();
            questionIn = rs.getString("question");
            optionOneIn = rs.getString("optionOne");
            optionTwoIn = rs.getString("optionTwo");
            optionThreeIn = rs.getString("optionThree");
            optionFourIn = rs.getString("optionFour");
            correctAnswer = rs.getInt("correctAnswer");
            rs.close();
            questionId++;
        } catch (SQLException ex) {
            Logger.getLogger(StudentAnswerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void showQuestions(){
       questionIdLablel.setText(String.valueOf(questionId-1));
       question.setText(questionIn);
       optionOne.setText(optionOneIn);
       optionTwo.setText(optionTwoIn);
       optionThree.setText(optionThreeIn);
       optionFour.setText(optionFourIn);
   }
   public void selectAndShow(){
       if(questionId < maxQuestionId){
           System.out.println(questionId +" max"+maxQuestionId);
           selectQuestions();
           showQuestions();
       }else if(questionId == maxQuestionId){
           nextButton.setText("Finish");
           selectQuestions();
           showQuestions();
       }else{
           JOptionPane.showMessageDialog(this, "You are finished the exam");
           setStudentMark();
           dispose();
       }
   }
   public void getStudentDetails(){//get deatials of attempted student from database
        try {
            String query = "SELECT * FROM studentDetails WHERE mobile = '"+mobile+"'";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            rs.next();
            name = rs.getString("name");
            rollNo = rs.getInt("rollno");
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentAnswerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void setStudentMark(){
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO `studentScores` (`sino`, `score`, `studentMobile`, `examId`) VALUES (NULL, ?, ? , ?)");
            
            ps.setInt(1, score);
            ps.setString(2, mobile);
            ps.setString(3, examId);
            int k = ps.executeUpdate();
            if(k == 1){
                System.out.println("Added to database ");
            }else{
                System.out.println("not added");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentAnswerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void getSubjectDetails(){
       String query = "SELECT * FROM subjectDetails where subId = '"+examId+"'";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            rs.next();
            
            examName = rs.getString("examName");
            subName = rs.getString("subName");
            subCode = rs.getString("subCode");
            teacherId = rs.getString("teacherId");
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentAnswerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void showSubjectDetials(){
       examNameLabel.setText(examName);
       subNameLabel.setText(subName);
       subCodeLabel.setText(subCode);
   }
   public void attemptedAndNonAttempted(){
       attemptedLabel.setText(String.valueOf(Attempted));
       nonAttemptedLabel.setText(String.valueOf(nonAttempted));
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        questionIdLablel = new javax.swing.JLabel();
        question = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        optionOne = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        optionTwo = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        optionFour = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        optionThree = new javax.swing.JRadioButton();
        nextButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        attemptedLabel = new javax.swing.JLabel();
        nonAttemptedLabel = new javax.swing.JLabel();
        totalQuestionsLabel = new javax.swing.JLabel();
        examNameLabel = new javax.swing.JLabel();
        subNameLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        subCodeLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
	
	group.add(optionOne);
	group.add(optionTwo);
	group.add(optionThree);
	group.add(optionFour);
	
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.white);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Question ID:");

        questionIdLablel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        questionIdLablel.setText("1");

        question.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        question.setText("adsfa sdfa fsdas");

        optionOne.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionOne.setText("option 1");
        optionOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionOneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optionOne)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(optionOne)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        optionTwo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionTwo.setText("option 1");
        optionTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionTwoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optionTwo)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(optionTwo)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        optionFour.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionFour.setText("option 1");
        optionFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionFourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optionFour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(optionFour)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        optionThree.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionThree.setText("option 1");
        optionThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionThreeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optionThree)
                .addContainerGap(268, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(optionThree)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        nextButton.setBackground(java.awt.Color.blue);
        nextButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        nextButton.setForeground(new java.awt.Color(254, 254, 254));
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 157, 0));
        jLabel3.setText("Attempted :");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(java.awt.Color.red);
        jLabel4.setText("Non-Attempted :");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setText("Total Questions :");

        attemptedLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        attemptedLabel.setForeground(new java.awt.Color(17, 173, 17));
        attemptedLabel.setText("jLabel6");

        nonAttemptedLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nonAttemptedLabel.setForeground(java.awt.Color.red);
        nonAttemptedLabel.setText("jLabel6");

        totalQuestionsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        totalQuestionsLabel.setForeground(java.awt.Color.black);
        totalQuestionsLabel.setText("jLabel6");

        examNameLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        examNameLabel.setText("Exam Name");

        subNameLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        subNameLabel.setText("sub Name");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setText("Subcode:");

        subCodeLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        subCodeLabel.setText("3033");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("Subject:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(561, 561, 561))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(question)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(attemptedLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nonAttemptedLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(totalQuestionsLabel)))
                                    .addGap(515, 515, 515)
                                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(24, 24, 24)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionIdLablel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subCodeLabel)
                        .addGap(87, 87, 87))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subNameLabel))
                            .addComponent(examNameLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(examNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subNameLabel)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(questionIdLablel)
                    .addComponent(jLabel8)
                    .addComponent(subCodeLabel))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(question)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(attemptedLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nonAttemptedLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(totalQuestionsLabel))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optionThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionThreeActionPerformed
        radioAction = 3;
    }//GEN-LAST:event_optionThreeActionPerformed

    private void optionTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionTwoActionPerformed
        radioAction = 2;
    }//GEN-LAST:event_optionTwoActionPerformed

    private void optionFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionFourActionPerformed
        radioAction = 4;
    }//GEN-LAST:event_optionFourActionPerformed

    private void optionOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionOneActionPerformed
        radioAction = 1;
    }//GEN-LAST:event_optionOneActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if(radioAction > 0){
            Attempted++;
            if(radioAction == correctAnswer){
                score++;
            }
            
        }else {
            nonAttempted++;
            nonAttemptedArray[i] = questionId - 1 ;
            i++;
            System.out.println("i="+i);
            
        }
       
        System.out.println("radioAction="+radioAction+"correctAnswer"+correctAnswer);
        group.clearSelection();
        radioAction = 0;
        selectAndShow();
        attemptedAndNonAttempted();
        System.out.println("Score = "+score+"\nNon Attempted = "+ Arrays.toString(nonAttemptedArray)+"len="+nonAttemptedArray.length);
        
    }//GEN-LAST:event_nextButtonActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentAnswerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attemptedLabel;
    private javax.swing.JLabel examNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel nonAttemptedLabel;
    private javax.swing.JRadioButton optionFour;
    private javax.swing.JRadioButton optionOne;
    private javax.swing.JRadioButton optionThree;
    private javax.swing.JRadioButton optionTwo;
    private javax.swing.JLabel question;
    private javax.swing.JLabel questionIdLablel;
    private javax.swing.JLabel subCodeLabel;
    private javax.swing.JLabel subNameLabel;
    private javax.swing.JLabel totalQuestionsLabel;
    // End of variables declaration//GEN-END:variables
}
