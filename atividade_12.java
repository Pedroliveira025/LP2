import java.util.ArrayList;

// para valores menores ou iguais a zero
class ValorInválidoException extends Exception {
    public ValorInválidoException(String mensagem) {
        super(mensagem);
    }
}

// para saques ou transferências acima do saldo
class SaldoInsuficiênteExpection extends Exception {
    public SaldoInsuficiênteExpection(String mensagem) {
        super(mensagem);
    }
}

// para operações inválidas (como transferir para a mesma conta)
class OperaçãoNãoPermitidaException extends Exception {
    public OperaçãoNãoPermitidaException(String mensagem) {
        super(mensagem);
    }
}

class Conta {

    private String número;
    private String titular;
    private double saldo;
    private double limiteDiário;

    public Conta(String número, String titular, double saldoInicial) throws ValorInválidoException {
        if (saldoInicial < 0) {
            throw new ValorInválidoException("Saldo inicial não pode ser negativo!");
        }

        this.número = número;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.limiteDiário = 500;
    }

    public String getNúmero() {
        return this.número;
    }

    public void depositar(double valor) throws ValorInválidoException {
        if (valor <= 0) {
            throw new ValorInválidoException("Valor de deposito deve ser maior que zero!");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficiênteExpection, OperaçãoNãoPermitidaException {
        if (valor > this.saldo) {
            throw new SaldoInsuficiênteExpection("Saldo insuficiênte!");
        }

        if (valor > this.limiteDiário) {
            throw new OperaçãoNãoPermitidaException("Limite diário excedido!");
        }

        this.saldo -= valor;
        this.limiteDiário -= valor;
    }

    public void transferir(Conta destino, double valor) {
        try {
            this.sacar(valor);
            destino.depositar(valor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String informações() {
        return (
            "Titular: " + titular + "\n" +
            "Número: " + número + "\n" +
            "Saldo: " + saldo
        );
    }

    //public String extratoSimples() {}
}

class Banco {

    private ArrayList<Conta> contas;

    Banco() {
        contas = new ArrayList<Conta>();
    }

    public void abrirConta(String número, String titular, double saldoInicial) {
        try {
            contas.add(new Conta(número, titular, saldoInicial));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Conta buscar(String número) throws OperaçãoNãoPermitidaException {
        Conta conta = null;

        for (int i = 0; i < contas.size(); ++i) {
            if (número.equals(contas.get(i).getNúmero())) {
                conta = contas.get(i);
            }
        }

        if (conta == null) {
            throw new OperaçãoNãoPermitidaException("Conta inexistênte!");
        }

        return conta;
    }

    public void transferirEntre(String numOrigem, String numDestino, double valor) {

        try {
            Conta origem = buscar(numOrigem);
            Conta destino = buscar(numDestino);
            origem.transferir(destino, valor);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void informarContas() {
        for (int i = 0; i < contas.size(); ++i) {
            System.out.println(contas.get(i).informações());
        }
    }
}

class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.abrirConta("1", "Pedro", 100);
        banco.abrirConta("2", "Marina", 100);

        banco.transferirEntre("1", "2", 100);

        banco.informarContas();
    }
}
