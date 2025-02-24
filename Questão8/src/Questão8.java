import java.util.Scanner;

class SomaDigitos {
    public static int somaRecursiva(int numero) {
        if (numero == 0) {
            return 0;
        }
        return (numero % 10) + somaRecursiva(numero / 10);
    }
}

public class Questão8 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        while (leitor.hasNextInt()) {
            int numero = leitor.nextInt();
            System.out.println(SomaDigitos.somaRecursiva(numero));
        }
        leitor.close();
    }
}


