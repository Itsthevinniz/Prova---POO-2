import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Venda {
    private Produto produto;
    private int qtd;
    private LocalDate data;

    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Venda(Produto produto, int qtd, LocalDate data) {
        this.produto = produto;
        this.qtd = qtd;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venda: Produto = " + produto + ", Quantidade = " + qtd + ", Data da venda = " + data.format(df);
    }


    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
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
