package com.joao.cadastrousuario.views.userviews;

import com.joao.cadastrousuario.daos.DAOFactory;
import com.joao.cadastrousuario.enums.TipoDocumento;
import com.joao.cadastrousuario.entities.Pessoa;
import com.joao.cadastrousuario.entities.Usuario;
import com.joao.cadastrousuario.services.PessoaService;
import com.joao.cadastrousuario.services.UsuarioService;
import com.joao.cadastrousuario.views.TelaDeMensagem;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TelaAtualizarUsuario extends javax.swing.JDialog {

   
    public TelaAtualizarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private Usuario capturarUsuarioDaTela(Pessoa pessoa) throws ParseException{
        Usuario usuario = new Usuario();
        usuario.setId(Integer.valueOf(jTextField_Id.getText()));
        usuario.setUsername(jTextField_username.getText());
        usuario.setEmail(jTextField_email.getText());
        usuario.setSenha(jTextField_senha.getText());
        usuario.setPessoa(pessoa);
        return usuario;
    }
    
   private void atualizarUsuario(){
       try{
           UsuarioService us = new UsuarioService(DAOFactory.createUsuarioDAO());
           PessoaService ps = new PessoaService(DAOFactory.createPessoaDAO());
           Pessoa pessoa = ps.buscarPessoaPeloId(Integer.valueOf(jTextField_IdPessoa.getText()));
           us.atualizarUsuario(capturarUsuarioDaTela(pessoa));
           new TelaDeMensagem(this, "Usuario atualizado com sucesso!").setVisible(true);
       }
       catch (Exception ex){
           new TelaDeMensagem(this, ex.getMessage()).setVisible(true);
       }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_barra = new javax.swing.JPanel();
        jLabelBarra = new javax.swing.JLabel();
        jPanel_corpo = new javax.swing.JPanel();
        jPanel_Id = new javax.swing.JPanel();
        jLabel_Id = new javax.swing.JLabel();
        jTextField_Id = new javax.swing.JTextField();
        jPanel_username = new javax.swing.JPanel();
        jLabel_username = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jPanel_email = new javax.swing.JPanel();
        jLabel_email = new javax.swing.JLabel();
        jTextField_email = new javax.swing.JTextField();
        jPanel_senha = new javax.swing.JPanel();
        jLabel_senha = new javax.swing.JLabel();
        jTextField_senha = new javax.swing.JTextField();
        jPanel_IdPessoa = new javax.swing.JPanel();
        jLabel_IdPessoa = new javax.swing.JLabel();
        jTextField_IdPessoa = new javax.swing.JTextField();
        jPanel_botoes = new javax.swing.JPanel();
        jButton_atualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel_barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_barra.setPreferredSize(new java.awt.Dimension(119, 30));

        jLabelBarra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelBarra.setText("Atualizar Usuario");
        jPanel_barra.add(jLabelBarra);

        getContentPane().add(jPanel_barra, java.awt.BorderLayout.NORTH);

        jPanel_corpo.setLayout(new javax.swing.BoxLayout(jPanel_corpo, javax.swing.BoxLayout.Y_AXIS));

        jPanel_Id.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_Id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Id.setText("Id:");
        jLabel_Id.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_Id.add(jLabel_Id);

        jTextField_Id.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_Id.add(jTextField_Id);

        jPanel_corpo.add(jPanel_Id);

        jPanel_username.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_username.setText("Username:");
        jLabel_username.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_username.add(jLabel_username);

        jTextField_username.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_username.add(jTextField_username);

        jPanel_corpo.add(jPanel_username);

        jPanel_email.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_email.setText("Email:");
        jLabel_email.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_email.add(jLabel_email);

        jTextField_email.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_email.add(jTextField_email);

        jPanel_corpo.add(jPanel_email);

        jPanel_senha.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_senha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_senha.setText(" Senha:");
        jLabel_senha.setAutoscrolls(true);
        jLabel_senha.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel_senha.setMaximumSize(new java.awt.Dimension(59, 32));
        jLabel_senha.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_senha.add(jLabel_senha);

        jTextField_senha.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_senha.add(jTextField_senha);

        jPanel_corpo.add(jPanel_senha);

        jPanel_IdPessoa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_IdPessoa.setText(" Id Pessoa :");
        jLabel_IdPessoa.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_IdPessoa.add(jLabel_IdPessoa);

        jTextField_IdPessoa.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_IdPessoa.add(jTextField_IdPessoa);

        jPanel_corpo.add(jPanel_IdPessoa);

        getContentPane().add(jPanel_corpo, java.awt.BorderLayout.CENTER);

        jButton_atualizar.setText("Atualizar");
        jButton_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_atualizarActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_atualizar);

        getContentPane().add(jPanel_botoes, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(403, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_atualizarActionPerformed
        atualizarUsuario();
    }//GEN-LAST:event_jButton_atualizarActionPerformed

    
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
            java.util.logging.Logger.getLogger(TelaAtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAtualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAtualizarUsuario dialog = new TelaAtualizarUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_atualizar;
    private javax.swing.JLabel jLabelBarra;
    private javax.swing.JLabel jLabel_Id;
    private javax.swing.JLabel jLabel_IdPessoa;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_senha;
    private javax.swing.JLabel jLabel_username;
    private javax.swing.JPanel jPanel_Id;
    private javax.swing.JPanel jPanel_IdPessoa;
    private javax.swing.JPanel jPanel_barra;
    private javax.swing.JPanel jPanel_botoes;
    private javax.swing.JPanel jPanel_corpo;
    private javax.swing.JPanel jPanel_email;
    private javax.swing.JPanel jPanel_senha;
    private javax.swing.JPanel jPanel_username;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_IdPessoa;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_senha;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}
