package ua.nure.pihnastyi.practice5;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Part4 {
    private static final String FILE_ENCODING = "CP1251";
    private static final String FILE_NAME = "part4.txt";
    private static final String REGEX = "[\\d]+";
    private static final int M = 4;
    private static final int N = 27;
    private final int[][] inputArray = new int[M][N];
    private int[] results;
    private Thread[] threads;
    public Part4() {
        threads = new Thread[M];
        results = new int[M];
    }
    private void fillArray(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matcher.find()) {
                    inputArray[i][j] = Integer.parseInt(matcher.group());
                }
            }
        }
    }
    private void notParalFindMatrixMaxValue() {
        int maxMatrixValue = inputArray[0][0];
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                if (inputArray[i][j] > maxMatrixValue) {
                    maxMatrixValue = inputArray[i][j];
                }
            }
        }
        System.out.println(maxMatrixValue);
    }
    private void paralFindMatrixMaxValue() {
        for (int i = 0; i < M; i++) {
            threads[i] = new MyThread(inputArray[i], i);
            threads[i].start();
        }
        for (int i = 0; i < M; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(findMaxLine(results));
    }
    private static int findMaxLine(int[] inputArray) {
        int maxMatrixValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxMatrixValue) {
                maxMatrixValue = inputArray[i];
            }
        }
        return maxMatrixValue;
    }
    private class MyThread extends Thread {
        private int[] inputArray;
        private int positionM;
        MyThread(int[] inputArray, int positionM) {
            this.inputArray = inputArray.clone();
            this.positionM = positionM;
        }
        @Override
        public void run() {
            int maxLineValue = inputArray[0];
            for (int i = 1; i < inputArray.length; i++) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                if (inputArray[i] > maxLineValue) {
                    maxLineValue = inputArray[i];
                }
            }
            results[positionM] = maxLineValue;
        }
    }
    public static void main(String[] args) {
        String input = Util.readFile(FILE_NAME, FILE_ENCODING);
        Part4 part4 = new Part4();
        part4.fillArray(input);
        long startTime = System.currentTimeMillis();
        part4.paralFindMatrixMaxValue();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
        startTime = System.currentTimeMillis();
        part4.notParalFindMatrixMaxValue();
        finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}