package ua.nure.pihnastyi.practice5;


import java.util.Scanner;

public final class Spam extends Thread {

    private static final int SLEEP_TIME1 = 255;
    private static final int SLEEP_TIME2 = 113;

    private String[] messages = new String[]{"Spam1", "Spam2"};
    private int[] times = new int[]{SLEEP_TIME1, SLEEP_TIME2};

    @Override
    public void run() {
        for (int i = 0; i < messages.length; i++) {
            System.out.println(messages[i]);
            try {
                Thread.sleep(times[i]);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "CP1251");
        Spam spam = new Spam();
        spam.start();
        in.nextLine();
        spam.interrupt();
    }
}