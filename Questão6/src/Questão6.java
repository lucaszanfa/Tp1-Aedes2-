import java.util.Scanner;

class Primeirometodo {
    public static boolean somentevogais(String variavel) {
        boolean resultado = true;
        int tamanho = variavel.length();
        int i = 0;

        while (i < tamanho && resultado) {
            char c = variavel.charAt(i);
            if (!(c == 'a' || c == 'A' || c == 'e' || c == 'E' ||
                  c == 'i' || c == 'I' || c == 'o' || c == 'O' ||
                  c == 'u' || c == 'U')) {
                resultado = false;
            }
            i++;
        }
        return resultado;
    }
}

class Segundometodo {
    public static boolean somenteconsoantes(String variavel) {
        boolean resultado = true;
        int tamanho = variavel.length();
        int i = 0;

        while (i < tamanho && resultado) {
            char c = variavel.charAt(i);
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E' ||
                c == 'i' || c == 'I' || c == 'o' || c == 'O' ||
                c == 'u' || c == 'U' || !Character.isLetter(c)) {
                resultado = false;
            }
            i++;
        }
        return resultado;
    }
}

class Terceirometodo {
    public static boolean ehNumeroInteiro(String variavel) {
        boolean resultado = true;

        if (variavel == null || variavel.isEmpty()) {
            resultado = false;
        } else {
            int i = 0;
            if (variavel.charAt(0) == '+' || variavel.charAt(0) == '-') {
                if (variavel.length() == 1) {
                    resultado = false;
                }
                i = 1;
            }
            while (i < variavel.length() && resultado) {
                if (!Character.isDigit(variavel.charAt(i))) {
                    resultado = false;
                }
                i++;
            }
        }
        return resultado;
    }
}

class Quartometodo {
    public static boolean ehNumeroReal(String variavel) {
        boolean resultado = true;
        boolean pontoEncontrado = false;

        if (variavel == null || variavel.isEmpty()) {
            resultado = false;
        } else {
            int i = 0;
            if (variavel.charAt(0) == '+' || variavel.charAt(0) == '-') {
                if (variavel.length() == 1) {
                    resultado = false;
                }
                i = 1;
            }

            while (i < variavel.length() && resultado) {
                char c = variavel.charAt(i);
                if (c == '.') {
                    if (pontoEncontrado || i == variavel.length() - 1) {
                        resultado = false;
                    }
                    pontoEncontrado = true;
                } else if (!Character.isDigit(c)) {
                    resultado = false;
                }
                i++;
            }
        }
        return resultado;
    }
}

public class Questão6 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String variavel = leitor.nextLine();

        boolean resposta1 = Primeirometodo.somentevogais(variavel);
        boolean resposta2 = Segundometodo.somenteconsoantes(variavel);
        boolean resposta3 = Terceirometodo.ehNumeroInteiro(variavel);
        boolean resposta4 = Quartometodo.ehNumeroReal(variavel);

        System.out.print(resposta1 ? "SIM " : "NÃO ");
        System.out.print(resposta2 ? "SIM " : "NÃO ");
        System.out.print(resposta3 ? "SIM " : "NÃO ");
        System.out.println(resposta4 ? "SIM" : "NÃO");

        leitor.close();
    }
}


