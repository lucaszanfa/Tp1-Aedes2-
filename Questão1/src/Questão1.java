import java.util.Scanner;

public class Questão1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            String input = leitor.nextLine();

            if (input.equals("FIM")) {
                continuar = false;
            } else {
                boolean aux = true;
                char[] palavra = input.toCharArray();
                int tamanho = palavra.length;
                int i = 0;

                while (aux && i < (tamanho / 2)) {
                    if (palavra[i] != palavra[tamanho - i - 1]) {
                        aux = false;
                    }
                    i++;
                }

                if (aux) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        }

        leitor.close();
    }
}

