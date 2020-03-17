/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.ClienteModel;

/**
 *
 * @author vitor
 */
public class Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    public Cliente() {
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

        btnVoltarCliente = new javax.swing.JButton();
        btnSalvarCliente = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        slctUf = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCodigoCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVoltarCliente.setBackground(new java.awt.Color(102, 102, 102));
        btnVoltarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltarCliente.setText("Voltar");
        btnVoltarCliente.setToolTipText("");
        btnVoltarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 110, 40));

        btnSalvarCliente.setBackground(new java.awt.Color(0, 102, 204));
        btnSalvarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarCliente.setText("Salvar");
        btnSalvarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, 130, 40));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Telefone:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, -1, -1));

        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });
        getContentPane().add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 200, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("E-mail:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, -1, -1));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 530, 200, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Rg:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, -1, -1));

        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });
        getContentPane().add(txtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, 200, 30));

        slctUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "teste" }));
        slctUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slctUfActionPerformed(evt);
            }
        });
        getContentPane().add(slctUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 90, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("UF:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cadastrar Cliente");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Endereço:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, -1, -1));

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 200, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nome:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, -1, -1));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 200, 30));

        txtCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 200, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Código:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/form-PainelFundo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/61764.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuCadastro.setText("Cadastro");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icones/cliente-icone.png"))); // NOI18N
        jMenuItem1.setText("Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icones/pagamento-icone.png"))); // NOI18N
        jMenuItem2.setText("Pagamento");
        jMenuCadastro.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/icones/money.png"))); // NOI18N
        jMenuItem3.setText("Dívida");
        jMenuCadastro.add(jMenuItem3);

        jMenuBar1.add(jMenuCadastro);

        jMenu2.setText("Alteração");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoClienteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void slctUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slctUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slctUfActionPerformed

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void btnVoltarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltarClienteActionPerformed

    private void btnSalvarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarClienteActionPerformed
        // TODO add your handling code here:
        ClienteModel cliente = new ClienteModel(); 
        cliente.setNomeCliente(txtNome.getText());
        cliente.setTelefone(txtTel.getText());
        cliente.setEndereco(txtEndereco.getText());
        cliente.setUf(slctUf.getSelectedItem().toString());
        cliente.setDocumento(txtRg.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.salvarCliente(cliente);
       
    
        
       
    }//GEN-LAST:event_btnSalvarClienteActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvarCliente;
    private javax.swing.JButton btnVoltarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JComboBox<String> slctUf;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}