package ua.nure.pihnastyi.practice5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Part5 {
    private static final String NUMBERS_FILE_NAME = "part5.txt";
    private static final int NUMBER_OF_THREADS = 10;
    private static RandomAccessFile randomAccessFile;

    public static void main(String[] args) {
        MyThread.deleteFile(NUMBERS_FILE_NAME);
        try {
            randomAccessFile = new RandomAccessFile(NUMBERS_FILE_NAME, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        Thread[] threads = new Thread[NUMBER_OF_THREADS];
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new MyThread(randomAccessFile, i);
        }
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i].start();
        }
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        try {
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println(Util.readFile(NUMBERS_FILE_NAME, "UTF-8"));
    }
}
