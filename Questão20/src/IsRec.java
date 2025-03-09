import java.util.Scanner;

public class IsRec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada;
        while (true) {
            entrada = scanner.nextLine();
            if (isFim(entrada)) break;
            String i1 = isVogal(entrada) ? "SIM" : "NAO";
            String i2 = isConsoante(entrada) ? "SIM" : "NAO";
            String i3 = isInteger(entrada) ? "SIM" : "NAO";
            String i4 = isReal(entrada) ? "SIM" : "NAO";
            System.out.println(i1 + " " + i2 + " " + i3 + " " + i4);
        }
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
        for (char c : s.toCharArray()) {
            if (isLower(c) || isUpper(c)) return true;
        }
        return false;
    }

    public static boolean isCharVogal(char c) {
        c = toLower(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static boolean isVogalRec(String s, int x) {
        if (x >= s.length()) return true;
        return isCharVogal(s.charAt(x)) && isVogalRec(s, x + 1);
    }

    public static boolean isVogal(String s) {
        return isAlpha(s) && isVogalRec(s, 0);
    }

    public static boolean isConsoanteRec(String s, int x) {
        if (x >= s.length()) return true;
        return !isCharVogal(s.charAt(x)) && isConsoanteRec(s, x + 1);
    }

    public static boolean isConsoante(String s) {
        return isAlpha(s) && isConsoanteRec(s, 0);
    }

    public static boolean isIntegerRec(String s, int x) {
        if (x >= s.length()) return true;
        return isDigit(s.charAt(x)) && isIntegerRec(s, x + 1);
    }

    public static boolean isInteger(String s) {
        return isIntegerRec(s, 0);
    }

    public static boolean isRealRec(String s, int x, int ponto) {
        if (x >= s.length()) return ponto <= 1;
        char c = s.charAt(x);
        if (isDigit(c)) return isRealRec(s, x + 1, ponto);
        if (c == '.' || c == ',') return isRealRec(s, x + 1, ponto + 1);
        return false;
    }

    public static boolean isReal(String s) {
        return isRealRec(s, 0, 0);
    }
}

