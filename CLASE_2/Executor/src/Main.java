import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    //Hilo principal
    public static void main(String[] args) {

        // Creando el gestor de hilos con soporte para N hilos simultaneos
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //EXECUTOR SERVICE ES UN GESTOR DE HILOS Y RECURSOS
        //Indica o administra los hilos de ejecución
        //NEWFIXEDTHREADSPOOL: INDICA EL LIMITE DE RECURSOS A LOS QUE SE PUEDE DIRIGIR UN HILO O VARIOS HILOS

        // Mandando un hilo a recoger su "pelotita" de las N disponibles
        executor.submit(new MiTercerHilo());

        // Impedir que más hilos entren a la "alberca" (pool)
        executor.shutdown();

        // Voy a esperar a que todos los hilos terminen
        // Hasta los hilos no terminen, el hilo NO avanza

        // Existe la posibilidad de los hilos se tarden mucho
        // a lo que vamos a llamar un "Timeout"

        // En este ejemplo, el hilo principal solo va a esperar 10 segundos
        // Si termina el tiempo máximo entonces se lanza una excepción
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println("Se termino el tiempo de espera");
        }
    }
}