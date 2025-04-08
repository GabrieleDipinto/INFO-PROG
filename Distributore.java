import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Distributore implements DistributoreInterface {
    private HashMap<Integer, ArrayList<Prodotto>> prodotti;
    private double saldo;
    private final double[] moneteAccettate = {0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20};

    public Distributore() {
        prodotti = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            prodotti.put(i, new ArrayList<>());
        }
        saldo = 0;
    }

    public void aggiungiProdotto(int fila, Prodotto p) throws Exception {
        if (!prodotti.containsKey(fila)) {
            throw new Exception("Fila non valida.");
        }
        prodotti.get(fila).add(p);
    }

    public void mostraProdotti() {
        for (int fila : prodotti.keySet()) {
            System.out.println("Fila " + fila + ":");
            ArrayList<Prodotto> lista = prodotti.get(fila);
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("  [" + i + "] " + lista.get(i));
            }
        }
    }

    public void sceltaProdotto(int fila, int indice, Carta carta) {
        if (!prodotti.containsKey(fila)) {
            System.out.println("Fila non valida.");
            return;
        }

        ArrayList<Prodotto> lista = prodotti.get(fila);
        if (indice < 0 || indice >= lista.size()) {
            System.out.println("Indice non valido.");
            return;
        }

        Prodotto scelto = lista.get(indice);
        double prezzo = scelto.getPrezzo();
        System.out.println("Hai scelto: " + scelto.getNome() + " - Prezzo: " + prezzo + "€");

        Scanner in = new Scanner(System.in);
        int metodo = 0;
        while (metodo != 1 && metodo != 2) {
            System.out.println("Metodo di pagamento:\n1) Contanti\n2) Carta");
            metodo = in.nextInt();
        }

        if (metodo == 1) {
            saldo = 0;
            while (saldo < prezzo) {
                inserisciMoneta();
            }
            System.out.println("Hai acquistato: " + scelto.getNome());
            if (saldo > prezzo) {
                restituisciResto(prezzo);
            }
        } else {
            if (carta.paga(prezzo)) {
                System.out.println("Hai acquistato: " + scelto.getNome() + " con carta.");
            } else {
                System.out.println("Pagamento rifiutato.");
            }
        }
    }

    private void inserisciMoneta() {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci una moneta o banconota (0.05€, 0.10€, 0.20€, 0.50€, 1€, 2€, 5€, 10€, 20€):");
        double moneta = in.nextDouble();
        for (double m : moneteAccettate) {
            if (moneta == m) {
                saldo += moneta;
                System.out.println("Saldo attuale: " + saldo + "€");
                return;
            }
        }
        System.out.println("Moneta non valida. Riprova.");
    }

    private void restituisciResto(double prezzo) {
        double resto = saldo - prezzo;
        System.out.println("Resto: " + String.format("%.2f", resto) + "€");

        double[] monete = {20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05};
        for (double m : monete) {
            while (resto >= m - 0.001) {
                System.out.println("Restituisci " + m + "€");
                resto -= m;
                resto = Math.round(resto * 100.0) / 100.0;
            }
        }
        saldo = 0;
    }
}