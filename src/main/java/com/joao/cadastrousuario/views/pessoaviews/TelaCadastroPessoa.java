package com.joao.cadastrousuario.views.pessoaviews;

import com.joao.cadastrousuario.daos.DAOFactory;
import com.joao.cadastrousuario.daos.PessoaDAO;
import com.joao.cadastrousuario.enums.TipoDocumento;
import com.joao.cadastrousuario.entities.Pessoa;
import com.joao.cadastrousuario.services.PessoaService;
import com.joao.cadastrousuario.views.TelaDeMensagem;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TelaCadastroPessoa extends javax.swing.JDialog {

   
    public TelaCadastroPessoa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private Pessoa capturarPessoaDaTela() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Pessoa pessoa = new Pessoa(jTextField_nome.getText(),
                                   jTextField_sobrenome.getText(),
                                   TipoDocumento.valueOf(jTextField_tipoDocumento.getText()),
                                   jTextField_documento.getText(),
                                   sdf.parse(jTextField_dataNascimento.getText()),
                                   jTextField_telefone.getText());
        return pessoa;
    }
    
   private void cadastrarPessoa(){
       try{
           PessoaService ps = new PessoaService(DAOFactory.createPessoaDAO());
           ps.cadastrarPessoa(capturarPessoaDaTela());
           new TelaDeMensagem(this, "Pessoa cadastrada com sucesso!").setVisible(true);
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
        jPanel_nome = new javax.swing.JPanel();
        jLabel_nome = new javax.swing.JLabel();
        jTextField_nome = new javax.swing.JTextField();
        jPanel_sobrenome = new javax.swing.JPanel();
        jLabel_sobrenome = new javax.swing.JLabel();
        jTextField_sobrenome = new javax.swing.JTextField();
        jPanel_tipoDocumento = new javax.swing.JPanel();
        jLabel_tipoDocumento = new javax.swing.JLabel();
        jTextField_tipoDocumento = new javax.swing.JTextField();
        jLabel_tipoDocOptions = new javax.swing.JLabel();
        jPanel_documento = new javax.swing.JPanel();
        jLabel_documento = new javax.swing.JLabel();
        jTextField_documento = new javax.swing.JTextField();
        jPanel_dataNascimento = new javax.swing.JPanel();
        jLabel_dataNascimento = new javax.swing.JLabel();
        jTextField_dataNascimento = new javax.swing.JTextField();
        jLabel_dateFormat = new javax.swing.JLabel();
        jPanel_telefone = new javax.swing.JPanel();
        jLabel_telefone = new javax.swing.JLabel();
        jTextField_telefone = new javax.swing.JTextField();
        jPanel_space1 = new javax.swing.JPanel();
        jPanel_botoes = new javax.swing.JPanel();
        jButton_cadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel_barra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_barra.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 1));

        jLabelBarra.setText("Cadastro de Pessoas");
        jPanel_barra.add(jLabelBarra);

        getContentPane().add(jPanel_barra, java.awt.BorderLayout.NORTH);

        jPanel_corpo.setLayout(new javax.swing.BoxLayout(jPanel_corpo, javax.swing.BoxLayout.Y_AXIS));

        jPanel_nome.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_nome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_nome.setText(" Nome : ");
        jLabel_nome.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_nome.add(jLabel_nome);

        jTextField_nome.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_nome.add(jTextField_nome);

        jPanel_corpo.add(jPanel_nome);

        jPanel_sobrenome.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_sobrenome.setText(" Sobrenome :");
        jLabel_sobrenome.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_sobrenome.add(jLabel_sobrenome);

        jTextField_sobrenome.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_sobrenome.add(jTextField_sobrenome);

        jPanel_corpo.add(jPanel_sobrenome);

        jPanel_tipoDocumento.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_tipoDocumento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_tipoDocumento.setText(" Tipo Doc:");
        jLabel_tipoDocumento.setAutoscrolls(true);
        jLabel_tipoDocumento.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel_tipoDocumento.setMaximumSize(new java.awt.Dimension(59, 32));
        jLabel_tipoDocumento.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_tipoDocumento.add(jLabel_tipoDocumento);

        jTextField_tipoDocumento.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_tipoDocumento.add(jTextField_tipoDocumento);

        jLabel_tipoDocOptions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_tipoDocOptions.setText("(RG/CPF)");
        jLabel_tipoDocOptions.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel_tipoDocOptions.setPreferredSize(new java.awt.Dimension(80, 16));
        jLabel_tipoDocOptions.setRequestFocusEnabled(false);
        jPanel_tipoDocumento.add(jLabel_tipoDocOptions);

        jPanel_corpo.add(jPanel_tipoDocumento);

        jPanel_documento.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_documento.setText(" Documento :");
        jLabel_documento.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_documento.add(jLabel_documento);

        jTextField_documento.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_documento.add(jTextField_documento);

        jPanel_corpo.add(jPanel_documento);

        jPanel_dataNascimento.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_dataNascimento.setText(" Nascimento : ");
        jLabel_dataNascimento.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_dataNascimento.add(jLabel_dataNascimento);

        jTextField_dataNascimento.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_dataNascimento.add(jTextField_dataNascimento);

        jLabel_dateFormat.setText("(DD/MM/YYYY)");
        jLabel_dateFormat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel_dataNascimento.add(jLabel_dateFormat);

        jPanel_corpo.add(jPanel_dataNascimento);

        jPanel_telefone.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jLabel_telefone.setText(" Telefone:");
        jLabel_telefone.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel_telefone.add(jLabel_telefone);

        jTextField_telefone.setPreferredSize(new java.awt.Dimension(250, 22));
        jPanel_telefone.add(jTextField_telefone);

        jPanel_corpo.add(jPanel_telefone);
        jPanel_corpo.add(jPanel_space1);

        getContentPane().add(jPanel_corpo, java.awt.BorderLayout.CENTER);

        jButton_cadastrar.setText("Cadastrar");
        jButton_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cadastrarActionPerformed(evt);
            }
        });
        jPanel_botoes.add(jButton_cadastrar);

        getContentPane().add(jPanel_botoes, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(403, 468));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cadastrarActionPerformed
        cadastrarPessoa();
    }//GEN-LAST:event_jButton_cadastrarActionPerformed

    
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
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                TelaCadastroPessoa dialog = new TelaCadastroPessoa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton_cadastrar;
    private javax.swing.JLabel jLabelBarra;
    private javax.swing.JLabel jLabel_dataNascimento;
    private javax.swing.JLabel jLabel_dateFormat;
    private javax.swing.JLabel jLabel_documento;
    private javax.swing.JLabel jLabel_nome;
    private javax.swing.JLabel jLabel_sobrenome;
    private javax.swing.JLabel jLabel_telefone;
    private javax.swing.JLabel jLabel_tipoDocOptions;
    private javax.swing.JLabel jLabel_tipoDocumento;
    private javax.swing.JPanel jPanel_barra;
    private javax.swing.JPanel jPanel_botoes;
    private javax.swing.JPanel jPanel_corpo;
    private javax.swing.JPanel jPanel_dataNascimento;
    private javax.swing.JPanel jPanel_documento;
    private javax.swing.JPanel jPanel_nome;
    private javax.swing.JPanel jPanel_sobrenome;
    private javax.swing.JPanel jPanel_space1;
    private javax.swing.JPanel jPanel_telefone;
    private javax.swing.JPanel jPanel_tipoDocumento;
    private javax.swing.JTextField jTextField_dataNascimento;
    private javax.swing.JTextField jTextField_documento;
    private javax.swing.JTextField jTextField_nome;
    private javax.swing.JTextField jTextField_sobrenome;
    private javax.swing.JTextField jTextField_telefone;
    private javax.swing.JTextField jTextField_tipoDocumento;
    // End of variables declaration//GEN-END:variables
}
