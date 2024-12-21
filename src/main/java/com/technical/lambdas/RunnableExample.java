package com.technical.lambdas;

public class RunnableExample {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable");
            }
        };

        new Thread(runnable).start();

        // Java 8 lambda
        // () -> {}

        Runnable runnableLambda = ()->{
            System.out.println("Inside Runnable lambda");
        };

        new Thread(runnableLambda).start();
    }
}
