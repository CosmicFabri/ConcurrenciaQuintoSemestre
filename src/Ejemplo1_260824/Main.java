package Ejemplo1_260824;

import java.util.logging.Level;
import java.util.logging.Logger;

class Hilo extends Thread {
    private String nombre;
    
    public Hilo (String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(nombre + " - Contador: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Fin de " + nombre);
    }
}

public class Main {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("JoJo");
        Hilo hilo2 = new Hilo("SiWa");
        
        hilo1.start();
        hilo2.start();
        
        System.out.println("Fin de " + Thread.currentThread().getName());
    }
}
