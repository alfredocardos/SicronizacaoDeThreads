package Run;

import Dominio.Banco;

public class ThreadConta_Test01 implements  Runnable {
    private final Banco banco = new Banco();

    public static void main(String[] args) {

        ThreadConta_Test01 Pessoa_1 = new ThreadConta_Test01();
        Thread t1 = new Thread(Pessoa_1, "Toretto");
        Thread t2 = new Thread(Pessoa_1, "Tarantino");
        t1.start();
        t2.start();


    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Saida(50);
            if (banco.getConCorrente() <= 0) {
                System.out.println("To liso");
            }

        }

    }


    //Regra de negocios
    private synchronized void Saida(int valor) {
        if (banco.getConCorrente() >= valor) {
            System.out.println(Thread.currentThread().getName() + "Tranferencia será autorizada");
            banco.saque(valor);
            System.out.println(Thread.currentThread().getName() + "Seu saldo altual é : " + banco.getConCorrente());
        } else {
            System.out.println("Valor inferior: " + banco.getConCorrente());
        }
    }


}
