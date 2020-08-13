package Model;

public class ProdutoModel {

    private int idProduto;
    private String nome;
    private double valor;
    private String categoria;
    private String marca;
    private int quantidade;
    
  
    
    public int validarQuantidade(int qtd) {
    
        quantidade=-qtd;  
        return quantidade;
     
    }

    public ProdutoModel() {
    }

    public ProdutoModel(int idProduto, String nome, double valor, String categoria, String marca, int quantidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
