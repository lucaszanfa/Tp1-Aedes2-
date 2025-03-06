#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool ehpalindromorec(char palavra[], int aux, int tamanho) {
    bool retornar;
    if (aux >= tamanho) { 
        retornar = true;
    } else if (palavra[aux] != palavra[tamanho]) { 
        retornar = false;
    } else { 
        retornar = ehpalindromorec(palavra, aux + 1, tamanho - 1);
    }

    return retornar;
}

int main()
{
    char palavra[50];
    bool continuar = true;
    bool resposta;
    int tamanho;
    do
    {
        fgets(palavra, sizeof(palavra), stdin);
        palavra[strcspn(palavra, "\n")] = '\0';
        if(strcmp(palavra, "FIM") == 0)
        {
            continuar = false;
        }
        else
        {
            tamanho = strlen(palavra);
            resposta = ehpalindromorec(palavra, 0, tamanho - 1);
            if(resposta)
            {
                printf("SIM\n");
            }
            else
            {
                printf("NAO\n");
            }
        }
    }while(continuar);
        
}