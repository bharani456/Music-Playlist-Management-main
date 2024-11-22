/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.music_hub;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sakkt
 */
public final class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public SignupPage() {
        initComponents();
    }
    
    public int getUserIdFromLogin(String username, String password) {
        int userId = -1;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT user_id FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }
    
    public void insertSignupDetails() {
    String name = txtUser.getText().trim();
    String email = txtEmail.getText().trim();
    String contact = txtMobile.getText().trim();
    String pwd = new String(txtPassword.getPassword()).trim();

    try {
        // Get the database connection
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO users(username, email, contact, password) VALUES (?, ?, ?, ?)";
        
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, contact);
        pst.setString(4, pwd);

        // Execute update and check result
        int updatedRowCount = pst.executeUpdate();
        if (updatedRowCount > 0) {
            JOptionPane.showMessageDialog(this, "User added Successfully");
            clearFields();
            int user_id = getUserIdFromLogin(name,pwd);
            ManagePlaylistAdd home = new ManagePlaylistAdd(user_id);
            home.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Unable to Add User");
        }

    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
public boolean validateSignup(){
    String name = txtUser.getText().trim();
    String email = txtEmail.getText().trim();
    String contact = txtMobile.getText().trim();
    String pwd = new String(txtPassword.getPassword()).trim();
    if(name.equals("")){
        JOptionPane.showMessageDialog(this, "User name cannot be empty!");
        return false;
    }
    
    if(email.equals("")){
        JOptionPane.showMessageDialog(this, "Email cannot be empty!");
        return false;
    }
    
    if(!email.matches("^.+@.+\\..+$")){
        JOptionPane.showMessageDialog(this, "Email is incorrect!");
        return false;
    }
    
    if(contact.equals("")){
        JOptionPane.showMessageDialog(this, "Contact number cannot be empty!");
        return false;
    }
    
    if(!contact.matches("\\d{10}")){
        JOptionPane.showMessageDialog(this, "Contact number is invalid!");
        return false;
    }
    
    if(pwd.equals("")){
        JOptionPane.showMessageDialog(this, "Password cannot be empty!");
        return false;
    }
    
    return true;
}

public boolean checkDuplicateUser(){
    String name = txtUser.getText().trim();
    boolean isExist = false;
    try{
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
        pst.setString(1, name);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            isExist = true;
        }
        else{
            isExist = false;
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    return isExist;
}

public boolean checkDuplicateEmail(){
    String email= txtEmail.getText().trim();
    boolean isExist = false;
    try{
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM users WHERE email = ?");
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            isExist = true;
        }
        else{
            isExist = false;
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    return isExist;
}

private void clearFields() {
    txtUser.setText("");
    txtEmail.setText("");
    txtMobile.setText("");
    txtPassword.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        txtUser = new app.bolivia.swing.JCTextField();
        txtEmail = new app.bolivia.swing.JCTextField();
        txtMobile = new app.bolivia.swing.JCTextField();
        txtPassword = new rojerusan.RSPasswordTextPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Based");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 60, -1));

        jLabel2.setFont(new java.awt.Font("Gabriola", 0, 38)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Music Hub");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 140, 70));

        jLabel3.setFont(new java.awt.Font("Bradley Hand ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("JAVA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\sakkt\\OneDrive\\Documents\\NetBeansProjects\\music_hub\\src\\main\\resources\\icons\\icons\\icon.jpeg")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 850, 980));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Welcome To");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 830));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Account_50px.png"))); // NOI18N
        jLabel4.setText(" ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Create New Account");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, 20));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jLabel10.setText(" ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 50));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, 20));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secure_50px.png"))); // NOI18N
        jLabel12.setText(" ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, -1, 50));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Already have an account??");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 720, -1, 30));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Mobile");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, 20));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jLabel15.setText(" ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, 50));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Password");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, -1, 20));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("SignUp");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("SignUp");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 150, 60));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(102, 102, 255));
        rSMaterialButtonCircle1.setText("Login");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 750, 150, 60));

        txtUser.setBackground(new java.awt.Color(102, 102, 255));
        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtUser.setMargin(new java.awt.Insets(2, 2, 2, 2));
        txtUser.setPlaceholder("Enter User Name");
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 380, 30));

        txtEmail.setBackground(new java.awt.Color(102, 102, 255));
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtEmail.setMargin(new java.awt.Insets(2, 2, 2, 2));
        txtEmail.setPlaceholder("Enter E Mail");
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 380, 30));

        txtMobile.setBackground(new java.awt.Color(102, 102, 255));
        txtMobile.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtMobile.setForeground(new java.awt.Color(255, 255, 255));
        txtMobile.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtMobile.setMargin(new java.awt.Insets(2, 2, 2, 2));
        txtMobile.setPlaceholder("Enter Mobile");
        jPanel2.add(txtMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 380, 30));

        txtPassword.setBackground(new java.awt.Color(102, 102, 255));
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtPassword.setPlaceholder("Enter password");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 380, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 530, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(validateSignup()==true){
            if(checkDuplicateEmail() == false){
                if(checkDuplicateUser() == false){
                    insertSignupDetails();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Username already exist!");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Email is already in use!");
            }
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        LoginPage login= new LoginPage();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SignupPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txtEmail;
    private app.bolivia.swing.JCTextField txtMobile;
    private rojerusan.RSPasswordTextPlaceHolder txtPassword;
    private app.bolivia.swing.JCTextField txtUser;
    // End of variables declaration//GEN-END:variables
}

