
package DAO;

import Model.ClienteModel;
import Model.ProdutoModel;
import Model.VendaModel;
import Utils.GerenciadorConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VendaDAO {

    VendaModel vend;

    public static ArrayList<ClienteModel> consultarCliente(String cpf) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ClienteModel> listaCliente = new ArrayList<ClienteModel>();

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");
            instrucaoSQL.setString(1, cpf);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                ClienteModel cli = new ClienteModel();
                cli.setId(rs.getInt("idCliente"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));

                listaCliente.add(cli);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaCliente = null;
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

        return listaCliente;
    }

    public static ArrayList<ProdutoModel> consultarProduto(String id) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ProdutoModel> listaProdutos = new ArrayList<ProdutoModel>();
        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE idProduto = ?");
            instrucaoSQL.setInt(1, Integer.parseInt(id));

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                ProdutoModel produtos = new ProdutoModel();
                produtos.setIdProduto(rs.getInt("idProduto"));
                produtos.setNome(rs.getString("nome"));
                produtos.setCategoria(rs.getString("categoria"));
                produtos.setMarca(rs.getString("marca"));
                produtos.setQuantidade(rs.getInt("quantidade"));
                produtos.setValor(rs.getDouble("valor"));

                listaProdutos.add(produtos);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;

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
        return listaProdutos;

    }

    public static int salvarVenda(VendaModel vend) {
        int retorno = -1;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("INSERT INTO venda (idcliente,total,dt_hr_Venda) VALUES(?,?,??)", Statement.RETURN_GENERATED_KEYS);
            instrucaoSQL.setInt(1, vend.getIdCliente());
            instrucaoSQL.setDouble(2, vend.getTotal());
            instrucaoSQL.setDate(3, new java.sql.Date(vend.getDataAtual().getTime()));
            instrucaoSQL.setTime(4, new java.sql.Time(vend.getDataAtual().getTime()));

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {
                    vend.setIdVenda(generatedKeys.getInt(1));
                    retorno = vend.getIdVenda();
                } else {
                    throw new SQLException("Falha ao obter o ID de venda.");
                }

            } else {
                retorno = -1;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = -1;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexaoUtil.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }

    public static boolean salvarItemVenda(VendaModel vend) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("INSERT INTO item_venda (idVenda,idProduto,quantidade,valorUnitario,subTotal) VALUES(?,?,?,?,?)");
            instrucaoSQL.setInt(1, vend.getIdVenda());
            instrucaoSQL.setInt(2, vend.getIdProduto());
            instrucaoSQL.setInt(3, vend.getQuantidade());
            instrucaoSQL.setDouble(4, vend.getValorUnitario());
            instrucaoSQL.setDouble(5, vend.getSubTotal());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            //linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexaoUtil.fecharConexao();

            } catch (SQLException ex) {
            }
        }

        return retorno;
    }
}
