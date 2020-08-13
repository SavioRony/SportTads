package View;

public class TelaPrincipalView extends javax.swing.JFrame {

    public TelaPrincipalView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVenda = new javax.swing.JLabel();
        lblRelatorio = new javax.swing.JLabel();
        lblProduto = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuCadastrarCliente = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuCadastrarProduto = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuVenda = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuRelatorio1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menus");

        lblVenda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venda.png"))); // NOI18N
        lblVenda.setText("Venda");
        lblVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVendaMouseClicked(evt);
            }
        });

        lblRelatorio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorio.png"))); // NOI18N
        lblRelatorio.setText("Relatório");
        lblRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRelatorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRelatorioMouseClicked(evt);
            }
        });

        lblProduto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/item.png"))); // NOI18N
        lblProduto.setText("Produto");
        lblProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProdutoMouseClicked(evt);
            }
        });

        lblCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente add.png"))); // NOI18N
        lblCliente.setText("Cliente");
        lblCliente.setToolTipText("");
        lblCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClienteMouseClicked(evt);
            }
        });

        jMenu2.setText("Cliente");

        menuCadastrarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        menuCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente add32.png"))); // NOI18N
        menuCadastrarCliente.setText("Cadastro e consulta");
        menuCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarClienteActionPerformed(evt);
            }
        });
        jMenu2.add(menuCadastrarCliente);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Produto");

        menuCadastrarProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        menuCadastrarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/item32.png"))); // NOI18N
        menuCadastrarProduto.setText("Cadastrar e Consultar");
        menuCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadastrarProduto);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Venda");

        menuVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        menuVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venda32.png"))); // NOI18N
        menuVenda.setText("Venda");
        menuVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVendaActionPerformed(evt);
            }
        });
        jMenu3.add(menuVenda);

        jMenuBar1.add(jMenu3);

        menuRelatorio.setText("Relatório");

        menuRelatorio1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        menuRelatorio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/relatorio32.png"))); // NOI18N
        menuRelatorio1.setText("Relatorio de venda");
        menuRelatorio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorio1ActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuRelatorio1);

        jMenuBar1.add(menuRelatorio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRelatorio)
                    .addComponent(lblProduto))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProduto)
                    .addComponent(lblCliente))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVenda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRelatorio, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVendaMouseClicked
        TeladeVendaView tela = new TeladeVendaView();
        tela.setVisible(true);
    }//GEN-LAST:event_lblVendaMouseClicked

    private void lblRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRelatorioMouseClicked
        TelaRelatorioView tela = new TelaRelatorioView();
        tela.setVisible(true);
    }//GEN-LAST:event_lblRelatorioMouseClicked

    private void lblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProdutoMouseClicked
        CadastroDeProdutoView tela = new CadastroDeProdutoView();
        tela.setVisible(true);
    }//GEN-LAST:event_lblProdutoMouseClicked

    private void lblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClienteMouseClicked
        CadastroDeClienteView tela = new CadastroDeClienteView();
        tela.setVisible(true);
    }//GEN-LAST:event_lblClienteMouseClicked

    private void menuCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarClienteActionPerformed
        CadastroDeClienteView tela = new CadastroDeClienteView();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCadastrarClienteActionPerformed

    private void menuCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarProdutoActionPerformed
        CadastroDeProdutoView tela = new CadastroDeProdutoView();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCadastrarProdutoActionPerformed

    private void menuRelatorio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorio1ActionPerformed
        TelaRelatorioView tela = new TelaRelatorioView();
        tela.setVisible(true);
    }//GEN-LAST:event_menuRelatorio1ActionPerformed

    private void menuVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVendaActionPerformed
        TeladeVendaView tela = new TeladeVendaView();
        tela.setVisible(true);         
    }//GEN-LAST:event_menuVendaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblRelatorio;
    private javax.swing.JLabel lblVenda;
    private javax.swing.JMenuItem menuCadastrarCliente;
    private javax.swing.JMenuItem menuCadastrarProduto;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenuItem menuRelatorio1;
    private javax.swing.JMenuItem menuVenda;
    // End of variables declaration//GEN-END:variables
}
