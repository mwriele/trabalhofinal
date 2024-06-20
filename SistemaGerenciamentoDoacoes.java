import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaGerenciamentoDoacoes {
    private List<Doacao> doacoes;

    public SistemaGerenciamentoDoacoes() {
        this.doacoes = new ArrayList<>();
    }

    public void adicionarDoacao(Doacao doacao) {
        doacoes.add(doacao);
    }

    public int calcularTotalDoacoes() {
        int total = 0;
        for (Doacao doacao : doacoes) {
            total += doacao.getQuantidade();
        }
        return total;
    }

    public void salvarDoacoes(String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Doacao doacao : doacoes) {
                writer.write(doacao.getTipo() + "," + doacao.getQuantidade() + "," + doacao.getDetalhes());
                writer.newLine();
            }
        }
    }

    public void carregarDoacoes(String arquivo) throws IOException {
        doacoes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String tipo = partes[0];
                int quantidade = Integer.parseInt(partes[1]);
                String detalhes = partes[2];
                Doacao doacao = new Doacao(tipo, quantidade, detalhes);
                doacoes.add(doacao);
            }
        }
    }
}
