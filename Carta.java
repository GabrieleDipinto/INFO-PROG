public class Carta {
    private String intestatario;
    private String numeroCarta;
    private double saldo;

    public Carta(String intestatario, String numeroCarta) {
        this.intestatario = intestatario;
        this.numeroCarta = numeroCarta;
        this.saldo = 250.0;
    }

    public boolean paga(double importo) {
        if (saldo >= importo) {
            saldo -= importo;
            System.out.println("Pagamento effettuato con carta. Saldo residuo: " + saldo + "€");
            return true;
        } else {
            System.out.println("Saldo insufficiente.");
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String toString() {
        return intestatario + " - Carta: " + numeroCarta + " - Saldo: " + saldo + "€";
    }
}