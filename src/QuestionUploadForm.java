
import e.xam.LoginForm;
import e.xam.RegistrationForm;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import java.sql.*;
import javax.swing.JOptionPane;


public final class QuestionUploadForm extends javax.swing.JFrame {
    
    Connection con;
    int radioFind; //For find which radio button is checked
    boolean fieldEmpty = false;//for check any fields are empty
    String question,optionOne,optionTwo,optionThree,optionFour;//variables for save questions and options
    String subId;
    
    ButtonGroup group = new ButtonGroup();
    
    public QuestionUploadForm(String subId) throws SQLException {
        initComponents();
        connect();
        questionId();
        questionNumLabel.setText(String.valueOf(questionId()));
        this.subId = subId;
        
    }

    private QuestionUploadForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int questionId() throws SQLException{
        Statement st = null;
        int questionId = 0 ;
        try {
            st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT MAX(questionId) FROM questions WHERE subId = '"+subId+"'");
             rs.next();
             questionId = rs.getInt(1) + 1;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionUploadForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questionId;
    }
    public void uploadQuestion() throws SQLException{
            
            question = questionInputField.getText();
            optionOne = optionOneInput.getText();
            optionTwo = optionTwoInput.getText();
            optionThree = optionThreeInput.getText();
            optionFour = optionFourInput.getText();
            
            
            try {
                PreparedStatement ps = con.prepareStatement("insert into questions values(NULL,?,?,?,?,?,?,?,?)");
                ps.setInt(1,questionId());
                ps.setString(2, question);
                ps.setString(3, optionOne);
                ps.setString(4, optionTwo);
                ps.setString(5, optionThree);
                ps.setString(6, optionFour);
                ps.setInt(7, radioFind);
                ps.setString(8,subId);
                
                int k = ps.executeUpdate();
                if(k == 1){
                    System.out.println("Successfully added to database");
                    questionId();
                    questionNumLabel.setText(String.valueOf(questionId()));
                    questionInputField.setText("");
                    optionOneInput.setText("");
                    optionTwoInput.setText("");
                    optionThreeInput.setText("");
                    optionFourInput.setText("");
                    group.clearSelection();
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Something went wrong\nPlease try agian!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuestionUploadForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionInputField = new javax.swing.JTextArea();
        optionOneInput = new javax.swing.JTextField();
        optionThreeInput = new javax.swing.JTextField();
        optionTwoInput = new javax.swing.JTextField();
        optionFourInput = new javax.swing.JTextField();
        optionThreeLabel = new javax.swing.JLabel();
        optionTwoLabel = new javax.swing.JLabel();
        optionFourLabel = new javax.swing.JLabel();
        questionNumLabel = new javax.swing.JLabel();
        optionOneLabel = new javax.swing.JLabel();
        optionOneCheck = new javax.swing.JRadioButton();
        optionThreeCheck = new javax.swing.JRadioButton();
        optionFourCheck = new javax.swing.JRadioButton();
        optionTwoCheck = new javax.swing.JRadioButton();
        Next = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 150, 0, 0));

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel1.setText("Upload your questions");

        questionInputField.setColumns(20);
        questionInputField.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        questionInputField.setRows(3);
        jScrollPane1.setViewportView(questionInputField);

        optionOneInput.setBackground(java.awt.Color.white);
        optionOneInput.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        optionThreeInput.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        optionTwoInput.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        optionFourInput.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        optionThreeLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionThreeLabel.setText("Option 3");

        optionTwoLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionTwoLabel.setText("Option 2");

        optionFourLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionFourLabel.setText("Option 4");

        questionNumLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        questionNumLabel.setText("Question 1 ");

        optionOneLabel.setBackground(java.awt.Color.red);
        optionOneLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        optionOneLabel.setForeground(new java.awt.Color(1, 1, 1));
        optionOneLabel.setText("Option 1");

        optionOneCheck.setBackground(new java.awt.Color(254, 254, 254));
        optionOneCheck.setForeground(java.awt.Color.white);
        optionOneCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionOneCheckActionPerformed(evt);
            }
        });

        optionThreeCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionThreeCheckActionPerformed(evt);
            }
        });

        optionFourCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionFourCheckActionPerformed(evt);
            }
        });

        optionTwoCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionTwoCheckActionPerformed(evt);
            }
        });

        Next.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(optionThreeCheck)
                                .addComponent(optionOneCheck))
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(optionThreeLabel)
                                .addComponent(optionOneLabel))
                            .addGap(947, 947, 947))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(optionTwoCheck)
                                    .addGap(3, 3, 3)
                                    .addComponent(optionTwoLabel))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(optionFourCheck)
                                    .addGap(4, 4, 4)
                                    .addComponent(optionFourLabel))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(optionFourInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                        .addComponent(optionTwoInput, javax.swing.GroupLayout.Alignment.TRAILING))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(questionNumLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(optionThreeInput, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                                .addComponent(optionOneInput)))
                        .addContainerGap(580, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(300, 300, 300))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addComponent(questionNumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optionTwoLabel)
                            .addComponent(optionTwoCheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionTwoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(optionOneCheck)
                            .addComponent(optionOneLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optionOneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(optionThreeCheck)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(optionFourCheck)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optionThreeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(optionFourLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optionFourInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionThreeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void optionOneCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionOneCheckActionPerformed
         radioFind = 1;
    }//GEN-LAST:event_optionOneCheckActionPerformed

    private void optionThreeCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionThreeCheckActionPerformed
       
        radioFind = 3;
    }//GEN-LAST:event_optionThreeCheckActionPerformed

    private void optionFourCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionFourCheckActionPerformed
        
        radioFind = 4;
    }//GEN-LAST:event_optionFourCheckActionPerformed

    private void optionTwoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionTwoCheckActionPerformed
        radioFind = 2;
    }//GEN-LAST:event_optionTwoCheckActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
       if(radioFind > 0){ //for check whether any of radio button is enabled
           try {
           uploadQuestion();
           } catch (SQLException ex) {
               Logger.getLogger(QuestionUploadForm.class.getName()).log(Level.SEVERE, null, ex);
           }
                
       }else{
           JOptionPane.showMessageDialog(this, "Please select correct answer also!!");
           optionOneLabel.setForeground(Color.red);
           optionOneLabel.setFont(new java.awt.Font("Ubuntu", 2, 18));
           optionTwoLabel.setForeground(Color.red);
           optionTwoLabel.setFont(new java.awt.Font("Ubuntu", 2, 18));
           optionThreeLabel.setForeground(Color.red);
           optionThreeLabel.setFont(new java.awt.Font("Ubuntu", 2, 18));
           optionFourLabel.setForeground(Color.red);
           optionFourLabel.setFont(new java.awt.Font("Ubuntu", 2, 18));
           
       }
    }//GEN-LAST:event_NextActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionUploadForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Next;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton optionFourCheck;
    private javax.swing.JTextField optionFourInput;
    private javax.swing.JLabel optionFourLabel;
    private javax.swing.JRadioButton optionOneCheck;
    private javax.swing.JTextField optionOneInput;
    private javax.swing.JLabel optionOneLabel;
    private javax.swing.JRadioButton optionThreeCheck;
    private javax.swing.JTextField optionThreeInput;
    private javax.swing.JLabel optionThreeLabel;
    private javax.swing.JRadioButton optionTwoCheck;
    private javax.swing.JTextField optionTwoInput;
    private javax.swing.JLabel optionTwoLabel;
    private javax.swing.JTextArea questionInputField;
    private javax.swing.JLabel questionNumLabel;
    // End of variables declaration//GEN-END:variables
}
