import java.util.Scanner;

public class Questão3 {
    public static boolean isFim(String s) {
        return s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M';
    }

    public static String ciframento(String s) {
        String cifra = "";
        for (int x = 0; x < s.length(); x++) {
            cifra += (char) (s.charAt(x) + 3);
        }
        return cifra;
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






