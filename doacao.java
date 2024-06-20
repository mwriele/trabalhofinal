public class Doacao {
    private String tipo;
    private int quantidade;
    private String detalhes;

    public Doacao(String tipo, int quantidade, String detalhes) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.detalhes = detalhes;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDetalhes() {
        return detalhes;
    }
}
