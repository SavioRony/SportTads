
package DAO;

import Model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Utils.GerenciadorConexaoUtil;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




public class ProdutoDAO {
    
    /**
     * Método utilizado para inserir os dados de cadastro do produto no banco de dados.
     * @param sa
     * @return <b>TRUE</b> caso a gravação seja efetivada
     * {@link Controller.ProdutoController#Inserir(java.lang.String, java.lang.Double, java.lang.String, java.lang.String, int) }
     */
    public static boolean salvarBD(ProdutoModel sa) 
    {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexaoUtil.abrirConexao();
        
            instrucaoSQL = conexao.prepareStatement("INSERT INTO produto (nome,valor,categoria,marca,quantidade) VALUES(?,?,?,?,?)", 
                                                                                Statement.RETURN_GENERATED_KEYS);
            instrucaoSQL.setString(1, sa.getNome());
            instrucaoSQL.setDouble(2, sa.getValor());
            instrucaoSQL.setString(3, sa.getCategoria());
            instrucaoSQL.setString(4, sa.getMarca());
            instrucaoSQL.setInt(5, sa.getQuantidade());
            
           int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys(); 
                if (generatedKeys.next()) {
                        sa.setIdProduto(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Falha ao obter o ID do cliente.");
                }
            }
            else{
                retorno = false;
            }
            
        } catch ( SQLException |  ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
           
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                GerenciadorConexaoUtil.fecharConexao();
           
              } catch (SQLException ex) {
             }
        }
        
        return retorno;
        }
   
    
    public static ArrayList<ProdutoModel> Pesquisar(String nome, String id) 
    {
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
                
        ArrayList<ProdutoModel> listaProdutos = new ArrayList<ProdutoModel>();               
       
                 
        try {
          
            conexao = GerenciadorConexaoUtil.abrirConexao();
            
            if(!nome.trim().equals("")){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE nome LIKE ?");
                instrucaoSQL.setString(1,"%"+nome+"%");
            }
            if(!id.trim().equals("")){
                instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE idProduto = ?");
                instrucaoSQL.setInt(1,Integer.parseInt(id));
            }
                       
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                
                ProdutoModel produtos = new ProdutoModel();
                produtos.setIdProduto(rs.getInt("idProduto"));    
                produtos.setNome(rs.getString("nome"));
                produtos.setCategoria(rs.getString("categoria"));
                produtos.setMarca(rs.getString("marca"));
                produtos.setQuantidade(rs.getInt("quantidade"));
                produtos.setValor(rs.getDouble("valor"));
                
                listaProdutos.add(produtos);                                              
                        
            }                                                     
            
        } catch ( SQLException |  ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
            
        } finally{
            
            
            try {
                    if(rs!=null)
                         rs.close();                 
                      
                    if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                GerenciadorConexaoUtil.fecharConexao();
                
                
              } catch (SQLException ex) {
             }
        }
        return listaProdutos;
          
        }
      
    public static ArrayList<ProdutoModel> consultaProdutos(){
        
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
        
        ArrayList<ProdutoModel> listaProdutos = new ArrayList<ProdutoModel>();               
       
                 
        try {
          
            conexao = GerenciadorConexaoUtil.abrirConexao();
          
            instrucaoSQL = conexao.prepareStatement("SELECT * FROM produto;");
            
            rs = instrucaoSQL.executeQuery();
            
            while(rs.next()){
                
                ProdutoModel produtos = new ProdutoModel();
                produtos.setIdProduto(rs.getInt("idProduto"));    
                produtos.setNome(rs.getString("nome"));
                produtos.setCategoria(rs.getString("categoria"));
                produtos.setMarca(rs.getString("marca"));
                produtos.setQuantidade(rs.getInt("quantidade"));
                produtos.setValor(rs.getDouble("valor"));
                
                listaProdutos.add(produtos);                                              
                        
            }                                                     
            
        } catch ( SQLException |  ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            listaProdutos = null;
            
        } finally{
            
            
            try {
                    if(rs!=null)
                         rs.close();                 
                      
                    if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                GerenciadorConexaoUtil.fecharConexao();
                
                
              } catch (SQLException ex) {
             }
        }
        return listaProdutos;
            
    
    }
 
    public static boolean ExcLuir(int id) 
    {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexaoUtil.abrirConexao();
                   
            instrucaoSQL = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            
            instrucaoSQL.setInt(1, id);
           
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0) {
                retorno = true;
            }
            else{
                retorno = false;
            }
         
        } catch ( SQLException |  ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally{
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                GerenciadorConexaoUtil.fecharConexao();
                            
              } catch (SQLException ex) {
             }
        }       
        return retorno;
        
    }

  public static boolean Alterar(ProdutoModel sa) 
    {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;
                
        try {
            
            conexao = GerenciadorConexaoUtil.abrirConexao();
                 
            instrucaoSQL = conexao.prepareStatement("UPDATE produto SET nome=?,valor=?,categoria=?,marca=?,quantidade=? WHERE idProduto=?");
            
            
            instrucaoSQL.setString(1, sa.getNome());
            instrucaoSQL.setDouble(2,sa.getValor());
            instrucaoSQL.setString(3, sa.getCategoria());
            instrucaoSQL.setString(4,sa.getMarca());
            instrucaoSQL.setInt(5,sa.getQuantidade());
            instrucaoSQL.setInt(6,sa.getIdProduto());
            
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0)
            {
                retorno = true;
                
               
                }
            
            else{
                retorno = false;
          }
      
        } catch ( SQLException |  ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
            
        } finally{
            
            try {
                if(instrucaoSQL!=null)
                    instrucaoSQL.close();
                
                GerenciadorConexaoUtil.fecharConexao();
                
                
              } catch (SQLException ex) {
              }
}
           return retorno;
    
    }    
}
    
   
    