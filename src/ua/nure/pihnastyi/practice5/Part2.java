package ua.nure.pihnastyi.practice5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Part2 {

    private static final String ENCODING ="CP1251";
    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        InputStream stdIn = System.in;
        ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes(ENCODING));
        System.setIn(bais);
        Spam.main(args);
        Thread.sleep(2000);
        System.out.println("Try to send enter to standard input");
        System.setIn(stdIn);
    }
}