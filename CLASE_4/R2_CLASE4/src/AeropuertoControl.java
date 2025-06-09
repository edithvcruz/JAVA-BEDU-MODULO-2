import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class AeropuertoControl {

    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        // 🔥 Ejecutar todas las verificaciones en paralelo
        CompletableFuture<Boolean> pista = verificarCondicion("🛣️ Pista disponible", 80);
        CompletableFuture<Boolean> clima = verificarCondicion("🌦️ Clima favorable", 85);
        CompletableFuture<Boolean> trafico = verificarCondicion("🚦 Tráfico aéreo despejado", 90);
        CompletableFuture<Boolean> personal = verificarCondicion("👷‍♂️ Personal disponible", 95);

        // 🏁 Combinar todas las verificaciones
        CompletableFuture<Void> gestionAterrizaje =


                CompletableFuture.allOf(pista, clima, trafico, personal)
                .thenRun(() -> {
                    List<Boolean> condiciones = List.of(pista.join(), clima.join(), trafico.join(), personal.join());

                    if (condiciones.stream().allMatch(Boolean::booleanValue)) {
                        System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                    } else {
                        System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                    }
                }).exceptionally(ex -> {
                    System.out.println("❌ Error en la gestión de aterrizaje: " + ex.getMessage());
                    return null;
                });

        gestionAterrizaje.join(); // Esperamos a que todo finalice antes de salir
    }

    // 🎲 Método genérico para verificar condiciones con probabilidad personalizada
    private static CompletableFuture<Boolean> verificarCondicion(String mensaje, int probabilidadExito) {
        return CompletableFuture.supplyAsync(() -> {
            //
            esperarSegundos(2, 3);
            boolean resultado = probabilidad(probabilidadExito);
            System.out.println(mensaje + ": " + resultado);
            return resultado;
        });
    }

    // 🎲 Simulación de probabilidades (retorna true según porcentaje)
    private static boolean probabilidad(int porcentajeExito) {
        return ThreadLocalRandom.current().nextInt(100) < porcentajeExito;
    }

    // ⏳ Simulación de espera con latencia aleatoria
    private static void esperarSegundos(int min, int max) {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(min, max + 1));
        } catch (InterruptedException e) {
            throw new IllegalStateException("Error en la simulación");
        }
    }
}