import java.util.Scanner;

public class Questão6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String entrada = "";
        do {
            entrada = scanner.nextLine();
            if (!isFim(entrada)) {
                System.out.print(isVogal(entrada) ? "SIM " : "NAO ");
                System.out.print(isConsoante(entrada) ? "SIM " : "NAO ");
                System.out.print(isInteger(entrada) ? "SIM " : "NAO ");
                System.out.println(isReal(entrada) ? "SIM" : "NAO");
            }
        } while (!isFim(entrada));
        scanner.close();
    }

    public static boolean isFim(String s) {
        return s.equals("FIM");
    }

    public static boolean isUpper(char c) {
        return 'A' <= c && c <= 'Z';
    }

    public static boolean isLower(char c) {
        return 'a' <= c && c <= 'z';
    }

    public static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public static char toLower(char c) {
        return isUpper(c) ? (char) (c + 32) : c;
    }

    public static boolean isAlpha(String s) {
        for (int x = 0; x < s.length(); x++) {
            char c = s.charAt(x);
            if (isLower(c) || isUpper(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCharVogal(char c) {
        char a = toLower(c);
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }

    public static boolean isVogal(String s) {
        if (!isAlpha(s)) return false;
        for (int x = 0; x < s.length(); x++) {
            if (!isCharVogal(s.charAt(x))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isConsoante(String s) {
        if (!isAlpha(s)) return false;
        for (int x = 0; x < s.length(); x++) {
            if (isCharVogal(s.charAt(x))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInteger(String s) {
        for (int x = 0; x < s.length(); x++) {
            if (!isDigit(s.charAt(x))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isReal(String s) {
        int count = 0;
        int ponto = 0;
        for (int x = 0; x < s.length(); x++) {
            char c = s.charAt(x);
            if (isDigit(c)) {
                count++;
            } else if (c == '.' || c == ',') {
                ponto++;
            }
        }
        return count > 0 && ponto <= 1;
    }
}


