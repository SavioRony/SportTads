
package DAO;

import Model.RelatorioModel;
import Utils.GerenciadorConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RelatorioDAO {

    public static ArrayList<RelatorioModel> consultarVendas(RelatorioModel objRelatorio) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<RelatorioModel> listaVenda = new ArrayList<RelatorioModel>();

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select v.idVenda, c.nome, c.cpf,v.dt_hr_Venda, v.total from venda v\n"
                                                  + "inner join cliente c\n"
                                                  + "on v.idCliente = c.idCliente\n"
                                                  + "where v.dt_hr_Venda between ? and ?"
                                                  + "order by v.idVenda");

            instrucaoSQL.setDate(1, new java.sql.Date(objRelatorio.getDataInicial().getTime()));
            instrucaoSQL.setDate(2, new java.sql.Date(objRelatorio.getDataFinal().getTime()));
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                RelatorioModel vend = new RelatorioModel();
                vend.setIdVenda(rs.getInt("idVenda"));
                vend.setNomeCliente(rs.getString("nome"));
                vend.setCpf(rs.getString("cpf"));
                vend.setDataVenda(rs.getDate("dt_hr_venda"));
                vend.setValorTotal(rs.getDouble("total"));

                listaVenda.add(vend);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaVenda = null;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexaoUtil.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return listaVenda;
    }
    
        public static ArrayList<RelatorioModel> consultarPedido(int idVenda) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<RelatorioModel> listaPedido = new ArrayList<RelatorioModel>();

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select i.idVenda,v.dt_hr_Venda, p.nome , p.marca,i.quantidade, i.valorUnitario , i.subTotal, v.total  from item_venda i\n" +
                                                    "inner join produto p\n" +
                                                    "inner join venda v\n" +
                                                    "on i.idProduto = p.idProduto and v.idVenda = i.idVenda\n" +
                                                    "where v.idVenda = ?\n");

            instrucaoSQL.setInt(1, idVenda);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                RelatorioModel pedido = new RelatorioModel();
                pedido.setIdVenda(rs.getInt("idVenda"));
                pedido.setDataVenda(rs.getDate("dt_hr_Venda"));
                pedido.setNomeProduto(rs.getString("nome"));
                pedido.setMarca(rs.getString("marca"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedido.setValorUnitario(rs.getDouble("valorUnitario"));
                pedido.setSubTotal(rs.getDouble("subTotal"));
                pedido.setValorTotal(rs.getDouble("total"));

                listaPedido.add(pedido);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaPedido = null;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexaoUtil.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return listaPedido;
    }

}
