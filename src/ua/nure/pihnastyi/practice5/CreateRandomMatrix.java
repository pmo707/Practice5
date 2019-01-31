package ua.nure.pihnastyi.practice5;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.SecureRandom;
import java.util.Random;
public class CreateRandomMatrix {
    private static final int M = 4;
    private static final int N = 100;
    private static final String FILE_ENCODING = "CP1251";
    private static int[][] randomArray = new int[M][N];
    private static final int MAX_VALUE = 988;
    private static void writeFile(String fileName, String input) {
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(fileName), FILE_ENCODING)) {
            writer.write(input);
            writer.flush();
        } catch (IOException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
    private static void createRandomArray() {
        Random random = new SecureRandom();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                randomArray[i][j] = random.nextInt(MAX_VALUE);
            }
        }
    }
    private static String arrayToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(randomArray[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        createRandomArray();
        String input = arrayToString();
        writeFile("part4.txt", input);
    }
}
