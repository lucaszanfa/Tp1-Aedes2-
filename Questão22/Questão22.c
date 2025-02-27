#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

int somadigitosrec(char valor[], int indice, int soma)
{
    if (valor[indice] != '\0') 
    {
        soma += valor[indice] - '0'; 
        soma = somadigitosrec(valor, indice + 1, soma); 
    }
    return soma; 
}

int main()
{
    char entrada[20];
    bool continuar = true;

    do
    {
        fgets(entrada, sizeof(entrada), stdin);
        entrada[strcspn(entrada, "\n")] = '\0';

        if (strcmp(entrada, "FIM") == 0)
        {
            continuar = false;
        }
        else
        {
            int resposta = somadigitosrec(entrada, 0, 0);
            printf("%d\n", resposta);
        }

    } while (continuar);
}
