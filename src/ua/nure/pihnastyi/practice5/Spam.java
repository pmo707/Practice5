package ua.nure.pihnastyi.practice5;


import java.util.Scanner;

public final class Spam extends Thread {

    private String[] messages = new String[]{"@@@", "bbbbbbb"};
    private int[] times = new int[]{333, 222};

    @Override
    public void run() {
        for (int i = 0; i < times.length; i++) {
            System.out.println(messages[i]);
            try {
                Thread.sleep(times[i]);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "CP1251");
        Spam s = new Spam();
        s.start();
        in.nextLine();
        s.interrupt();
    }
}