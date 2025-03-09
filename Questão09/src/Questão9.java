import java.util.Arrays;
import java.util.Scanner;

public class Questão9 {
    
    public static boolean saoAnagramas(String str1, String str2) {
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        return Arrays.equals(array1, array2);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String entrada = scanner.nextLine().trim();
            if (entrada.equalsIgnoreCase("FIM")) {
                break;
            }
            
            String[] partes = entrada.split(" - ");
            if (partes.length != 2) {
                continue;
            }
            
            String str1 = partes[0].trim();
            String str2 = partes[1].trim();
            
            System.out.println(saoAnagramas(str1, str2) ? "SIM" : "NÃO");
        }
        
        scanner.close();
    }
}
