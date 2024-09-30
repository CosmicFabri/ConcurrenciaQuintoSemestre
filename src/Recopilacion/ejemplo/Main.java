/* Ejemplo 5: Elabora un programa que genere las calificaciones de forma aleatoria (0 - 10)
para 3 alumnos de las materias: Español, Matemáticas, Inglés e Historia, muestre
en pantalla los datos de cada materia, el promedio general para cada alumno de
forma ordenada y al final el promedio general del grupo. Cada alumno será un hi-
lo de ejecución. Los cálculos deberán realizarse desde la clase hilo. Deberás u-
tilizar Cerraduras o Semáforos.

Elaborado por Luis Fabrizio Guzmán Liza. */

package Recopilacion.ejemplo;

/**
 *
 * @author Fabrizio Guzmán
 */
public class Main {
    
    public static void main(String[] args) {
        
        Thread hilo = new Thread(new Hilo());
        
        hilo.start();
        
    }
    
}
