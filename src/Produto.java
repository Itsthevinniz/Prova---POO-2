public class Produto {
    private String nome;
    private String codigo;
    private double preco;
    private int qtd;

    public Produto(String nome, String codigo, double preco, int qtd) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "Produto: Nome = " + nome + ", Código = " + codigo + ", Preço = " + preco + ", Quantidade = " + qtd;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

}
