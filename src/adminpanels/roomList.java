package adminpanels;


import adminpanels.AttendedStudentList;
import e.xam.LoginForm;
import java.awt.Component;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


public class roomList extends javax.swing.JFrame {
    Connection con = null;
    
    
    String url = "jdbc:mysql://localhost/E-xam";
    String user = "root";
    String password = "newpassword";
    
    private String teacherId;
    
    String subId;
    String examName;
    
    public roomList(String teacherId) {
        this.teacherId = teacherId;
        initComponents();
        caution.setVisible(false);
        connect();
        getRoomDetails();
    }
    public void connect(){//Function implement connection to database in loginform
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
    public void getRoomDetails(){
        Statement s = null;
        ResultSet rs = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM `subjectDetails` WHERE teacherId = '"+teacherId+"'");
            
            while(rs.next()){
                comboBoxForRoom.addItem(rs.getString("examName"));
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(roomList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void selectRoomId(){
        Statement s1 = null;
        ResultSet rs1 = null;
        try {
            s1 = con.createStatement();
            rs1 = s1.executeQuery("SELECT * FROM `subjectDetails` WHERE teacherId = '"+teacherId+"' AND examName = '"+examName+"'");
            rs1.next();
            subId = rs1.getString("subId");
            
            System.out.println(subId);
            
        } catch (SQLException ex) {
            Logger.getLogger(roomList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void checkAndselect(){
        examName = (String) comboBoxForRoom.getSelectedItem();
        System.out.println(examName);
        if(examName.equals("Select any room")){
            caution.setVisible(true);
        }else{
            selectRoomId();
            new AttendedStudentList(subId).setVisible(true);
            dispose();
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxForRoom = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DoneButton = new javax.swing.JButton();
        caution = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(600, 300, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("Select exam room");

        comboBoxForRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select any room" }));

        DoneButton.setText("Done");
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });

        caution.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        caution.setForeground(java.awt.Color.red);
        caution.setText("please select any room");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caution)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(comboBoxForRoom, 0, 218, Short.MAX_VALUE)
                                .addComponent(DoneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caution)
                .addGap(8, 8, 8)
                .addComponent(comboBoxForRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(DoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
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

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
        checkAndselect();
    }//GEN-LAST:event_DoneButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DoneButton;
    private javax.swing.JLabel caution;
    private javax.swing.JComboBox<String> comboBoxForRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
