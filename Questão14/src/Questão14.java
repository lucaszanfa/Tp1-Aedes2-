import java.io.*;
import java.util.Scanner;

public class Questão14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "valores.txt";

        try (RandomAccessFile file = new RandomAccessFile(filename, "rw")) {
            while (true) {
                int n = scanner.nextInt();
                if (n == 200) break;

                for (int i = 0; i < n; i++) {
                    double valor = scanner.nextDouble();
                    file.writeDouble(valor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
            long fileSize = file.length();
            long pos = fileSize - 8;

            while (pos >= 0) {
                file.seek(pos);
                double valor = file.readDouble();
                System.out.println(valor);
                pos -= 8;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
