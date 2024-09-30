package Recopilacion.executor;

/* Ejemplo 3: Uso de executor para crear una piscina de hilos y resolver una tarea
que requiere de poder de procesamiento. Elaborado por Luis Fabrizio Guzmán Liza. */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Fabrizio
 */
public class CPUIntensiveTask {
    
    public static void main(String[] args) {
        
        // Get count of available cores
        int coreCount = Runtime.getRuntime().availableProcessors();
        
        // Create the thread pool
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        
        // Submit the tasks for execution
        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }
        
        System.out.println("Thread name: " + Thread.currentThread().getName());
        
        System.out.println("Number of cores: " + coreCount);
        
    }
    
    static class Task implements Runnable {
        
        @Override
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
        
    }
}
