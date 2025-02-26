import java.util.Scanner;

class Verificando {
    public static int comprimento(String palavra) {
        int tamanho = palavra.length();
        int resposta = 0;
        int aux = 0; 

        for (int i = 0; i < tamanho; i++) {
            aux = 0;

            for (int j = i; j < tamanho; j++) {
                char c = palavra.charAt(j);
                boolean repetido = false;

                for (int k = i; k < j; k++) {
                    if (palavra.charAt(k) == c) {
                        repetido = true;
                    }
                }

                if (repetido) {
                    j = tamanho; 
                } else {
                    aux++; 
                }
            }

            if (aux > resposta) {
                resposta = aux;
            }
        }

        if(resposta == tamanho)
        {
            resposta = 0;
        }

        return resposta;
    }
}

public class Questão11 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String palavra;
        boolean continuar = true;
        int resposta;

        do {
            palavra = leitor.nextLine();
            if (palavra.equals("FIM")) {
                continuar = false;
            } else {
                resposta = Verificando.comprimento(palavra);
                System.out.println(resposta);
            }
        } while (continuar);

        leitor.close();
    }
}

