/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.xam;

/**
 *
 * @author hackphiles
 */
public class SelectionForm extends javax.swing.JFrame {

    /**
     * Creates new form SelectionForm
     */
    public SelectionForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        teacherAlreadyButton = new javax.swing.JButton();
        studentAlreadyButton = new javax.swing.JButton();
        studentCreateButton = new javax.swing.JButton();
        teacherCreateButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        teacherAlreadyButton.setBackground(new java.awt.Color(2, 43, 149));
        teacherAlreadyButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        teacherAlreadyButton.setForeground(new java.awt.Color(254, 254, 254));
        teacherAlreadyButton.setText("Already have an account");
        teacherAlreadyButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(teacherAlreadyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 240, 60));

        studentAlreadyButton.setBackground(new java.awt.Color(2, 43, 149));
        studentAlreadyButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        studentAlreadyButton.setForeground(new java.awt.Color(254, 254, 254));
        studentAlreadyButton.setText("Already have an account");
        studentAlreadyButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        studentAlreadyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentAlreadyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(studentAlreadyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 240, 60));

        studentCreateButton.setBackground(new java.awt.Color(2, 43, 149));
        studentCreateButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        studentCreateButton.setForeground(new java.awt.Color(254, 254, 254));
        studentCreateButton.setText("Create new account");
        studentCreateButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        studentCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentCreateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(studentCreateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 240, 60));

        teacherCreateButton.setBackground(new java.awt.Color(2, 43, 149));
        teacherCreateButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        teacherCreateButton.setForeground(new java.awt.Color(254, 254, 254));
        teacherCreateButton.setText("Create new account");
        teacherCreateButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        getContentPane().add(teacherCreateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 240, 60));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("I am a Student");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("I am a Teacher");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("|");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 20, 30));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("|");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 20, 30));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 47)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("|");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 20, -1));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("|");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 20, 30));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("|");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 20, 30));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("|");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 20, 30));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 47)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("|");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 20, -1));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("|");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 20, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setIcon(new javax.swing.ImageIcon("/home/hackphiles/Documents/E-xam/E-xam/src/e/xam/newpackage/BG_Hashtech_OutSystems.jpg")); // NOI18N
        jLabel1.setText("|");
        jLabel1.setPreferredSize(new java.awt.Dimension(1204, 600));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 649));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentAlreadyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentAlreadyButtonActionPerformed
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_studentAlreadyButtonActionPerformed

    private void studentCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentCreateButtonActionPerformed
        RegistrationForm regForm = new RegistrationForm();
        regForm.setVisible(true);
        dispose();
    }//GEN-LAST:event_studentCreateButtonActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton studentAlreadyButton;
    private javax.swing.JButton studentCreateButton;
    private javax.swing.JButton teacherAlreadyButton;
    private javax.swing.JButton teacherCreateButton;
    // End of variables declaration//GEN-END:variables
}