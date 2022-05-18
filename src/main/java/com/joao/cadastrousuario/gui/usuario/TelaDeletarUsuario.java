package com.joao.cadastrousuario.gui.usuario;

import com.joao.cadastrousuario.daos.DAOFactory;
import com.joao.cadastrousuario.services.UsuarioService;
import com.joao.cadastrousuario.gui.TelaDeMensagem;

public class TelaDeletarUsuario extends javax.swing.JDialog {

    public TelaDeletarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private void deletarUsuario(){
        UsuarioService us = new UsuarioService(DAOFactory.createUsuarioDAO());
        try{
        us.deletarUsuario(Integer.valueOf(jTextField_Id.getText()));
        new TelaDeMensagem(this, "Deleção concluida com sucesso!").setVisible(true);
        }
        catch (Exception ex){
            new TelaDeMensagem(this, ex.getMessage()).setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Barra = new javax.swing.JPanel();
        jLabel_Barra = new javax.swing.JLabel();
        jPanel_Deletar = new javax.swing.JPanel();
        jButton_Deletar = new javax.swing.JButton();
        jPanel_Corpo = new javax.swing.JPanel();
        jLabel_Id = new javax.swing.JLabel();
        jTextField_Id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel_Barra.setPreferredSize(new java.awt.Dimension(400, 35));
        jPanel_Barra.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jLabel_Barra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_Barra.setText("Deletar Usuario");
        jPanel_Barra.add(jLabel_Barra);

        getContentPane().add(jPanel_Barra, java.awt.BorderLayout.NORTH);

        jPanel_Deletar.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel_Deletar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        jButton_Deletar.setText("Deletar");
        jButton_Deletar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeletarActionPerformed(evt);
            }
        });
        jPanel_Deletar.add(jButton_Deletar);

        getContentPane().add(jPanel_Deletar, java.awt.BorderLayout.SOUTH);

        jPanel_Corpo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 50));

        jLabel_Id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Id.setText("ID:");
        jPanel_Corpo.add(jLabel_Id);

        jTextField_Id.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel_Corpo.add(jTextField_Id);

        getContentPane().add(jPanel_Corpo, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeletarActionPerformed
        deletarUsuario();
    }//GEN-LAST:event_jButton_DeletarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeletarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeletarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeletarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeletarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaDeletarUsuario dialog = new TelaDeletarUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Deletar;
    private javax.swing.JLabel jLabel_Barra;
    private javax.swing.JLabel jLabel_Id;
    private javax.swing.JPanel jPanel_Barra;
    private javax.swing.JPanel jPanel_Corpo;
    private javax.swing.JPanel jPanel_Deletar;
    private javax.swing.JTextField jTextField_Id;
    // End of variables declaration//GEN-END:variables
}
