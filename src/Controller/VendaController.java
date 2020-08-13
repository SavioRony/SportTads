
package Controller;

import Model.ClienteModel;
import java.util.ArrayList;
import Model.VendaModel;
import DAO.VendaDAO;
import Model.ProdutoModel;
import java.util.Calendar;
import java.util.Date;

public class VendaController {

    public static ArrayList<ClienteModel> consultar(String cpf) {
        ArrayList<ClienteModel> listaCliente = VendaDAO.consultarCliente(cpf);

        return listaCliente;
    }

    public static ArrayList<ProdutoModel> consultarProduto(String id) {

        ArrayList<ProdutoModel> listaProdutos = VendaDAO.consultarProduto(id);

        return listaProdutos;

    }

    public static int Venda(int idCliente, double valorTotal, Date dataAtual) {

        VendaModel vend = new VendaModel();
        vend.setIdCliente(idCliente);
        vend.setTotal(valorTotal);
        vend.setDataAtual(dataAtual);

        int retorno = VendaDAO.salvarVenda(vend);

        return retorno;

    }

    public static boolean ItemVenda(int idVenda,int idProduto, int quantidade, double valorUnitario, double subValor) {

        VendaModel vend = new VendaModel();
        vend.setIdVenda(idVenda);
        vend.setIdProduto(idProduto);
        vend.setQuantidade(quantidade);
        vend.setSubTotal(subValor);
        vend.setValorUnitario(valorUnitario);

        boolean retorno = VendaDAO.salvarItemVenda(vend);

        return retorno;

    }

}
