package com.joao.cadastrousuario.gui.pessoa;

import com.joao.cadastrousuario.daos.DAOFactory;
import com.joao.cadastrousuario.entities.Pessoa;
import com.joao.cadastrousuario.services.PessoaService;
import com.joao.cadastrousuario.gui.TelaDeMensagem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TelaListarPessoas extends javax.swing.JDialog {

    public TelaListarPessoas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        popularTabela();
    }
    
    private void popularTabela(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Pessoa> list = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) jTable_Pessoas.getModel();
        try{
            PessoaService ps = new PessoaService(DAOFactory.createPessoaDAO());
            list = ps.listarPessoas();
            for(Pessoa x : list){
                String id = Integer.toString(x.getId());
                String firstname = x.getPrimeiroNome();
                String lastname = x.getSobrenome();
                String docType = x.getTipoDocumento().name();
                String doc = x.getDocumento();
                String birth = sdf.format(x.getDataNascimento());
                String phone = x.getTelefone();
                String[] linha = new String[] {id, firstname, lastname, docType, doc, birth, phone};
                dtm.addRow(linha);
            }
        } catch (Exception ex){
            new TelaDeMensagem(this, ex.getMessage()).setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane_ListaPessoas = new javax.swing.JScrollPane();
        jTable_Pessoas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable_Pessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Sobrenome", "Tipo_Doc", "Documento", "Nascimento", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane_ListaPessoas.setViewportView(jTable_Pessoas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_ListaPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_ListaPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaListarPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListarPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListarPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListarPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaListarPessoas dialog = new TelaListarPessoas(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane_ListaPessoas;
    private javax.swing.JTable jTable_Pessoas;
    // End of variables declaration//GEN-END:variables
}
