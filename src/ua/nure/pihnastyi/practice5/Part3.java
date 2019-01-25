package ua.nure.pihnastyi.practice5;

public class Part3 {

    private int firstIncrement = 0;
    private int secondIncrement = 0;

    private void myCompareTo() {
        firstIncrement++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.printf("interrupted!!! Thread==>%s", Thread.currentThread());
        }
        secondIncrement++;
        System.out.printf("CompereTo: firstCount - secondCount==>%s%n", firstIncrement - secondIncrement);
    }

    private synchronized void synchronizeMyCompareTo() {
        firstIncrement++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.printf("interrupted! Thread==>%s", Thread.currentThread());
        }
        secondIncrement++;
        System.out.printf(" synchronizedCompereTo: firstCount - secondCount==>%s%n", firstIncrement - secondIncrement);

    }

    public static void main(String[] args) {
        final Part3 part3 = new Part3();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> part3.synchronizeMyCompareTo()).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.printf("interrupted!!! Thread==>%s", Thread.currentThread());
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> part3.myCompareTo()).start();
        }
    }
}
