package Recopilacion.ejemplo;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fabrizio
 */
public class Hilo implements Runnable {
    
    Random random = new Random();
    Lock lock = new ReentrantLock();
    DecimalFormat df = new DecimalFormat("#.#");
    
    @Override
    public void run() {
        
        float[] promedios = new float[3];
        
        float promedioGeneral = 0;
        
        for (int i = 1; i <= 3; i++) {
            
            promedios[i - 1] = imprimirCalificaciones(i);
            promedioGeneral += promedios[i - 1];
            
        }
        
        System.out.println("Promedio del grupo: " + df.format(promedioGeneral / 3));
        
    }
    
    private float imprimirCalificaciones(int numAlumno) {
        
        lock.lock();
        
        float promedio = 0;
        
        try {
            
            float[] calificaciones = new float[4];
            
            for (int i = 0; i < 4; i++) {
                
                calificaciones[i] = random.nextFloat(10);
                promedio += calificaciones[i];
                
            }
            
            promedio /= 4;
            
            System.out.println("Alumno " + numAlumno);
            System.out.println("Espaniol: " + df.format(calificaciones[0]));
            System.out.println("Matematicas: " + df.format(calificaciones[1]));
            System.out.println("Ingles: " + df.format(calificaciones[2]));
            System.out.println("Historia: " + df.format(calificaciones[3]));
            System.out.println("Promedio: " + df.format(promedio) + "\n");
            
        } finally {
            
            lock.unlock();
            
        }
        
        return promedio;
        
    }
    
}