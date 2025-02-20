import java.util.Scanner;

class Inverter {
    public static String mudando(String palavra) {
        int tamanho = palavra.length();
        char[] palavraArray = palavra.toCharArray(); 
        char aux;
        
        for (int i = 0; i < tamanho / 2; i++) {
            aux = palavraArray[i];
            palavraArray[i] = palavraArray[tamanho - i - 1]; 
            palavraArray[tamanho - i - 1] = aux;
        }
        
        return new String(palavraArray); 
    }
}

public class Questão7 {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        String leitura;
        boolean aux = true;
        
        do {
            leitura = leitor.nextLine();
            
            if (leitura.equals("FIM")) {
                aux = false;
            } else {
                String invertida = Inverter.mudando(leitura);
                System.out.println("" + invertida);
            }
        } while (aux);

        leitor.close();
    }
}

