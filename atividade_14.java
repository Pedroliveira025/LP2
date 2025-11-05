import java.util.Map;
import java.util.HashMap;

class Escola
{
    private Map<Integer, String> alunos;
    
    private static int contador = 0;
    
    public Escola()
    {
        alunos = new HashMap<>();
    }
    
    private int matrícula()
    {
        contador++;
        return contador;
    }
    
    public void matricular(String nome)
    {
        alunos.put(matrícula(), nome);
    }
    
    public void listarAlunos()
    {
        System.out.println(alunos);
    }
    
    //public Aluno buscarAluno(int matrícula){};
}


class Main
{
    public static void main(String[] args)
    {
        Escola escola = new Escola();
        
        escola.matricular("Pedro");
        escola.matricular("Marina");
        escola.matricular("Graça");
        escola.matricular("Chico");
        
        escola.listarAlunos();
    }
}
