import java.util.*;

public class Questão3{

    public static String ciframentoCesar(String var){

        String cesar = "";

        for(int i = 0; i < var.length(); i++){
            char caractere = var.charAt(i);
            cesar += (char) (caractere + 3);
        }

        return cesar;
    }

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;  
        while(continuar){
            String linha = scanner.nextLine();
            if(linha.equals("FIM")){  
                continuar = false;  
            } else {
                System.out.println(ciframentoCesar(linha)); 
            }
        }
    
        scanner.close();
    }
}




