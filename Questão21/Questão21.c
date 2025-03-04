#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

char* inverterec(char string[], int aux, char retornar[], int tamanho) {
    if (tamanho == 0) {
        retornar[aux] = '\0';  
        return retornar;
    }
    retornar[aux] = string[tamanho - 1];
    return inverterec(string, aux + 1, retornar, tamanho - 1);
}

int main() {
    char string[50], retornar[50];
    bool continuar = true;


    do
    {
        fgets(string, sizeof(string), stdin);
        string[strcspn(string, "\n")] = '\0';
        if(strcmp(string, "FIM") == 0)
        {
            continuar = false;
        }
        int tamanho = strlen(string);
        printf("%s\n", inverterec(string, 0, retornar, tamanho));
    }while(continuar);

    return 0;
}
