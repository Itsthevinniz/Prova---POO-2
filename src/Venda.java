import java.time.LocalDate;


public class Venda {
    private String produto;
    private int qtd;
    private LocalDate data;

    public Venda(String produto, int qtd, LocalDate data) {
        this.produto = produto;
        this.qtd = qtd;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venda: Produto = " + produto + ", Quantidade = " + qtd + ", Data da venda = " + data;
    }

    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
}
