#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int somadigitosrec(int valor, int resposta)
{
    if(valor == 0)
    {
        resposta = 0;
    }
    else
    {
        resposta = valor % 10 + somadigitosrec(valor / 10, resposta);
    }
    return resposta;

}

int lervalor()
{
    int numero;
    scanf("%i", &numero);
    return numero;
}

int main()
{
    int valor = lervalor();
    int resposta = somadigitosrec(valor, 0);
    printf("\n%i", resposta);
}