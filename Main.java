import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaGerenciamentoDoacoes sistema = new SistemaGerenciamentoDoacoes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Doação");
            System.out.println("2. Calcular Total de Doações");
            System.out.println("3. Salvar Doações");
            System.out.println("4. Carregar Doações");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    System.out.print("Digite o tipo de doação: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Digite os detalhes: ");
                    String detalhes = scanner.nextLine();
                    Doacao doacao = new Doacao(tipo, quantidade, detalhes);
                    sistema.adicionarDoacao(doacao);
                    break;
                case 2:
                    int total = sistema.calcularTotalDoacoes();
                    System.out.println("Total de doações: " + total);
                    break;
                case 3:
                    System.out.print("Digite o nome do arquivo para salvar: ");
                    String arquivoSalvar = scanner.nextLine();
                    try {
                        sistema.salvarDoacoes(arquivoSalvar);
                        System.out.println("Doações salvas com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar doações: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do arquivo para carregar: ");
                    String arquivoCarregar = scanner.nextLine();
                    try {
                        sistema.carregarDoacoes(arquivoCarregar);
                        System.out.println("Doações carregadas com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao carregar doações: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
