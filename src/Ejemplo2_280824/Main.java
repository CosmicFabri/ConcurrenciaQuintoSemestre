/* Programa de ejemplo para manejar los estados de los hilos.
Elaborado por Luis Fabrizio Guzmán Liza el 28/08/2024 */

package Ejemplo2_280824;

import java.util.logging.Level;
import java.util.logging.Logger;

class MiRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hilo " + Thread.currentThread().getName()
                               + ", iteracion " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(MiRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new MiRunnable());
        Thread hilo2 = new Thread(new MiRunnable());
        
        System.out.println("Hilo 1: " + hilo1.getName() + ", estado: " + hilo1.getState().toString());
        System.out.println("Hilo 2: " + hilo1.getName() + ", estado: " + hilo1.getState().toString());
        
        hilo1.start();
        hilo2.start();  
        
        while (true) {
            if ("TERMINATED".equals(hilo1.getState().toString()) && "TERMINATED".equals(hilo2.getState().toString())) {
                System.out.println("Ambos hilos han terminado su ejecución.");
                break;
            }
        }
        
        System.out.println("Estado del hilo 1: " + hilo1.getState().toString());
        System.out.println("Estado del hilo 2" + hilo2.getState().toString());
    }
}
