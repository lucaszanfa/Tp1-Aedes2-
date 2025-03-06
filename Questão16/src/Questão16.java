import java.util.Scanner;

class Resolvendo {
    public static boolean ehpalindromorec(char[] palavra, int aux, int tamanho) {
        boolean retornar;

        if (aux >= tamanho) { 
            retornar = true;
        } else if (palavra[aux] != palavra[tamanho]) { 
            retornar = false;
        } else { 
            retornar = ehpalindromorec(palavra, aux + 1, tamanho - 1);
        }

        return retornar;
    }
}

public class Questão16 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String palavra2;
        boolean continuar = true;
        boolean resposta;

        do {
            palavra2 = leitor.nextLine();
            if (palavra2.equals("FIM")) {
                continuar = false;
            } else {
                int tamanho = palavra2.length();
                char[] palavra = palavra2.toCharArray();
                resposta = Resolvendo.ehpalindromorec(palavra, 0, tamanho - 1);

                if (resposta) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        } while (continuar);

        leitor.close();
    }
}

