package Model;

import java.util.Date;

public class VendaModel {

    private int idVenda;
    private int idCliente;
    private int idProduto;
    private double total;
    private int quantidade;
    private Double valorUnitario;
    private Double subTotal;
    private Date dataAtual;

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public VendaModel(){}

    public VendaModel(int idVenda, int idCliente, int idProduto, double total, int quantidade, Double valorUnitario, Double subTotal, Date dataAtual) {
        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.total = total;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.subTotal = subTotal;
        this.dataAtual = dataAtual;
    }
    

    
    public VendaModel(int idCliente, double total) {
        this.idCliente = idCliente;
        this.total = total;
    }

    
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
