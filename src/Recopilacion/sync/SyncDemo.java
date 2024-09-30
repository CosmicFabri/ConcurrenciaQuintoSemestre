package Recopilacion.sync;

/* Ejemplo 1: Sincronización con exlclusión mutua usando la palabra reservada
'synchronized', elaborado por Luis Fabrizio Guzmán Liza. */

class Counter {
    int count = 0;
    
    public synchronized void increment() {
        count++;
    }
}

public class SyncDemo {

    public static void main(String[] args) throws Exception {
        
        Counter c = new Counter();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    c.increment();
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    c.increment();
                }
            }
        });
        
        t1.start();
        t2.start();
        
        // Wait until t1 has completed the loop
        t1.join();
        t2.join();
        
        System.out.println("Count: " + c.count);
        
    }
    
}
