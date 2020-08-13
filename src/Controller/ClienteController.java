package Controller;

import DAO.ClienteDAO;
import Model.ClienteModel;
import java.util.ArrayList;
import java.util.Date;

public class ClienteController {

    public static boolean Inserir(String nome, String cpf, Date dataNascimento, String estadoCivil, String genero, String endereco, int numero, String bairro, String cidade, String uf, String cep, String telefone, String celular, String email) {

        ClienteModel objCliente = new ClienteModel();
        objCliente.setNome(nome);
        objCliente.setCpf(cpf);
        objCliente.setDataNascimento(dataNascimento);
        objCliente.setEstadoCivil(estadoCivil);
        objCliente.setGenero(genero);
        objCliente.setEndereco(endereco);
        objCliente.setNumero(numero);
        objCliente.setBairro(bairro);
        objCliente.setCidade(cidade);
        objCliente.setUf(uf);
        objCliente.setCep(cep);
        objCliente.setTelefone(telefone);
        objCliente.setCelular(celular);
        objCliente.setEmail(email);

        return ClienteDAO.salvar(objCliente);
    }

   public static boolean Alterar(String nome, String cpf, Date dataNascimento, String estadoCivil, String genero, String endereco, int numero, String bairro, String cidade, String uf, String cep, String telefone, String celular, String email, int id) throws ClassNotFoundException {
        ClienteModel objCliente = new ClienteModel();
        objCliente.setNome(nome);
        objCliente.setCpf(cpf);
        objCliente.setDataNascimento(dataNascimento);
        objCliente.setEstadoCivil(estadoCivil);
        objCliente.setGenero(genero);
        objCliente.setEndereco(endereco);
        objCliente.setNumero(numero);
        objCliente.setBairro(bairro);
        objCliente.setCidade(cidade);
        objCliente.setUf(uf);
        objCliente.setCep(cep);
        objCliente.setTelefone(telefone);
        objCliente.setCelular(celular);
        objCliente.setEmail(email);
        objCliente.setId(id);

        return ClienteDAO.Alterar(objCliente);
    }

    public static boolean Excluir(int id) throws ClassNotFoundException {
        ClienteModel objCliente = new ClienteModel();
        objCliente.setId(id);

        return ClienteDAO.Excluir(objCliente);
    }

    public static ArrayList<ClienteModel> consultar(int id) {

        ArrayList<ClienteModel> listaCliente = ClienteDAO.consultarCliente(id);

        return listaCliente;
    }

    public static ArrayList<ClienteModel> consultar(String nome, String cpf) {
        ArrayList<ClienteModel> listaCliente = ClienteDAO.consultarCliente(nome, cpf);

        return listaCliente;
    }

    public static ArrayList<ClienteModel> consultar() {

        ArrayList<ClienteModel> listaCliente = ClienteDAO.consultarCliente();

        return listaCliente;
    }

}
