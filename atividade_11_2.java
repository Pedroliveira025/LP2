import java.util.Vector;

interface Figura {
    double área();

    double perímetro();

    void exibirFigura();
}

class Círculo implements Figura {

    private double raio;

    public Círculo(double raio) {
        this.raio = raio;
    }

    public double área() {
        return Math.PI * raio * raio;
    }

    public double perímetro() {
        return 2 * Math.PI * raio;
    }

    public void exibirFigura() {
        System.out.println("Raio: " + raio);
        System.out.println("Área: " + área());
        System.out.println("Perímetro: " + perímetro());
    }
}

class Retângulo implements Figura{
    private double base;

    private double altura;

    public Retângulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double área() {
        return base * altura;
    }

    public double perímetro() {
        return 2 * (base + altura);
    }

    public void exibirFigura() {
        System.out.println("base: " + base);
        System.out.println("altura: " + altura);
        System.out.println("Área: " + área());
        System.out.println("Perímetro: " + perímetro());
    }
}

class Quadrado implements Figura{
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double área() {
        return lado * lado;
    }

    public double perímetro() {
        return 4 * lado;
    }

    public void exibirFigura() {
        System.out.println("lado: " + lado);
        System.out.println("Área: " + área());import java.util.Vector;

        interface Figura {
            double área();

            double perímetro();

            void exibirFigura();
        }

        class Círculo implements Figura {

            private double raio;

            public Círculo(double raio) {
                this.raio = raio;
            }

            public double área() {
                return Math.PI * raio * raio;
            }

            public double perímetro() {
                return 2 * Math.PI * raio;
            }

            public void exibirFigura() {
                System.out.println("Raio: " + raio);
                System.out.println("Área: " + área());
                System.out.println("Perímetro: " + perímetro());
            }
        }

        class Retângulo implements Figura{
            private double base;

            private double altura;

            public Retângulo(double base, double altura) {
                this.base = base;
                this.altura = altura;
            }

            public double área() {
                return base * altura;
            }

            public double perímetro() {
                return 2 * (base + altura);
            }

            public void exibirFigura() {
                System.out.println("base: " + base);
                System.out.println("altura: " + altura);
                System.out.println("Área: " + área());
                System.out.println("Perímetro: " + perímetro());
            }
        }

        class Quadrado implements Figura{
            private double lado;

            public Quadrado(double lado) {
                this.lado = lado;
            }

            public double área() {
                return lado * lado;
            }

            public double perímetro() {
                return 4 * lado;
            }

            public void exibirFigura() {
                System.out.println("lado: " + lado);
                System.out.println("Área: " + área());
                System.out.println("Perímetro: " + perímetro());
            }
        }

        class Triângulo implements Figura{
            private double base;

            private double altura;

            private double lado1;

            private double lado2;

            public Triângulo(double base, double altura, double lado1, double lado2) {
                this.base = base;
                this.altura = altura;
                this.lado1 = lado1;
                this.lado2 = lado2;
            }

            public double área() {
                return base * altura / 2.0;
            }

            public double perímetro() {
                return base + lado1 + lado2;
            }

            public void exibirFigura() {
                System.out.println("Base: " + base);
                System.out.println("Altura: " + altura);
                System.out.println("Lado 1: " + lado1);
                System.out.println("Lado 2: " + lado2);
                System.out.println("Área: " + área());
                System.out.println("Perímetro: " + perímetro());
            }
        }

        class Main {

            static Figura maiorFigura(Vector<Figura> figuras) {
                Figura maiorFigura = figuras.get(0);

                for (int i = 1; i < figuras.size(); ++i) {
                    if (figuras.get(i).área() > maiorFigura.área()) {
                        maiorFigura = figuras.get(i);
                    }
                }

                return maiorFigura;
            }

            static void exibirFiguras(Vector<Figura> figuras) {
                for (int i = 0; i < figuras.size(); ++i) {
                    figuras.get(i).exibirFigura();
                    System.out.println();
                }
            }

            public static void main(String[] args) {
                Figura círculo = new Círculo(2);
                Figura retângulo = new Retângulo(2, 3);
                Figura quadrado = new Quadrado(5);
                Figura triângulo = new Triângulo(1,2,3,4);

                Vector<Figura> figuras = new Vector<Figura>();
                figuras.add(círculo);
                figuras.add(retângulo);
                figuras.add(quadrado);
                figuras.add(triângulo);

                exibirFiguras(figuras);

                System.out.println("---Maior figura---");
                Figura maiorFigura = maiorFigura(figuras);
                maiorFigura.exibirFigura();
            }
        }

        System.out.println("Perímetro: " + perímetro());
    }
}

class Triângulo implements Figura{
    private double base;

    private double altura;

    private double lado1;

    private double lado2;

    public Triângulo(double base, double altura, double lado1, double lado2) {
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public double área() {
        return base * altura / 2.0;
    }

    public double perímetro() {
        return base + lado1 + lado2;
    }

    public void exibirFigura() {
        System.out.println("Base: " + base);
        System.out.println("Altura: " + altura);
        System.out.println("Lado 1: " + lado1);
        System.out.println("Lado 2: " + lado2);
        System.out.println("Área: " + área());
        System.out.println("Perímetro: " + perímetro());
    }
}

class Main {

    static Figura maiorFigura(Vector<Figura> figuras) {
        Figura maiorFigura = figuras.get(0);

        for (int i = 1; i < figuras.size(); ++i) {
            if (figuras.get(i).área() > maiorFigura.área()) {
                maiorFigura = figuras.get(i);
            }
        }

        return maiorFigura;
    }

    static void exibirFiguras(Vector<Figura> figuras) {
        for (int i = 0; i < figuras.size(); ++i) {
            figuras.get(i).exibirFigura();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Figura círculo = new Círculo(2);
        Figura retângulo = new Retângulo(2, 3);
        Figura quadrado = new Quadrado(5);
        Figura triângulo = new Triângulo(1,2,3,4);

        Vector<Figura> figuras = new Vector<Figura>();
        figuras.add(círculo);
        figuras.add(retângulo);
        figuras.add(quadrado);
        figuras.add(triângulo);

        exibirFiguras(figuras);

        System.out.println("---Maior figura---");
        Figura maiorFigura = maiorFigura(figuras);
        maiorFigura.exibirFigura();
    }
}
