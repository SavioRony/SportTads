
package Controller;

import DAO.ProdutoDAO;
import Model.ProdutoModel;
import java.util.ArrayList;


public class ProdutoController {

    /**
     * Método utilizado para receber os dados que usuário digitar e enviar para
     * gravar no bancos de dados.
     *
     * @param iNome
     * @param ivalor
     * @param icategoria
     * @param imarca
     * @param iquantidade
     * @return TRUE caso a gravação no banco de dados seja efetivada senão
     * retornar falso. {@link DAO.ProdutoDAO#salvarBD(Model.ProdutoModel) }
     */
    public static boolean Inserir(String iNome, Double ivalor, String icategoria, String imarca, int iquantidade) {

        ProdutoModel ent = new ProdutoModel();
        ent.setNome(iNome);
        ent.setValor(ivalor);
        ent.setCategoria(icategoria);
        ent.setMarca(imarca);
        ent.setQuantidade(iquantidade);

        boolean retorno = ProdutoDAO.salvarBD(ent);

        return retorno;

    }

    /**
     * Método utilizado para receber os parametros que usuário digitar e enviar
     * para gravar no bancos de dados para retorna os valores para view.
     *
     * @param id
     * @param nome
     * @return Arraylist contendo os dados do produtos. 
     * {@link DAO.ProdutoDAO#Pesquisar(nome, id) }
     */
    public static ArrayList<ProdutoModel> Pesquisar(String nome, String id) {

        ArrayList<ProdutoModel> listaProdutos = ProdutoDAO.Pesquisar(nome, id);
        return listaProdutos;

    }

    /**
     * Método utilizado para receber o id do produto que usuário seleciona e enviar
     * para excluir no bancos de dados.
     *
     * @param id
     * @return TRUE caso exclua o registro no banco de dados senão
     * retornar falso. {@link DAO.ProdutoDAO#ExcLuir(id) }
     */
    public static boolean Excluir(int id) {

        ProdutoModel ent = new ProdutoModel();
        ent.setIdProduto(id);

        boolean retorno = ProdutoDAO.ExcLuir(id);

        return retorno;
    }
    /**
     * Método utilizado para receber os parametros que o cliente digitou na view produto e enviar 
     * para o banco de dados para ser alterado.
     *
     * @param id
     * @return TRUE caso altere com sucesso o registro no banco de dados senão
     * retornar false. {@link DAO.ProdutoDAO#Alterar(ent) }
     */
    public static boolean Alterar(String nNome, double vValor, String cCategoria, String mMarca, int Qquantidade, int idProduto) {

        ProdutoModel ent = new ProdutoModel();

        ent.setNome(nNome);
        ent.setValor(vValor);
        ent.setCategoria(cCategoria);
        ent.setMarca(mMarca);
        ent.setQuantidade(Qquantidade);
        ent.setIdProduto(idProduto);

        return DAO.ProdutoDAO.Alterar(ent);
    }

};
