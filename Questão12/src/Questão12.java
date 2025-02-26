import java.util.Scanner;

class Resolvendo{
    public static boolean valida(String senha)
    {
        int tamanho = senha.length();
        int contador_minusculas = 0;
        int contador_maiusculas = 0;
        int contador_simbolos = 0;
        int contador_numeros = 0;
        boolean ehvalida = true;
        char c;
        for(int i = 0; i < tamanho; i++)
        {
            c = senha.charAt(i);
            if(Character.isUpperCase(c))
            {
                contador_maiusculas++;
            }
            else if(Character.isLowerCase(c))
            {
                contador_minusculas++;
            }
            else if(Character.isDigit(c))
            {
                contador_numeros++;
            }
            else if(!Character.isLetterOrDigit(c))
            {
                contador_simbolos++;
            }
        }
        if(contador_maiusculas == 0 || contador_minusculas == 0 || contador_numeros == 0 || contador_simbolos == 0 || contador_simbolos > 1)
        {
            ehvalida = false;
        }
        return ehvalida;
    }
}

public class Questão12 {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        String senha;
        boolean resposta;
        do
        {
            senha = leitor.nextLine();
            if(senha.equals("FIM"))
            {
                continuar = false;
            }
            else
            {
                resposta = Resolvendo.valida(senha);
                if(resposta)
                {
                    System.out.println("SIM");
                }
                else
                {
                    System.out.println("NÃO");
                }
            }
        } while(continuar);
        leitor.close();
    }
}
