import java.util.Scanner;

class Ciframento {
    public static String cesar(String entrada) {
        StringBuilder cifrada = new StringBuilder();

        for (int i = 0; i < entrada.length(); i++) {
            cifrada.append((char) (entrada.charAt(i) + 3));
        }

        return cifrada.toString();
    }
}

public class Questão3 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        String entrada = leitor.nextLine();
        while (!entrada.equals("FIM")) { 
            System.out.println(Ciframento.cesar(entrada));
            entrada = leitor.nextLine(); 
        }

        leitor.close(); 
    }
}



