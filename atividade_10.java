interface DispositivoEletrônico {
    void ligar();

    void desligar();

    void status();
}

class Smartphone implements DispositivoEletrônico {

    private String marca;

    private String modelo;

    private boolean ligado;

    public Smartphone(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        ligado = false;
    }

    public void ligar() {
        System.out.println("Ligando o Smartphone " + marca + " " + modelo);
        ligado = true;
    }

    public void desligar() {
        System.out.println("Desligando o Smartphone " + marca + " " + modelo);
        ligado = false;
    }

    public void status() {
        System.out.print("Status do Smartphone : ");
        if (ligado == true) {
            System.out.println("Ligado");
        } else {
            System.out.println("Desligado");
        }
    }
}

class SmartTV implements DispositivoEletrônico {

    private String marca;

    private int tamanho;

    private boolean ligado;

    public SmartTV(String marca, int tamanho) {
        this.marca = marca;
        this.tamanho = tamanho;
        ligado = false;
    }

    public void ligar() {
        System.out.println(
            "Ligando a SmartTV " + marca + " " + tamanho + " polegadas"
        );
        ligado = true;
    }

    public void desligar() {
        System.out.println(
            "Desligando a SmartTV " + marca + " " + tamanho + " polegadas"
        );
        ligado = false;
    }

    public void status() {
        System.out.print("Status da SmartTV : ");
        if (ligado == true) {
            System.out.println("Ligado");
        } else {
            System.out.println("Desligado");
        }
    }
}

class ControleRemoto {

    public void controlarDispositivo(DispositivoEletrônico dispositivo) {
        dispositivo.ligar();
        dispositivo.status();
        dispositivo.desligar();
    }
}

class Main {

    public static void main(String[] args) {
        DispositivoEletrônico smartphone = new Smartphone(
            "Samsung",
            "Galaxy S21"
        );

        DispositivoEletrônico smartTV = new SmartTV("LG", 55);

        ControleRemoto controleRemoto = new ControleRemoto();

        controleRemoto.controlarDispositivo(smartphone);
        controleRemoto.controlarDispositivo(smartTV);
    }
}
