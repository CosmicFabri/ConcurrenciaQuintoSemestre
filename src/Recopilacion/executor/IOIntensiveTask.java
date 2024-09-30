package Recopilacion.executor;

/* Ejemplo 4: Uso de executor para crear una piscina de hilos y resolver una tarea
que usa mucho la entrada y la salida. Elaborado por Luis Fabrizio Guzmán Liza. */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Fabrizio
 */
public class IOIntensiveTask {
    
    public static void main(String[] args) {
        
        // Much higher count for IO tasks
        ExecutorService service = Executors.newFixedThreadPool(100);
        
        // Submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        
    }
    
    static class Task implements Runnable {
        
        @Override
        public void run() {
            System.out.println("Retrieving data from database...");
        }
        
    }
    
}
