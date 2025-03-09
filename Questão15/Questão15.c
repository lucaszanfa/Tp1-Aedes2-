#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

void formattedDouble(double input) {
    char *buffer = (char*) malloc((80+1) * sizeof(char)); 
    sprintf(buffer, "%.10lf", input);
    int length = strlen(buffer);
    while (length > 0 && (buffer[length-1] == '0' || buffer[length-1] == '.')) {
        if (buffer[length-1] == '.') {
            buffer[length-1] = '\0';
            length = 0;
        }
        buffer[length-1] = '\0'; 
        length = length - 1;
    }
    printf("%s\n", buffer);
}

void writeDoubleToFile(int n, char* filename) {
    FILE *file = fopen(filename, "w+b");
    for (int x = 0; x < n; x = x + 1) {
        double input = 0.0;
        scanf("%lf", &input);
        fwrite(&input, sizeof(double), 1, file);
    }
    fclose(file);
}

void readDoubleFromFile(int n, char* filename) {
    FILE *file = fopen(filename, "rb");
    double value = 0.0;
    if (file == NULL) {
        printf("\n%s\n", "ERRO: Nao foi possivel abrir o arquivo");
    } else {
        for (int pointer = 0; pointer < n; pointer = pointer + 1) {
            fseek(file, (n - pointer - 1) * sizeof(double), SEEK_SET);
            fread(&value, sizeof(double), 1, file);
            formattedDouble(value);
        }
    }
    fclose(file);
}

int main() {
    setlocale(LC_NUMERIC, "en_US.UTF-8");
    int n = 0;
    char *filename = "ARQUIVO.TXT";
    scanf("%d", &n);
    writeDoubleToFile(n, filename);
    readDoubleFromFile(n, filename);
}