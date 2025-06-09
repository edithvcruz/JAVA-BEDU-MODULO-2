import java.util.concurrent.*;

public class MisionEspacial {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        // 🛠️ Crear un pool de 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // 🔹 Enviar tareas de los subsistemas al executor
        Future<String> nav = executor.submit(new SistemaNavegacion());
        Future<String> soporte = executor.submit(new SistemaSoporteVital());
        Future<String> termico = executor.submit(new SistemaControlTermico());
        Future<String> comunicaciones = executor.submit(new SistemaComunicaciones());

        try {
            // 📡 Recuperar resultados de cada sistema
            System.out.println(comunicaciones.get());
            System.out.println(soporte.get());
            System.out.println(termico.get());
            System.out.println(nav.get());

            System.out.println("✅ Todos los sistemas reportan estado operativo.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("⚠️ Error en la simulación: ");


        // 🔚 Cerrar el executor
        executor.shutdown();
    }
}}