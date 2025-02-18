import java.util.Scanner;

class Ciframento {
    public static void cesar(char caractere[], int tamanho) {
        for (int i = 0; i < tamanho; i++) { 
            caractere[i] = (char) (caractere[i] + 3); 
        }
        System.out.println(new String(caractere)); 
    }
}

public class Questão3 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        String entrada = leitor.nextLine();
        while (!entrada.equals("FIM")) { 
            char[] caractere = entrada.toCharArray(); 
            int tamanho = caractere.length; 

            Ciframento.cesar(caractere, tamanho); 

            entrada = leitor.nextLine(); 
        }

        leitor.close(); 
    }
}


