import java.util.Arrays;
import java.util.Scanner;

public class Questão9 {

    public static boolean Fim(String palavra){

        boolean resultado = false; 

        if(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'){
            resultado = true;
        }

        return resultado;
    }

    public static boolean anagrama(String palavra, String aux) {

        boolean resultado = false;

        if (palavra.length() != aux.length()) { //verificando se tem msm tamanho
            return false; 
        }

        char[] arrayPalavra = palavra.toCharArray();  //transformando as strings em vetores, pois me java as strings sao imutaveis
        char[] arrayAux = aux.toCharArray();

        Arrays.sort(arrayPalavra); //organizando os vetores em uma msm ordem, aq no caso a alfabetica
        Arrays.sort(arrayAux);

        if(Arrays.equals(arrayPalavra, arrayAux)){ //se forem iguais dps de ordenados sao anagramas
            resultado = true;
        }

        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {  
            String entrada = scanner.nextLine().trim(); 
            if (Fim(entrada)) {
                break;  
            }

            String[] palavras = entrada.split(" - "); // Divide as palavras pelo separador " - "
            if (palavras.length == 2) {  
                String palavra1 = palavras[0].trim(); 
                String palavra2 = palavras[1].trim(); 

                if (anagrama(palavra1, palavra2)) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        }

        scanner.close();
    }
}

