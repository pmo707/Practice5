package ua.nure.pihnastyi.practice5;
public class Part3 {
    private int firstIncrement;
    private int secondIncrement;
    private static final int SLEEP_TIME = 10;
    private static final int ITERATION = 10;
    private static final int PAUSE_TIME = 1000;
    private void myCompareTo() {
        firstIncrement++;
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.printf("interrupted!!! Thread==>%s", Thread.currentThread());
            Thread.currentThread().interrupt();
        }
        secondIncrement++;
        System.out.printf("CompereTo: firstCount - secondCount==>%s%n", firstIncrement - secondIncrement);
    }
    private synchronized void synchronizeMyCompareTo() {
        firstIncrement++;
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.printf("interrupted! Thread==>%s", Thread.currentThread());
            Thread.currentThread().interrupt();
        }
        secondIncrement++;
        System.out.printf(" synchronizedCompereTo: firstCount - secondCount==>%s%n", firstIncrement - secondIncrement);
    }
    public static void main(String[] args) {
        final Part3 part3 = new Part3();
        for (int i = 0; i < ITERATION; i++) {
            new Thread(part3::synchronizeMyCompareTo).start();
        }
        try {
            Thread.sleep(PAUSE_TIME);
        } catch (InterruptedException e) {
            System.out.printf("interrupted!!! Thread==>%s", Thread.currentThread());
            Thread.currentThread().interrupt();
        }
        for (int i = 0; i < ITERATION; i++) {
            new Thread(part3::myCompareTo).start();
        }
    }
}
