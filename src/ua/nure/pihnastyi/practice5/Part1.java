package ua.nure.pihnastyi.practice5;


public class Part1 extends Thread {

    public static void main(String[] args) throws InterruptedException {

        Thread t;
        t = new Thread(() -> {
            System.out.println("Way0");
            for (int i = 0; i < 4; i++) {
                try {
                    Part1.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join();

        t = new Thread(() -> {
            System.out.println("Way1");
            for (int i = 0; i < 4; i++) {
                try {
                    Part1.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"");
            }
        });
        t.start();
    }
}