package View;

import Controller.VendaController;
import Model.ClienteModel;
import Model.ProdutoModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TeladeVendaView extends javax.swing.JFrame {

    private DefaultTableModel tCarrinho = new DefaultTableModel();
    private DefaultTableModel tCliente = new DefaultTableModel();

    public TeladeVendaView() {
        initComponents();
        setLocationRelativeTo(null);

        tCarrinho.addColumn("Codigo");
        tCarrinho.addColumn("Nome");
        tCarrinho.addColumn("Categoria");
        tCarrinho.addColumn("Marca");
        tCarrinho.addColumn("Quantidade");
        tCarrinho.addColumn("Valor");
        tCarrinho.addColumn("Sub-total");

        tCliente.addColumn("ID");
        tCliente.addColumn("Nome");
        tCliente.addColumn("CPF");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSelecionarCliente = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtvalorTotal = new javax.swing.JTextField();
        btnFinalizarPedido = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        btnSelecionarProduto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Venda");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecionar Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("CPF");

        btnSelecionarCliente.setText("Selecionar");
        btnSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarClienteActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF", "Nome"
            }
        ));
        jScrollPane2.setViewportView(tblCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrinho", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Marca", "Quantidade", "Valor unitário", "Sub-total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCarrinho);

        btnExcluir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnExcluir});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAlterar, btnExcluir});

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Valor total:");

        txtvalorTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnFinalizarPedido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnFinalizarPedido.setText("Finalizar pedido");
        btnFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecionar Produto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Código do Produto");

        txtIdProduto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtIdProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProdutoKeyTyped(evt);
            }
        });

        btnSelecionarProduto.setText("Selecionar");
        btnSelecionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarProdutoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Quantidade");

        txtQuantidade.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelecionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(120, 120, 120))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarProduto))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtvalorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtvalorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPedidoActionPerformed
        String mensagemErro = "";
        boolean erro = false;
        if (tblCliente.getRowCount() == 0) {
            mensagemErro += "Deve ser informado o cliente que deseja realizar a compra\n";
            erro = true;
        }

        if (tblCarrinho.getRowCount() == 0) {
            mensagemErro += "Deve ser selecionado pelo menos um produto";
            erro = true;
        }

        int opcao = 1;
        if (erro) {
            JOptionPane.showMessageDialog(this, mensagemErro, "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            opcao = JOptionPane.showConfirmDialog(this, "Deseja finalizar a comprar?", "Finalizar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        if (opcao == 0) {
            boolean retorno = false;

            int idCliente = Integer.parseInt(tblCliente.getValueAt(0, 0).toString());
            double valorTotal = Double.parseDouble(txtvalorTotal.getText());
            Date dataAtual = new Date();

            int idVenda = VendaController.Venda(idCliente, valorTotal, dataAtual);

            for (int i = 0; i < tCarrinho.getRowCount(); i++) {
                int idProduto = Integer.parseInt(tCarrinho.getValueAt(i, 0).toString());
                int quantidade = Integer.parseInt(tCarrinho.getValueAt(i, 4).toString());
                double valorUnitario = Double.parseDouble(tCarrinho.getValueAt(i, 5).toString());
                double subValor = Double.parseDouble(tCarrinho.getValueAt(i, 6).toString());

                retorno = VendaController.ItemVenda(idVenda, idProduto, quantidade, valorUnitario, subValor);
            }
            if (retorno) {
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                JOptionPane.showMessageDialog(this, "Venda Finalizada com Sucesso\nNumero do pedido: " + idVenda + "\nData: " + formatador.format(dataAtual), "Messagem", JOptionPane.INFORMATION_MESSAGE);
                tCarrinho.setRowCount(0);
                tCliente.setRowCount(0);
                txtIdProduto.setText("");
                txtQuantidade.setText("");
                txtvalorTotal.setText("");

            }
        }
    }//GEN-LAST:event_btnFinalizarPedidoActionPerformed

    private void txtIdProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProdutoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdProdutoKeyTyped

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void btnSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarClienteActionPerformed

        if (txtCpf.getText().replace(".", "").replace("-", "").trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o CPF para localizar o cliente", "Erro", JOptionPane.OK_OPTION);
        } else {
            try {

                ArrayList<ClienteModel> listaCliente = VendaController.consultar(txtCpf.getText().replace(".", "").replace("-", "").trim());
                tblCliente.setModel(tCliente);

                tCliente.setRowCount(0);

                for (ClienteModel cli : listaCliente) {
                    tCliente.addRow(new Object[]{cli.getId(), cli.getNome(), cli.getCpf()});
                }
                txtCpf.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao realizar consulta!");
            }
            tblCliente.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblCliente.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblCliente.getColumnModel().getColumn(2).setPreferredWidth(60);

        }
    }//GEN-LAST:event_btnSelecionarClienteActionPerformed

    private void btnSelecionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarProdutoActionPerformed

        if (txtIdProduto.getText().trim().equals("") || txtQuantidade.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Informe o código do produto e a quantidade para consultar", "Erro", JOptionPane.OK_OPTION);
        }
        boolean retorno = validarRepeticaoTblCarrinho(Integer.parseInt(txtIdProduto.getText()));

        if (retorno) {
            ArrayList<ProdutoModel> listaProduto = VendaController.consultarProduto(txtIdProduto.getText());

            int quantidadeBanco = 0;

            for (ProdutoModel pro : listaProduto) {
                quantidadeBanco = pro.getQuantidade();
            }
            try {
                if (quantidadeBanco < Integer.parseInt(txtQuantidade.getText())) {
                    JOptionPane.showMessageDialog(this, "Saldo indisponível no Estoque!\nQuantidade Disponivel: " + quantidadeBanco, "Erro", JOptionPane.ERROR);
                } else {

                    int quantidade = Integer.parseInt(txtQuantidade.getText());

                    tblCarrinho.setModel(tCarrinho);

                    for (ProdutoModel prod : listaProduto) {
                        double subTotal = prod.getValor() * quantidade;
                        tCarrinho.addRow(new Object[]{prod.getIdProduto(), prod.getNome(), prod.getCategoria(), prod.getMarca(), quantidade, prod.getValor(), subTotal});
                    }
                    tblCarrinho.getColumnModel().getColumn(0).setPreferredWidth(50);
                    tblCarrinho.getColumnModel().getColumn(1).setPreferredWidth(150);
                    tblCarrinho.getColumnModel().getColumn(2).setPreferredWidth(150);
                    tblCarrinho.getColumnModel().getColumn(3).setPreferredWidth(150);
                    tblCarrinho.getColumnModel().getColumn(4).setPreferredWidth(60);
                    tblCarrinho.getColumnModel().getColumn(5).setPreferredWidth(60);
                    tblCarrinho.getColumnModel().getColumn(6).setPreferredWidth(60);

                    txtIdProduto.setText("");
                    txtQuantidade.setText("");
                    preencherValorTotal();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao realizar consulta!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Produto já adicionado no carrinho");
        }
    }//GEN-LAST:event_btnSelecionarProdutoActionPerformed

    public boolean validarRepeticaoTblCarrinho(int id) {
        boolean retorno = true;
        int idProduto = 0;
        for (int i = 0; i < tCarrinho.getRowCount(); i++) {
            idProduto = Integer.parseInt(tCarrinho.getValueAt(i, 0).toString());
            if (idProduto == id) {
                retorno = false;
                break;
            }
            retorno = true;
        }
        return retorno;
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        if (tblCarrinho.getSelectedRow() >= 0) {

            tCarrinho.removeRow(tblCarrinho.getSelectedRow());
            tblCarrinho.setModel(tCarrinho);
            preencherValorTotal();

        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para apagar", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        if (txtIdProduto.getText().trim().equals("") || txtQuantidade.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Informe a quantidade");
        } else {
            if (tblCarrinho.getSelectedRow() >= 0) {

                ArrayList<ProdutoModel> listaProduto = VendaController.consultarProduto(txtIdProduto.getText());
                int quantidadeBanco = 0;

                for (ProdutoModel pro : listaProduto) {
                    quantidadeBanco = pro.getQuantidade();
                }
                if (Integer.parseInt(txtQuantidade.getText().toString()) <= quantidadeBanco) {
                    int quantidade = Integer.parseInt(txtQuantidade.getText());
                    for (ProdutoModel prod : listaProduto) {

                        double subTotal = prod.getValor() * quantidade;
                        tCarrinho.setValueAt(txtQuantidade.getText(), tblCarrinho.getSelectedRow(), 4);
                        tCarrinho.setValueAt("" + subTotal, tblCarrinho.getSelectedRow(), 6);
                    }
                    preencherValorTotal();
                } else {
                    JOptionPane.showMessageDialog(this, "Quantidade indisponível no Estoque\n Quantidade Disponivel: " + quantidadeBanco, "Alerta", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma linha para alterar", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void preencherValorTotal() {

        float valorTotal = 0;
        for (int i = 0; i < tCarrinho.getRowCount(); i++) {
            double subValor = Double.parseDouble(tCarrinho.getValueAt(i, 6).toString());
            valorTotal += subValor;
        }
        txtvalorTotal.setText("" + valorTotal);
    }

    private void tblCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarrinhoMouseClicked
        txtIdProduto.setText(tblCarrinho.getValueAt(tblCarrinho.getSelectedRow(), 0).toString());
        txtQuantidade.setText(tblCarrinho.getValueAt(tblCarrinho.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_tblCarrinhoMouseClicked

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
            java.util.logging.Logger.getLogger(TeladeVendaView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeladeVendaView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeladeVendaView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeladeVendaView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeladeVendaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JButton btnSelecionarCliente;
    private javax.swing.JButton btnSelecionarProduto;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCarrinho;
    private javax.swing.JTable tblCliente;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtvalorTotal;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel DefaultTableModel(JTable tblCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
