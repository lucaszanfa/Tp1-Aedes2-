#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool ehpalindromo(char str[]) 
{
    int tamanho = strlen(str);
    bool resposta = true;
    int i = 0;

    while (resposta && i < tamanho / 2) 
    {
        if (str[i] != str[tamanho - i - 1]) 
        {
            resposta = false;
        }
        i++;
    }
    return resposta;  
}

int main() 
{
    char str[50];
    char aux[] = "FIM";
    bool ajuda = true;
    bool resposta;

    do 
    {
        printf("\nDigite uma palavra ou caractere, digite FIM caso queira sair do programa: ");
        fgets(str, sizeof(str), stdin);
        str[strcspn(str, "\n")] = '\0';

        if (strcmp(str, aux) == 0) 
        {
            ajuda = false;
        } 
        else 
        {
            resposta = ehpalindromo(str);
            if (resposta) 
            {
                printf("\n%s eh um palindromo!\n", str);
            } 
            else 
            {
                printf("\n%s nao eh um palindromo!\n", str);
            }
        }
    } while (ajuda);

    printf("\nObrigado por Entrar!");

    return 0;
}
