import java.util.Scanner;

public class MainDistributore {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Carta carta = new Carta("Mario Rossi", "1234-5678-9012");


        DistributoreInterface distributore = new Distributore();


        distributore.aggiungiProdotto(1, new Cibo("Patatine", 1.5));
        distributore.aggiungiProdotto(1, new Cibo("Taralli", 1.2));
        distributore.aggiungiProdotto(2, new Cibo("Croissant", 1.75));
        distributore.aggiungiProdotto(2, new Cibo("Mandorle", 1.5));
        distributore.aggiungiProdotto(3, new Cibo("The al limone", 2.0));
        distributore.aggiungiProdotto(3, new Bevanda("CocaCola", 2.5));
        distributore.aggiungiProdotto(4, new Bevanda("Fanta", 1.8));
        distributore.aggiungiProdotto(4, new Cibo("Acqua minerale", 1.20));



        int fila, prodotto;
        do {
            System.out.println("----------------------------------");
            distributore.mostraProdotti();
            System.out.println("Inserisci numero fila (0 per uscire): ");
            fila = in.nextInt();
            if (fila == 0) break;

            System.out.println("Inserisci numero prodotto nella fila: ");
            prodotto = in.nextInt();

            distributore.sceltaProdotto(fila, prodotto, carta);
        } while (true);

        System.out.println("Programma terminato.");
    }
}