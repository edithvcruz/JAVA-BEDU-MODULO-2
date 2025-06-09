import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Movilidad {

    public static void main(String[] args) {
        System.out.println("🚦 Calculando ruta...");

        // 🔥 Ejecuta ambas tareas en paralelo
        CompletableFuture<String> rutaFutura = calcularRuta();
        CompletableFuture<Double> tarifaFutura = calcularTarifa();

        // 🔄 Combinar ambas tareas asincrónicas correctamente
        CompletableFuture<Void> movilidad = rutaFutura

           .thenCombine(tarifaFutura, (ruta, tarifa) ->
                "\n"+ "🚗 " + ruta + "\n" +
               " Tarifa estimada: $" + tarifa)
           .exceptionally(ex -> {
            return "❌ Error en el proceso: " + ex.getMessage();})
            .thenAccept(System.out::println);

        movilidad.join(); // 🔚 Espera a que todo termine antes de salir
    }

    // 🔹 Simulación de cálculo de ruta con latencia aleatoria
    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2 + (int)(Math.random() * 2)); // Simula latencia de 2 a 3 segundos
                return "Ruta: Centro -> Norte";
            } catch (InterruptedException e) {
                throw new IllegalStateException("Error en cálculo de ruta");
            }
        });
    }

    // 🔹 Simulación de estimación de tarifa con latencia aleatoria
    public static CompletableFuture<Double> calcularTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1 + (int)(Math.random() * 2)); // Simula latencia de 1 a 2 segundos
                return 75.50;
            } catch (InterruptedException e) {
                throw new IllegalStateException("Error en estimación de tarifa");
            }
        });
    }
}