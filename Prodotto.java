public class Prodotto {
    protected String nome;
    protected double prezzo;
    protected TipoProdotto tipo;

    public Prodotto(String nome, double prezzo, TipoProdotto tipo) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public TipoProdotto getTipo() {
        return tipo;
    }

    public String toString() {
        return nome + " - " + prezzo + "€ (" + tipo + ")";
    }
}