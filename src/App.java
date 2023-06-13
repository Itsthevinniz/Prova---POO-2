import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        List<Produto> listaProdutos = new ArrayList<>();
        List<Venda> listaVendas = new ArrayList<>();
    

    do{
        System.out.println("1 - Incluir produto.");
        System.out.println("2 - Consultar produto.");
        System.out.println("3 - Listagem de produtos.");
        System.out.println("4 - Vendas por período.");
        System.out.println("5 - Realizar venda.");

        opcao = sc.nextInt();
        sc.nextLine();

        if (opcao == 1){
            System.out.println("Informe o nome do produto:");
            String nome = sc.next();
            System.out.println("Digite o código do produto:");
            String codigo = sc.next();
            System.out.println("Qual o preço do produto indicado?");
            double preco = sc.nextDouble();
            System.out.println("Informe quantas unidades desse produto serão cadastradas:");
            int qtd = sc.nextInt();

            listaProdutos.add(new Produto(nome, codigo, preco, qtd));

            System.out.println("Produto cadastrado com sucesso.");
            voltarMenu(sc);
        }

        if (opcao == 2){
            System.out.println("Informe o código do produto desejado:");
            String novocodigo = sc.next();

            List<Produto> novalistaProdutos = listaProdutos.stream()
            .filter((p -> p .getCodigo().contains(novocodigo))).collect(Collectors.toList());;

            if(novalistaProdutos.size() == 0){
                System.out.println("Produto não encontrado.");
            }
            else{
                for (Produto produto : novalistaProdutos) {
                    System.out.println(produto);
                }
            }
        }

        if (opcao == 3){
            for (Produto produto : listaProdutos) {
                    System.out.println(produto);
            }
            DoubleSummaryStatistics valores = listaProdutos.stream()
            .collect(Collectors.summarizingDouble(Produto::getPreco));
            System.out.println("Média: " + valores.getAverage());
            System.out.println("Máximo: " + valores.getMax());
            System.out.println("Mínimo: " + valores.getMin());
        }

        if (opcao == 4){
            System.out.println("Informe a primeira data do período:");
            String datainicial = sc.next();

            System.out.println("Informe a segunda data do período:");
            String datafinal = sc.next();

            LocalDate periodoinicial = LocalDate.parse(datainicial, df);
            LocalDate periodofinal = LocalDate.parse(datafinal, df);

            double total = 0.0;
            int qtdv = 0;
            double mediav = 0.0;


            for (Venda venda : listaVendas) {
                if(venda.getData().compareTo(periodoinicial) >= 0 && venda.getData().compareTo(periodofinal) < 1){
                    System.out.println(venda);
                    total += venda.getProduto().getPreco() * venda.getQtd();
                    mediav += total;
                    qtdv ++;
                    System.out.println("O valor total é: " + total);
                    
                }
            }
            double mediavendas = mediav/total;
            System.out.println("A média total é: " + mediavendas);
        }
        
        if (opcao == 5){
            System.out.println("Informe o código do produto:");
            String codigo = sc.next();

            List<Produto> novaLista = listaProdutos.stream()
            .filter(v -> v.getCodigo().equals(codigo)).collect(Collectors.toList());

            if(novaLista.size() == 0){
                System.out.println("Produto não localizado.");
            }
            else{
                System.out.println("Informe a data da venda:");
                String datavenda = sc.next();
                LocalDate dt = LocalDate.parse(datavenda, df);
                

                System.out.println("Informe quantas unidades foram vendidas.");
                int qtdVendida = sc.nextInt();
                Produto produto = novaLista.get(0);
                Venda venda = new Venda(produto, qtdVendida, dt);
                if(produto.getQtd() < qtdVendida){
                    System.out.println("Quantidade insuficiente no estoque:");
                }
                else{
                    listaVendas.add(venda);
                    produto.setQtd(produto.getQtd() - qtdVendida);
                    System.out.println("Venda finalizada!");
                }
            }

        }

    }while(opcao != 0);
       System.out.println("Programa finalizado!");
}

    private static void voltarMenu(Scanner sc) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        sc.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}
