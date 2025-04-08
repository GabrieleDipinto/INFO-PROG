public interface DistributoreInterface {
    void mostraProdotti();
    void sceltaProdotto(int fila, int indice, Carta carta);
    void aggiungiProdotto(int fila, Prodotto p) throws Exception;
}