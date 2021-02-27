
import e.xam.LoginForm;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;




public class AdminDashboard extends javax.swing.JFrame {
    Connection con; 
    int teacherId = 3;
    String teacherName;
    
    private String url = "jdbc:mysql://localhost/E-xam";
    private String user = "root";
    private String password = "newpassword";
    
    public AdminDashboard() {
        initComponents();
        connect();
        getTeacherDeatails();
        teacherNameLabel.setText(teacherName);
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
    public void getTeacherDeatails(){
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM teachersDetails WHERE Id = '"+teacherId+"'");
            rs.next();
            teacherName = rs.getString("name");
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        teacherNameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 300, 0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(85, 168, 251));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/hackphiles/Documents/E-xam/E-xam/src/e/xam/newpackage/admin.png")); // NOI18N

        teacherNameLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        teacherNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        teacherNameLabel.setText("Admin Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(teacherNameLabel))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(teacherNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("/home/hackphiles/Documents/E-xam/E-xam/src/e/xam/newpackage/myprofile.png")); // NOI18N
        jButton1.setText("My Profile");

        uploadButton.setBackground(new java.awt.Color(255, 255, 255));
        uploadButton.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        uploadButton.setForeground(new java.awt.Color(0, 0, 0));
        uploadButton.setIcon(new javax.swing.ImageIcon("/home/hackphiles/Documents/E-xam/E-xam/src/e/xam/newpackage/upload.png")); // NOI18N
        uploadButton.setText("Upload Questions");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon("/home/hackphiles/Documents/E-xam/E-xam/src/e/xam/newpackage/marksheet.png")); // NOI18N
        jButton3.setText("Mark Sheet");

        exitButton.setBackground(new java.awt.Color(255, 255, 255));
        exitButton.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        exitButton.setForeground(new java.awt.Color(217, 2, 2));
        exitButton.setIcon(new javax.swing.ImageIcon("/home/hackphiles/Documents/E-xam/E-xam/src/e/xam/newpackage/exit.png")); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        new SubjectDetailsForm(teacherId).setVisible(true);
        dispose();
    }//GEN-LAST:event_uploadButtonActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel teacherNameLabel;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
