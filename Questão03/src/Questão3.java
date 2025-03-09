import java.util.Scanner;

public class Questão3 {
    
    public static boolean Fim(String palavra){

        boolean aux = false;

        if(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'){
            aux = true;
        }

        return aux;
    }

    public static String ciframento(String palavra){

        int aux = 0; //tem que se utilizar um aux aq, pois n se pode fazer diretamnete "palavra.charAt(i) = palavra.charAt(i) + 3"
        String palavra2 = "";

        for(int i = 0; i < palavra.length(); i++){
            aux = palavra.charAt(i);
            palavra2 = palavra2 + (char)(aux + 3);
        }

        return palavra2;
    }

    public static void main(String[] palavra){

        Scanner scanner = new Scanner(System.in, "UTF-8");

        String[] entrada = new String[1000]; //declarando nova string

        int aux = 0;

        do{
            entrada[aux] = scanner.nextLine().trim();
        }while(Fim(entrada[aux++]) == false); //enquanto n chegar ao fim 
        aux--;

        for(int i = 0; i < aux; i++){
            System.out.println(ciframento(entrada[i])); //loop para ficar printando as letras que entrarem na classe ciframento 
        }

        scanner.close();
    }
}






