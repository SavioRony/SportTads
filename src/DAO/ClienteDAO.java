package DAO;

import Model.ClienteModel;
import Utils.GerenciadorConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {

    public static boolean salvar(ClienteModel cli) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("INSERT INTO cliente (nome,cpf,dtNascimento,estadoCivil,genero,endereco,numero,bairro,cidade,uf,cep,telefone,celular,email) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, cli.getNome());
            instrucaoSQL.setString(2, cli.getCpf());
            instrucaoSQL.setDate(3, new java.sql.Date(cli.getDataNascimento().getTime()));
            instrucaoSQL.setString(4, cli.getEstadoCivil());
            instrucaoSQL.setString(5, cli.getGenero());
            instrucaoSQL.setString(6, cli.getEndereco());
            instrucaoSQL.setInt(7, cli.getNumero());
            instrucaoSQL.setString(8, cli.getBairro());
            instrucaoSQL.setString(9, cli.getCidade());
            instrucaoSQL.setString(10, cli.getUf());
            instrucaoSQL.setString(11, cli.getCep());
            instrucaoSQL.setString(12, cli.getTelefone());
            instrucaoSQL.setString(13, cli.getCelular());
            instrucaoSQL.setString(14, cli.getEmail());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cli.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o Codigo do computador");
                }

            } else {
                retorno = false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique se o CPF está correto!");
            retorno = false;
        } finally {
            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                GerenciadorConexaoUtil.fecharConexao();
            } catch (SQLException ex) {
                System.out.println("Erro ao tenta fecha a conexão e instrucaoSQL!");
            }
        }
        return retorno;
    }

    public static boolean Alterar(ClienteModel cli) throws ClassNotFoundException {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, dtNascimento = ?, estadoCivil = ?, genero = ?,endereco = ?, numero = ?, bairro = ?, cidade = ?, uf = ?,cep = ?, telefone = ?, celular = ?, email = ? WHERE idCliente = ?");

            instrucaoSQL.setString(1, cli.getNome());
            instrucaoSQL.setString(2, cli.getCpf());
            instrucaoSQL.setDate(3, new java.sql.Date(cli.getDataNascimento().getTime()));
            instrucaoSQL.setString(4, cli.getEstadoCivil());
            instrucaoSQL.setString(5, cli.getGenero());
            instrucaoSQL.setString(6, cli.getEndereco());
            instrucaoSQL.setInt(7, cli.getNumero());
            instrucaoSQL.setString(8, cli.getBairro());
            instrucaoSQL.setString(9, cli.getCidade());
            instrucaoSQL.setString(10, cli.getUf());
            instrucaoSQL.setString(11, cli.getCep());
            instrucaoSQL.setString(12, cli.getTelefone());
            instrucaoSQL.setString(13, cli.getCelular());
            instrucaoSQL.setString(14, cli.getEmail());
            instrucaoSQL.setInt(15, cli.getId());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

    public static boolean Excluir(ClienteModel cli) throws ClassNotFoundException {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
            instrucaoSQL.setInt(1, cli.getId());

            int linhasAfetadas = instrucaoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

    public static ArrayList<ClienteModel> consultarCliente() {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ClienteModel> listaCliente = new ArrayList<ClienteModel>();

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente;");
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                ClienteModel cli = new ClienteModel();
                cli.setId(rs.getInt("idCliente"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setDataNascimento(rs.getDate("dtNascimento"));
                cli.setEstadoCivil(rs.getString("estadoCivil"));
                cli.setGenero(rs.getString("genero"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUf(rs.getString("uf"));
                cli.setCep(rs.getString("cep"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setCelular(rs.getString("celular"));
                cli.setEmail(rs.getString("email"));

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

    public static ArrayList<ClienteModel> consultarCliente(String nome, String cpf) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ClienteModel> listaCliente = new ArrayList<ClienteModel>();

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();

            if (!nome.trim().equals("")) {
                
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ?");
                instrucaoSQL.setString(1, "%"+ nome +"%");
            }
            if(!cpf.trim().equals("")){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");
                instrucaoSQL.setString(1, cpf);
            }

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                ClienteModel cli = new ClienteModel();
                cli.setId(rs.getInt("idCliente"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setDataNascimento(rs.getDate("dtNascimento"));
                cli.setEstadoCivil(rs.getString("estadoCivil"));
                cli.setGenero(rs.getString("genero"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUf(rs.getString("uf"));
                cli.setCep(rs.getString("cep"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setCelular(rs.getString("celular"));
                cli.setEmail(rs.getString("email"));

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

    public static ArrayList<ClienteModel> consultarCliente(int id) {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        ArrayList<ClienteModel> listaCliente = new ArrayList<ClienteModel>();

        try {

            conexao = GerenciadorConexaoUtil.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE idCliente = ? ");
            instrucaoSQL.setInt(1, id);

            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                ClienteModel cli = new ClienteModel();
                cli.setId(rs.getInt("idCliente"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setDataNascimento(rs.getDate("dtNascimento"));
                cli.setEstadoCivil(rs.getString("estadoCivil"));
                cli.setGenero(rs.getString("genero"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setUf(rs.getString("uf"));
                cli.setCep(rs.getString("cep"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setCelular(rs.getString("celular"));
                cli.setEmail(rs.getString("email"));

                listaCliente.add(cli);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());

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
}
