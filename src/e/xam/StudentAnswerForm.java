package e.xam;

import com.mysql.cj.conf.PropertyKey;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;

public final class StudentAnswerForm extends javax.swing.JFrame {
     
    Connection con;
    ButtonGroup group = new ButtonGroup();
     
    
    int maxQuestionId;//
    int questionId = 1 ;//for select questions and display questions
    String questionIn,optionOneIn,optionTwoIn,optionThreeIn,optionFourIn;
    int correctAnswer;
    int radioAction = 0;
    int nonAttempted[] = new int[maxQuestionId];//for count non attempted question
    int score = 0;
    int nonAttemptedArray[] = new int[50];
    int i = 0; //for array position
    public StudentAnswerForm() {
        initComponents();
        connect();
        lastQuestionId();
        selectAndShow();
    }
    public void connect(){ //Function for connection of database
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/E-xam","root","newpassword");
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
            ResultSet rs = st.executeQuery("SELECT MAX(questionId) FROM questions");
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
            String query = "SELECT * FROM questions WHERE questionId = "+questionId+""; 
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
       if(questionId <= maxQuestionId){
           selectQuestions();
           showQuestions();
       }else{
           dispose();
       }
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(561, 561, 561))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(question)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionIdLablel))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(questionIdLablel))
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
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
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
            
            if(radioAction == correctAnswer){
                score++;
            }
            
        }else {
            nonAttemptedArray[i] = questionId - 1 ;
            i++;
            System.out.println("i="+i);
            
        }
        System.out.println("radioAction="+radioAction+"correctAnswer"+correctAnswer);
        group.clearSelection();
        radioAction = 0;
        selectAndShow();
        System.out.println("Score = "+score+"\nNon Attempted = "+ Arrays.toString(nonAttemptedArray)+"len="+nonAttempted.length);
        
    }//GEN-LAST:event_nextButtonActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentAnswerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton nextButton;
    private javax.swing.JRadioButton optionFour;
    private javax.swing.JRadioButton optionOne;
    private javax.swing.JRadioButton optionThree;
    private javax.swing.JRadioButton optionTwo;
    private javax.swing.JLabel question;
    private javax.swing.JLabel questionIdLablel;
    // End of variables declaration//GEN-END:variables
}
