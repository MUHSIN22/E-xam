import e.xam.LoginForm;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")

public class uploadWrittenQuestions extends javax.swing.JFrame {
    Connection con;
    
    String subId;
    
    String url = "jdbc:mysql://localhost/E-xam";
    String user = "root";
    String password = "newpassword";
    
    private int questionNum = 0;
    private int maxQuestionId;
    
    public uploadWrittenQuestions(String subId) {
        this.subId = subId;
        initComponents();
        cautionMark.setVisible(false);
        cautionQuestion.setVisible(false);
        connect();
        questionId();
        maxQuestion();
        System.out.println(maxQuestionId);
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
    private void questionId(){
        String query = "SELECT MAX(questionId) FROM `writtenQuestions` WHERE subId = '"+subId+"'";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            rs.next();
            
            questionNum = rs.getInt(1) + 1;
            
            questionIdLabel.setText(String.valueOf(questionNum));
            
        } catch (SQLException ex) {
            Logger.getLogger(uploadWrittenQuestions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void uploadQuestions(){
        String question = questionField.getText();
        String mark = markField.getText();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO `writtenQuestions` (`siNo`, `questionId`, `question`, `mark`, `subId`) VALUES (NULL,?, ?, ?, ?)");
            ps.setInt(1, questionNum);
            ps.setString(2, question);
            ps.setInt(3, Integer.parseInt(mark));
            ps.setString(4, subId);
            
            int k = ps.executeUpdate();
            if(k == 1){
                questionId();
                System.out.println("added to database");
                questionField.setText("");
                markField.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "something went wrong\nPlease try again!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(uploadWrittenQuestions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void emptyFieldCheckAndUpload(){
        String question = questionField.getText();
        String mark = markField.getText();
        
        if(question.equals("")){
            cautionQuestion.setVisible(true);
        }else if(mark.equals("")){
            cautionMark.setVisible(true);
        }else{
            uploadQuestions();
        }
    }
    private void maxQuestion(){
        String query = "SELECT * FROM `subjectDetails` WHERE subId = '"+subId+"'";
        try {
            
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            rs.next();
            
            maxQuestionId = rs.getInt("multipleChoice");
            
        } catch (SQLException ex) {
            Logger.getLogger(uploadWrittenQuestions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void forNextButton(){
        if(questionNum == maxQuestionId -1 ){
            nextButton.setText("Finish");
        }
        if(questionNum < maxQuestionId){
            emptyFieldCheckAndUpload();
        }else if(questionNum == maxQuestionId){
            emptyFieldCheckAndUpload();
            dispose();
            JOptionPane.showMessageDialog(this, maxQuestionId + " quesitons added!");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionField = new javax.swing.JTextArea();
        markField = new javax.swing.JTextField();
        nextButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        questionIdLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cautionMark = new javax.swing.JLabel();
        cautionQuestion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 300, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Upload questions for written exam");

        questionField.setColumns(20);
        questionField.setRows(5);
        jScrollPane1.setViewportView(questionField);

        nextButton.setBackground(java.awt.Color.blue);
        nextButton.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Question Number:");

        questionIdLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        questionIdLabel.setText("12");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Mark of the question");

        cautionMark.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        cautionMark.setForeground(java.awt.Color.red);
        cautionMark.setText("please this field ");

        cautionQuestion.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        cautionQuestion.setForeground(java.awt.Color.red);
        cautionQuestion.setText("please this field ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cautionMark)
                    .addComponent(cautionQuestion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionIdLabel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(markField, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(81, 81, 81)
                            .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(questionIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cautionQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(markField))
                .addGap(13, 13, 13)
                .addComponent(cautionMark)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        forNextButton();
    }//GEN-LAST:event_nextButtonActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cautionMark;
    private javax.swing.JLabel cautionQuestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField markField;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextArea questionField;
    private javax.swing.JLabel questionIdLabel;
    // End of variables declaration//GEN-END:variables
}
