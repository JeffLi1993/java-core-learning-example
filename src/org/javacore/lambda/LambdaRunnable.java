package org.javacore.lambda;

/**
 * Created by bysocket on 16/7/13.
 */
public class LambdaRunnable {
    static int b = 10;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            b++;
            System.out.println(b);
        });
        thread.start();
        System.out.println("Done!");
    }
}
