/* Tarea para demostrar los estados de los hilos en Java.
Elaborado por Luis Fabrizio Guzmán Liza, el 02/09/2024 */

package TareaEstadosThreads;

import java.util.logging.Level;
import java.util.logging.Logger;

class Hilo implements Runnable {
    @Override
    public void run() {
        System.out.println("Hilo " + Thread.currentThread().getName() + " esta en ejecucion.");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

public class EstadosThreads {
    public static void main(String[] args) {
        Thread miHilo = new Thread(new Hilo());
        
        // Como no se ha ejecutado el hilo, su estado debe ser NUEVO (NEW)
        System.out.println("Estado del hilo antes de llamar a start(): " + miHilo.getState());
        
        miHilo.start();
        
        // Ya que el hilo se está ejecutando en este momento, su estado debe ser RUNNABLE
        System.out.println("Estado del hilo luego de llamar a start(): " + miHilo.getState());
        
        // Durmiento al hilo principal por un segundo...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EstadosThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Como el hilo principal está durmiendo, el hilo que creamos no puede continuar
        // su ejecución, y le va a esperar por un tiempo máximo. Estado: TIMED_WAITING
        System.out.println("Estado del hilo actualmente: " + miHilo.getState());
        
        // El método join() espera a que el hilo termine su ejecución para continuar el programa
        try {
            miHilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(EstadosThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	// En este momento, el hilo debe estar en estado TERMINATED, ya que, al salir del
	// método join(), habrá terminado la ejecución de su código
        System.out.println("Estado del hilo luego de llamar a join(): " + miHilo.getState());
    }
}
