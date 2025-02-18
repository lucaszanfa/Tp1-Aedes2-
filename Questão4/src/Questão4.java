import java.util.Random;
import java.util.Scanner;

public class Questão4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random gerador = new Random();
        gerador.setSeed(4);
        
        String linha;
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            
            if (!linha.equals("FIM")) {
                char letra1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
                char letra2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
                
                linha = substituirLetra(linha, letra1, letra2); 
                System.out.println(linha); 
            }
        }
        scanner.close();
    }
    
    public static String substituirLetra(String str, char original, char substituto) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == original) {
                resultado.append(substituto);
            } else {
                resultado.append(c); 
            }
        }
        return resultado.toString(); 
    }
}

