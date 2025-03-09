import java.util.Scanner;

public class AlgebraBooleanaRec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada;

        do {
            entrada = scanner.nextLine();
            if (!entrada.equals("0")) {
                System.out.println(solveEquation(entrada) ? "1" : "0");
            }
        } while (!entrada.equals("0"));
        
        scanner.close();
    }

    public static String treatment(String input) {
        int n = input.charAt(0) - '0';
        String expressao = removeBlank(input);
        expressao = replaceAll("and", 'a', expressao);
        expressao = replaceAll("or", 'o', expressao);
        expressao = replaceAll("not", 'n', expressao);

        for (int x = 0; x < n; x++) {
            char c = (char) ('A' + x);
            char newC = expressao.charAt(x + 1);
            expressao = replaceAll(Character.toString(c), newC, expressao);
        }
        return subString(expressao, n + 1, expressao.length());
    }

    public static String solveExp(String input) {
        int inputLen = input.length();
        char operation = input.charAt(0);
        boolean flag;

        switch (operation) {
            case 'a':
                flag = true;
                for (int y = 2; y < inputLen && flag; y++) {
                    if (input.charAt(y) == '0') return "0";
                }
                return "1";
            case 'o':
                flag = false;
                for (int y = 2; y < inputLen && !flag; y++) {
                    if (input.charAt(y) == '1') return "1";
                }
                return "0";
            case 'n':
                return input.charAt(2) == '0' ? "1" : "0";
            default:
                return "";
        }
    }

    public static boolean solveEquation(String input) {
        return solveEquationRec(treatment(input));
    }

    public static boolean solveEquationRec(String input) {
        if (input.contains("(")) {
            int start = input.lastIndexOf('(');
            int end = input.indexOf(')', start);
            String subExp = subString(input, start - 1, end + 1);
            String resultString = solveExp(subExp);
            input = subString(input, 0, start - 1) + resultString + subString(input, end + 1, input.length());
            return solveEquationRec(input);
        }
        return input.equals("1");
    }

    public static String subString(String s, int start, int end) {
        return s.substring(start, Math.min(end, s.length()));
    }

    public static String removeBlank(String input) {
        return input.replace(" ", "");
    }

    public static String replaceAll(String base, char newChar, String input) {
        return input.replace(base, String.valueOf(newChar));
    }
}
