import java.util.Scanner;

class Contando {
    public static int quantaspalavras(String palavra) {
        int tamanho = palavra.length();
        char[] vetor = palavra.toCharArray();
        int contador = 1; 
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == ' ') {
                contador++;
            }
        }

        return contador;
    }
}

public class Questão10 {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        String palavra;
        boolean continuar = true;
        int resposta;
        do
        {
            palavra = leitor.nextLine();
            if(palavra.equals("FIM"))
            {
                continuar = false;
            }
            else
            {
                resposta = Contando.quantaspalavras(palavra);
                System.out.println("" + resposta);
            }
        }while(continuar);
        leitor.close();
    }
}
