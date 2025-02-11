import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean aux = true;  
        System.out.print("Digite seu caractere: ");
        String input = leitor.nextLine(); 
        char[] palavra = input.toCharArray();  
        int tamanho = palavra.length;  
        int i = 0;
        while(aux && i < (tamanho / 2)) { 
            if(palavra[i] != palavra[tamanho - i - 1]) { 
                aux = false;
            }
            i++;
        }
        if(aux) {
            System.out.println("A palavra é um palíndromo! " + input);  
        } else {
            System.out.println("A palavra não é um palíndromo! " + input); 
        }
        leitor.close();
    }
}
