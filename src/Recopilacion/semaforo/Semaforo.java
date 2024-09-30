package Recopilacion.semaforo;

/* Ejemplo 2: Demostración de la exclusión mutua haciendo uso de los semáforos
en Java. Elaborado por Luis Fabrizio Guzmán Liza. */

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

// Un recurso/clase compartido
class Compartido {
    static int count = 0;
}

class MiHilo extends Thread {
    Semaphore sem;
    String nombreHilo;

    public MiHilo(Semaphore sem, String nombreHilo) {
        super(nombreHilo);
        this.sem = sem;
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        // Ejecutado por hilo A
        if (this.getName().equals("A")) {
            System.out.println("Iniciando " + nombreHilo);

            try {
                // Primero, obtener un permiso
                System.out.println(nombreHilo + " está esperando un permiso.");

                // Adquiriendo el candado
                sem.acquire();
                
                // Accediendo al recurso compartido.
                // Otros hilos esperarán, hasta que
                // este hilo libere el candado
                for (int i = 0; i < 5; i++) {
                    Compartido.count++;
                    System.out.println(nombreHilo + ": " + Compartido.count);
                    
                    // Ahora, permitiendo un cambio de contexto
                    // (si se puede) para que el hilo 2 se ejecute
                    Thread.sleep(10);
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            // Liberar el permiso
            System.out.println(nombreHilo + " libera el permiso.");
            sem.release();
        }
        
        // Ejecutado por hilo B
        else {
            System.out.println("Iniciando " + nombreHilo);

            try {
                // Primero, obtener un permiso
                System.out.println(nombreHilo + " está esperando un permiso.");

                // Adquiriendo el candado
                sem.acquire();
                
                // Accediendo al recurso compartido.
                // Otros hilos esperarán, hasta que
                // este hilo libere el candado
                for (int i = 0; i < 5; i++) {
                    Compartido.count--;
                    System.out.println(nombreHilo + ": " + Compartido.count);
                    
                    // Ahora, permitiendo un cambio de contexto
                    // (si se puede) para que el hilo 2 se ejecute
                    Thread.sleep(10);
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            // Liberar el permiso
            System.out.println(nombreHilo + " libera el permiso.");
            sem.release();
        }
    }
}

public class Semaforo {
    public static void main(String[] args) throws InterruptedException {
        // Creando un objeto semáforo con
        // un número de permisos de 1
        Semaphore sem = new Semaphore(1);
        
        // Creando dos hilos de nombres A y B.
        // Nótese que A incrementará el contador
        // y B lo decrementará
        MiHilo h1 = new MiHilo(sem, "A");
        MiHilo h2 = new MiHilo(sem, "B");
        
        // Iniciando hilos A y B
        h1.start();
        h2.start();
        
        // Esperando a los hilos A y B
        try {
            h1.join();
            h2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // El contador siempre quedará en 0 luego de
        // que los hilos hayan terminado su ejecución
        System.out.println("Count: " + Compartido.count);
    }
}
