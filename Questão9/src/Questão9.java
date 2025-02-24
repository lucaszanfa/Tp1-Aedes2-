import java.util.Scanner;

class ColocandoEmOrdem{
    public static void ordenar(char[] vetor)
    {
        int tamanho = vetor.length;
        char aux;
        for(int i = 0; i < tamanho; i++)
        {
            for(int j = 0; j < tamanho - 1 - i; j++)
            {
                if(vetor[j] > vetor[j + 1])
                {
                    aux = vetor[j + 1];
                    vetor[j + 1] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
    }
}

class Resolvendo{
    public static boolean saoanagramas(String palavra1, String palavra2)
    {
        boolean resposta = true;
        int tamanho = palavra1.length();
        int aux = 0;
        if(palavra1.length() != palavra2.length())
        {
            resposta = false;
        }
        else
        {
            char[] vetor1 = palavra1.toCharArray();
            char[] vetor2 = palavra2.toCharArray();
            ColocandoEmOrdem.ordenar(vetor1);
            ColocandoEmOrdem.ordenar(vetor2);
            while(aux < tamanho)
            {
                if(vetor1[aux] != vetor2[aux])
                {
                    resposta = false;
                    aux = tamanho;
                }
                aux++;
            }
        }
        return resposta;
    }
}

public class Questão9 {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        
        boolean continuar = true; 
        
        while (continuar) {
            String palavra1 = leitor.nextLine();
            String palavra2 = leitor.nextLine();

            if (palavra1.equalsIgnoreCase("FIM") || palavra2.equalsIgnoreCase("FIM")) {
                continuar = false; 
            } else {
                boolean resposta = Resolvendo.saoanagramas(palavra1, palavra2);
                if (resposta) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NÃO");
                }
            }
        }
        
        leitor.close();
    }
}

