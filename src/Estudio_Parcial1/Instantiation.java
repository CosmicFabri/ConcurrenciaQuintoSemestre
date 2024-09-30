/* Testing the two different ways to instantiate Threads in Java. */

package Estudio_Parcial1;

public class Instantiation {
    public static void main(String[] args) {
        HiloThread hilo1 = new HiloThread();
        Thread hilo2 = new Thread(new HiloRunnable());
        
        hilo1.start();
        hilo2.start();
    }
}

class HiloThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println("Thread: " + Thread.currentThread().getName()
                            + ", odd number: " + i);
        }
    }
}

class HiloRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i += 2) {
            System.out.println("Thread " + Thread.currentThread().getName()
                            + ", even number: " + i);
        }
    }
}