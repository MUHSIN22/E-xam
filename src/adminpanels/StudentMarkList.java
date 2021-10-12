/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package adminpanels;

import e.xam.LoginForm;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author texki
 */
public final class StudentMarkList extends javax.swing.JFrame {
    private String url = "jdbc:mysql://localhost/E-xam";
    private String user = "root";
    private String password = "password";
    String examId;
    String teacherId;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    public StudentMarkList(String examId) {
        this.examId = examId;
        initComponents();
        connect();
        getScoreAndDetails();
        getExamDetails();
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
   public void getScoreAndDetails(){
        String query = "SELECT rollNo,name,semester,department,studentScores.score FROM studentScores INNER JOIN studentDetails on studentScores.studentMobile = studentDetails.mobile AND studentScores.examId='"+examId+"' ORDER BY rollNo ASC ";
        DefaultTableModel model = (DefaultTableModel) markTable.getModel();
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                String name = rs.getString("name");
                int rollNo = rs.getInt("rollNo");
                String semester = rs.getString("semester");
                String department = rs.getString("department");
                int score = rs.getInt("studentScores.score");
                model.addRow(new Object[]{name,rollNo,semester,department,score});
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentMarkList.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void getExamDetails(){
       String query = "SELECT examName,subName,subCode,teacherId FROM subjectDetails WHERE subId='"+examId+"';";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            String exmName = rs.getString("examName");
            String subName = rs.getString("subName");
            String subCode = rs.getString("subCode");
            String teacherId = rs.getString("teacherId");
            this.teacherId = teacherId;
            subjectName.setText(subName);
            subjectCode.setText(subCode);
            examName.setText(exmName);
        } catch (SQLException ex) {
            Logger.getLogger(StudentMarkList.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        examName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        markTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        subjectName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        subjectCode = new javax.swing.JLabel();
        goHomeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        examName.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        examName.setForeground(new java.awt.Color(0, 0, 0));
        examName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        examName.setText("Exam Name");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mark List");

        markTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Name", "Roll Number", "Semester", "Department", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(markTable);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Subject Name:");

        subjectName.setForeground(new java.awt.Color(0, 0, 0));
        subjectName.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Subject Code:");

        subjectCode.setForeground(new java.awt.Color(0, 0, 0));
        subjectCode.setText("jLabel4");

        goHomeButton.setText("Go to home");
        goHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goHomeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(examName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(goHomeButton)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(subjectName)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(subjectCode)
                                    .addGap(89, 89, 89))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(examName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(subjectName)
                    .addComponent(jLabel3)
                    .addComponent(subjectCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(goHomeButton)
                .addContainerGap(33, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goHomeButtonActionPerformed
        new AdminDashboard(teacherId).setVisible(true);
        dispose();
    }//GEN-LAST:event_goHomeButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel examName;
    private javax.swing.JButton goHomeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable markTable;
    private javax.swing.JLabel subjectCode;
    private javax.swing.JLabel subjectName;
    // End of variables declaration//GEN-END:variables
}
