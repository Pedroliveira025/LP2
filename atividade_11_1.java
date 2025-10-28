import java.util.ArrayList;

interface Produto {
    String getNome();

    double getPreço();
}

class Bebida implements Produto {

    private String nome;

    private double preço;

    private boolean alcoólica;

    public Bebida(String nome, double preço, boolean alcoólica) {
        this.nome = nome;
        this.preço = preço;
        this.alcoólica = alcoólica;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreço() {
        return this.preço;
    }
}

class Lanche implements Produto {

    private String nome;

    private double preço;

    private boolean salgado;

    public Lanche(String nome, double preço, boolean salgado) {
        this.nome = nome;
        this.preço = preço;
        this.salgado = salgado;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreço() {
        return this.preço;
    }
}

class Higiene implements Produto {

    private String nome;

    private double preço;

    private boolean líquido;

    public Higiene(String nome, double preço, boolean líquido) {
        this.nome = nome;
        this.preço = preço;
        this.líquido = líquido;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreço() {
        return this.preço;
    }
}

class Carrinho {

    private ArrayList<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<Produto>();
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public double calcularTotal() {
        double total = 0.0;

        for (int i = 0; i < produtos.size(); ++i) {
            total += produtos.get(i).getPreço();
        }

        if (total > 100.00) {
            total *= 0.9;
        }

        return total;
    }

    public void listarProdutos() {
        for (int i = 0; i < produtos.size(); ++i) {
            System.out.println(
                produtos.get(i).getNome() + " : " + produtos.get(i).getPreço()
            );
        }

        System.out.println("Total do carrinho: " + calcularTotal());
    }
}

class Main {

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        Produto cachaça = new Bebida("Cachaça Caranguejo 600 mL", 14.00, true);
        Produto água = new Bebida("Healsi 0,5 L", 8.23, false);
        Produto salgadinho = new Lanche("Doritos 170 g", 17.52, true);
        Produto sabonete = new Higiene(
            "Dove sabonete líquido Original 5 Litros",
            94.90,
            true
        );

        carrinho.adicionarProduto(cachaça);
        carrinho.adicionarProduto(água);
        carrinho.adicionarProduto(salgadinho);
        carrinho.adicionarProduto(sabonete);

        carrinho.listarProdutos();
    }
}
