import java.util.*;

public class Questão5{

    public static String substituirBinario(int[] binarios, String booleana){
        
        String resultado = "";

        for(int i = 0; i < booleana.length(); i++){

            if(booleana.charAt(i) != ' '){
                
                if(booleana.charAt(i) == 'A'){
                    resultado += binarios[0];
                }
                else if(booleana.charAt(i) == 'B'){
                    resultado += binarios[1];
                }
                else if(booleana.charAt(i) == 'C'){
                    resultado += binarios[2];
                }
                else{
                    resultado += booleana.charAt(i);
                }
            }
        }

        return resultado;
    }

    public static String negar(String booleana){

        String resultado = "";

        for(int i = 0; i < booleana.length(); i++){

            if (booleana.charAt(i) == 'n' &&
                (booleana.charAt(i + 4) == '1' ||
                booleana.charAt(i + 4) == '0')){

                if(booleana.charAt(i + 4) == '1'){

                    resultado += "0";
                }
                else{

                    resultado += "1";
                }

                i += 5;

            }
            else{

                resultado += booleana.charAt(i);
            }
        }

        return resultado;
    }

    private static String conjuncao(String booleana){

        String resultado = "";

        for(int i = 0; i < booleana.length(); i++){

            if(booleana.charAt(i) == 'a' &&
                (booleana.charAt(i + 4) == '1' ||
                booleana.charAt(i + 4) == '0') &&
                (booleana.charAt(i + 6) == '1' ||
                booleana.charAt(i + 6) == '0')){

                if(booleana.charAt(i + 7) == ')'){

                    if(booleana.charAt(i + 4) == '1' &&
                        booleana.charAt(i + 6) == '1'){

                            resultado += "1";
                    }
                    else{

                        resultado += "0";
                    }

                    i += 7;
                }
                else{
                    resultado += booleana.charAt(i);
                }
            }
            else{
                resultado += booleana.charAt(i);
            }
        }
    
        return resultado;
    }

    public static String disjuncao(String booleana){

        String resultado = "";

        for(int i = 0; i < booleana.length(); i++){

            if(booleana.charAt(i) == 'o' &&
                booleana.charAt(i + 1) == 'r' &&
                (booleana.charAt(i + 3) == '1' ||
                booleana.charAt(i + 3) == '0') &&
                (booleana.charAt(i + 5) == '1' ||
                booleana.charAt(i + 5) == '0')){
                
                if(booleana.charAt(i + 6) == ')'){
                    
                    if(booleana.charAt(i + 3) == '1' ||
                        booleana.charAt(i + 5) == '1' ){
                            
                            resultado += "1";
                    }
                    else{
                        resultado += "0";
                    }

                    i += 6;
                }
            }
            else{
                resultado += booleana.charAt(i);
            }
        }
    
        return resultado;
    }

    private static String resolverParenteses(String booleana){

        int operacao = 0;

        for(int i = 0; i < booleana.length(); i++){
            if(booleana.charAt(i) == ')'){
                operacao++;
            }
        }

        char[] funcoes = new char[operacao];
    
        for(int i = 0; i < booleana.length() - 2; i++){
            if(booleana.charAt(i + 2) == 't'){
                funcoes[--operacao] = 'n';
            }
            else if(booleana.charAt(i + 2) == 'd'){
                funcoes[--operacao] = 'a';
            }
            else if(booleana.charAt(i + 1) == 'r'){
                funcoes[--operacao] = 'o';
            }
        }

        for(int i = 0; i < funcoes.length; i++){
            if(funcoes[i] == 'n'){
                booleana = negar(booleana); 
            }
            else if(funcoes[i] == 'a'){
                booleana = conjuncao(booleana);
            }
            else{
                booleana = disjuncao(booleana);
            }
        }

        return booleana;
    }

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        
        int qtdValores = scanner.nextInt();
        String booleana;

        int[] binarios = new int[3];

        while(qtdValores != 0){
            for(int i = 0; i < qtdValores; i++){
                binarios[i] = scanner.nextInt();
            }

            booleana = scanner.nextLine();
            booleana = substituirBinario(binarios, booleana);
            booleana = resolverParenteses(booleana);

            System.out.println(booleana);
        
            qtdValores = scanner.nextInt();
        }

        scanner.close();
    }
}