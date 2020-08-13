package Controller;

import DAO.RelatorioDAO;
import Model.RelatorioModel;
import java.util.ArrayList;
import java.util.Date;

public class RelatorioController {

    public static ArrayList<RelatorioModel> consultarVenda(Date dataInicial, Date dataFinal) {
        RelatorioModel objRelatorio = new RelatorioModel();
        objRelatorio.setDataInicial(dataInicial);
        objRelatorio.setDataFinal(dataFinal);

        ArrayList<RelatorioModel> listaVenda = RelatorioDAO.consultarVendas(objRelatorio);

        return listaVenda;
    }
    
        public static ArrayList<RelatorioModel> consultarPedido(int id) {

        ArrayList<RelatorioModel> listaPedido = RelatorioDAO.consultarPedido(id);

        return listaPedido;

    }

}
