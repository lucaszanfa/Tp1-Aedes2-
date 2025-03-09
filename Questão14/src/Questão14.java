import java.io.RandomAccessFile;
import java.util.Scanner;

public class Questão14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String filename = "ARQUIVO.TXT";
        writeDoubleToFile(n, filename, scanner);
        readDoubleFromFile(n, filename);
        scanner.close();
    }

    public static void writeDoubleToFile(int n, String filename, Scanner scanner) {
        try {
            RandomAccessFile file = new RandomAccessFile(filename, "rw");
            for (int x = 0; x < n; x++) {
                double input = scanner.nextDouble();
                file.writeDouble(input);
            }
            file.close();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public static void readDoubleFromFile(int n, String filename) {
        try {
            RandomAccessFile file = new RandomAccessFile(filename, "rw");
            int fileLen = (int) file.length();
            for (int x = 0; x < n; x++) {
                fileLen -= 8;
                file.seek(fileLen);
                double value = file.readDouble();
                if (value == (int) value) {
                    System.out.println((int) value);
                } else {
                    System.out.println(value);
                }
            }
            file.close();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
