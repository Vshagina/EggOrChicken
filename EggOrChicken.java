package com.company;

public class EggOrChicken {
    public static void main(String[] args) {
        Thread chicken = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Курица");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread eggThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Яйцо");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        chicken.start();
        eggThread.start();

        try {
            chicken.join();
            eggThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!chicken.isAlive()) {
            System.out.println("Спор окончен! Курица появилась раньше!");
        } else {
            System.out.println("Спор окончен! Яйцо появилось раньше!");
        }
    }
}