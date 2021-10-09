package e.xam;

/*import java.sql.DriverManager;*/
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;

public class StudentDashbord extends javax.swing.JFrame {
    
    String mobile;
    
    Connection con = null;
    
    String name;
    
    String url = "jdbc:mysql://localhost/E-xam";
    String user = "root";
    String password = "password";
    
    String examId;
  
    public StudentDashbord(String mobile) {
        initComponents();
        this.mobile = mobile;
        System.out.println("27:studentDashbord"+mobile+" "+this.mobile);
        connect();
        System.out.println(this.mobile);
        examIdField.setVisible(false);
        doneButton.setVisible(false);
        examIdLable.setVisible(false);
        getStudentDetails();
    }
    public void connect(){//Function implement connection to database in loginform
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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

    private void getStudentDetails(){
        Statement s = null;
        ResultSet rs = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM `studentDetails` WHERE mobile = '"+mobile+"'");
            rs.next();
            name = rs.getString("name");
            
            nameLabel.setText(name);
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashbord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void checkAlreadyAttempted(){
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM `StudentWrittenAnswer` WHERE subId = '"+examId+"' AND mobileNumber = '"+mobile+"'");
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "You are already attempted this exam!!");
            }else{
                new StudentAnswerForm(mobile,examId).setVisible(true);
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashbord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void checkRoomAvailable(){
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM `subjectDetails` WHERE subId = '"+examId+"'");
            if(rs.next()){
                checkAlreadyAttempted();
            }else{
                JOptionPane.showMessageDialog(this, "Room ID not available!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDashbord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        attendButton = new javax.swing.JButton();
        examIdField = new javax.swing.JTextField();
        doneButton = new javax.swing.JButton();
        examIdLable = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(600, 300, 0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/hackphiles/Documents/E-xam/E-xam/src/e/xam/newpackage/student(1).png")); // NOI18N

        jPanel2.setBackground(new java.awt.Color(150, 213, 255));

        exitButton.setBackground(new java.awt.Color(255, 255, 255));
        exitButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        exitButton.setForeground(java.awt.Color.red);
        exitButton.setIcon(new javax.swing.ImageIcon("/home/hackphiles/Documents/E-xam/E-xam/src/e/xam/newpackage/exit.png")); // NOI18N
        exitButton.setText("Exit");
        exitButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        attendButton.setBackground(new java.awt.Color(255, 255, 255));
        attendButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        attendButton.setIcon(new javax.swing.ImageIcon("/home/hackphiles/Documents/E-xam/E-xam/src/e/xam/newpackage/marksheet.png")); // NOI18N
        attendButton.setText("Attend Exam");
        attendButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        attendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendButtonActionPerformed(evt);
            }
        });

        doneButton.setBackground(new java.awt.Color(255, 255, 255));
        doneButton.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        doneButton.setText("DONE");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        examIdLable.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        examIdLable.setForeground(java.awt.Color.red);
        examIdLable.setText("Enter exam room Id here");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(doneButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(examIdLable)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(examIdField)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(attendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(examIdLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(examIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doneButton)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        nameLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nameLabel.setText("Student Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(nameLabel)))
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are your sure to exit??");
        if(confirm == JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void attendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendButtonActionPerformed
        examIdField.setVisible(true);
        doneButton.setVisible(true);
        examIdLable.setVisible(true);
    }//GEN-LAST:event_attendButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        examId = examIdField.getText();
        examId = examId.replaceAll(" ", "");
        checkRoomAvailable();
        
    }//GEN-LAST:event_doneButtonActionPerformed

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attendButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JTextField examIdField;
    private javax.swing.JLabel examIdLable;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
