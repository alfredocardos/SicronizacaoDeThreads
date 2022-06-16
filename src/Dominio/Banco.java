package Dominio;

public class Banco {
    private double ConCorrente = 1200;


public void saque (double valor) {
    this.ConCorrente = this.ConCorrente - valor;
}

    public double getConCorrente() {
        return ConCorrente;
    }
}
