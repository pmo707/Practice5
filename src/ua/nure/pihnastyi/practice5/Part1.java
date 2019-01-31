package ua.nure.pihnastyi.practice5;


public class Part1  {
    private static final int PAUSE_TIME = 500;
    private static final int NUMBER_OF_PAUSE = 4;
    public static void main(String[] args) throws InterruptedException {

        Thread t;
        t = new Thread(() -> {
            System.out.println("Way0");
            for (int i = 0; i < NUMBER_OF_PAUSE; i++) {
                try {
                    Thread.sleep(PAUSE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join();

        t = new Thread(() -> {
            System.out.println("Way1");
            for (int i = 0; i < NUMBER_OF_PAUSE; i++) {
                try {
                    Thread.sleep(PAUSE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName()+"");
            }
        });
        t.start();
    }
}