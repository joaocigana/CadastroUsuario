package com.joao.cadastrousuario.views;

import com.joao.cadastrousuario.views.pessoaviews.*;
import com.joao.cadastrousuario.views.userviews.*;

public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBarra = new javax.swing.JPanel();
        jLabel_Barra = new javax.swing.JLabel();
        jPanel_BotoesPessoa = new javax.swing.JPanel();
        jButton_CadastrarPessoa = new javax.swing.JButton();
        jButton_ListarPessoas = new javax.swing.JButton();
        jButton_AtualizarPessoa = new javax.swing.JButton();
        jButton_DeletarPessoa = new javax.swing.JButton();
        jPanel_BotoesUsuario = new javax.swing.JPanel();
        jButton_CadastrarUsuario = new javax.swing.JButton();
        jButton_ListarUsuarios = new javax.swing.JButton();
        jButton_AtualizarUsuario = new javax.swing.JButton();
        jButton_DeletarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanelBarra.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanelBarra.setLayout(new javax.swing.BoxLayout(jPanelBarra, javax.swing.BoxLayout.X_AXIS));

        jLabel_Barra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Barra.setText("Cadastro Pessoas e Usuarios");
        jLabel_Barra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelBarra.add(jLabel_Barra);

        getContentPane().add(jPanelBarra);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 35);
        flowLayout1.setAlignOnBaseline(true);
        jPanel_BotoesPessoa.setLayout(flowLayout1);

        jButton_CadastrarPessoa.setText("Cadastrar Pessoa");
        jButton_CadastrarPessoa.setPreferredSize(new java.awt.Dimension(130, 25));
        jButton_CadastrarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastrarPessoaActionPerformed(evt);
            }
        });
        jPanel_BotoesPessoa.add(jButton_CadastrarPessoa);

        jButton_ListarPessoas.setText("Listar Pessoas");
        jButton_ListarPessoas.setPreferredSize(new java.awt.Dimension(130, 25));
        jButton_ListarPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ListarPessoasActionPerformed(evt);
            }
        });
        jPanel_BotoesPessoa.add(jButton_ListarPessoas);

        jButton_AtualizarPessoa.setText("Atualizar Pessoa");
        jButton_AtualizarPessoa.setPreferredSize(new java.awt.Dimension(130, 25));
        jButton_AtualizarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AtualizarPessoaActionPerformed(evt);
            }
        });
        jPanel_BotoesPessoa.add(jButton_AtualizarPessoa);

        jButton_DeletarPessoa.setText("Deletar Pessoa");
        jButton_DeletarPessoa.setPreferredSize(new java.awt.Dimension(130, 25));
        jButton_DeletarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeletarPessoaActionPerformed(evt);
            }
        });
        jPanel_BotoesPessoa.add(jButton_DeletarPessoa);

        getContentPane().add(jPanel_BotoesPessoa);

        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 30);
        flowLayout2.setAlignOnBaseline(true);
        jPanel_BotoesUsuario.setLayout(flowLayout2);

        jButton_CadastrarUsuario.setText("Cadastrar Usuario");
        jButton_CadastrarUsuario.setPreferredSize(new java.awt.Dimension(130, 25));
        jButton_CadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CadastrarUsuarioActionPerformed(evt);
            }
        });
        jPanel_BotoesUsuario.add(jButton_CadastrarUsuario);

        jButton_ListarUsuarios.setText("Listar Usuario");
        jButton_ListarUsuarios.setPreferredSize(new java.awt.Dimension(130, 25));
        jButton_ListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ListarUsuariosActionPerformed(evt);
            }
        });
        jPanel_BotoesUsuario.add(jButton_ListarUsuarios);

        jButton_AtualizarUsuario.setText("Atualizar Usuario");
        jButton_AtualizarUsuario.setPreferredSize(new java.awt.Dimension(130, 25));
        jButton_AtualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AtualizarUsuarioActionPerformed(evt);
            }
        });
        jPanel_BotoesUsuario.add(jButton_AtualizarUsuario);

        jButton_DeletarUsuario.setText("Deletar Usuario");
        jButton_DeletarUsuario.setPreferredSize(new java.awt.Dimension(130, 25));
        jButton_DeletarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeletarUsuarioActionPerformed(evt);
            }
        });
        jPanel_BotoesUsuario.add(jButton_DeletarUsuario);

        getContentPane().add(jPanel_BotoesUsuario);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CadastrarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastrarPessoaActionPerformed
        new TelaCadastroPessoa(this, true).setVisible(true);
    }//GEN-LAST:event_jButton_CadastrarPessoaActionPerformed

    private void jButton_ListarPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ListarPessoasActionPerformed
        new TelaListarPessoas(this, false).setVisible(true);
    }//GEN-LAST:event_jButton_ListarPessoasActionPerformed

    private void jButton_AtualizarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtualizarPessoaActionPerformed
        new TelaAtualizarPessoa(this, true).setVisible(true);
    }//GEN-LAST:event_jButton_AtualizarPessoaActionPerformed

    private void jButton_DeletarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeletarPessoaActionPerformed
        new TelaDeletarPessoa(this, true).setVisible(true);
    }//GEN-LAST:event_jButton_DeletarPessoaActionPerformed

    private void jButton_CadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CadastrarUsuarioActionPerformed
        new TelaCadastroUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_jButton_CadastrarUsuarioActionPerformed

    private void jButton_ListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ListarUsuariosActionPerformed
        new TelaListarUsuarios(this, false).setVisible(true);
    }//GEN-LAST:event_jButton_ListarUsuariosActionPerformed

    private void jButton_AtualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AtualizarUsuarioActionPerformed
        new TelaAtualizarUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_jButton_AtualizarUsuarioActionPerformed

    private void jButton_DeletarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeletarUsuarioActionPerformed
        new TelaDeletarUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_jButton_DeletarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AtualizarPessoa;
    private javax.swing.JButton jButton_AtualizarUsuario;
    private javax.swing.JButton jButton_CadastrarPessoa;
    private javax.swing.JButton jButton_CadastrarUsuario;
    private javax.swing.JButton jButton_DeletarPessoa;
    private javax.swing.JButton jButton_DeletarUsuario;
    private javax.swing.JButton jButton_ListarPessoas;
    private javax.swing.JButton jButton_ListarUsuarios;
    private javax.swing.JLabel jLabel_Barra;
    private javax.swing.JPanel jPanelBarra;
    private javax.swing.JPanel jPanel_BotoesPessoa;
    private javax.swing.JPanel jPanel_BotoesUsuario;
    // End of variables declaration//GEN-END:variables
}
