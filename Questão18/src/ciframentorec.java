import java.util.Scanner;

public class ciframentorec {
    public static boolean isFim(String s) {
        return s.length() == 3 && s.equals("FIM");
    }

    public static String ciframentoRec(String s, int x) {
        String cifra = "";
        if (x < s.length()) {
            cifra = (char) (s.charAt(x) + 3) + ciframentoRec(s, x + 1);
        }
        return cifra;
    }

    public static String ciframento(String s) {
        return ciframentoRec(s, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] entrada = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = scanner.nextLine();
        } while (!isFim(entrada[numEntrada++]));
        numEntrada--;

        for (int x = 0; x < numEntrada; x++) {
            System.out.println(ciframento(entrada[x]));
        }

        scanner.close();
    }
}
