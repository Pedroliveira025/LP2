import java.util.ArrayList;

class Conta {

    private String número;
    private String titular;
    private double saldo;

    public Conta(String número, String titular, double saldoInicial) {
        // número de conta negativo
        // saldo incial negativo
        this.número = número;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getNúmero() {
        return this.número;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void transferir(Conta destino, double valor) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public String extratoSimples() {
        return (
            "Titular: " +
            titular +
            "\n" +
            "Número: " +
            número +
            "\n" +
            "Saldo: " +
            saldo +
            "\n"
        );
    }
}

class Banco {

    private ArrayList<Conta> contas;

    Banco() {
        contas = new ArrayList<Conta>();
    }

    public void abrirConta(String número, String titular, double saldoInicial) {
        contas.add(new Conta(número, titular, saldoInicial));
    }

    public Conta buscar(String número) {
        for (int i = 0; i < contas.size(); ++i) {
            if (número.equals(contas.get(i).getNúmero())) {
                return contas.get(i);
            }
        }
        return null;
    }

    public void transferirEntre(
        String numOrigem,
        String numDestino,
        double valor
    ) {
        Conta origem = buscar(numOrigem);
        Conta destino = buscar(numDestino);

        origem.transferir(destino, valor);
    }

    public void extrato() {
        for (int i = 0; i < contas.size(); ++i) {
            System.out.println(contas.get(i).extratoSimples());
        }
    }
}

class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.abrirConta("1", "Pedro", 100);
        banco.abrirConta("2", "Marina", 100);

        banco.transferirEntre("1", "2", 100);

        banco.extrato();
    }
}
