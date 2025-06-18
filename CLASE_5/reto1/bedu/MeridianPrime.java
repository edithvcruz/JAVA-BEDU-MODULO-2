import java.util.List;
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class MeridianPrime {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Flux<Integer> flujoTrafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(congestion -> congestion > 70)
                .doOnNext(congestion -> System.out.println("Alerta: Congestion del " + congestion + "% en Avenida Solar"))
                .onBackpressureBuffer(5);
                ;

        Flux<Integer> flujoContaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(80))
                .filter(pm -> pm > 50)
                .doOnNext(pm -> System.out.println("Alerta: Contaminacion alta (PM2.5: " + pm + " ug/m3) en Zona Industrial"));

        Flux<String> flujoAccidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> new String[]{"Baja", "Media", "Alta"}[random.nextInt(3)])
                .filter(prioridad -> prioridad.equals("Alta"))
                .doOnNext(prioridad -> System.out.println("Emergencia vial: Accidente con prioridad " + prioridad + " en el cruce de Avenida Central"));

        Flux<Integer> flujoTrenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11))
                .filter(retraso -> retraso > 5)
                .doOnNext(retraso -> System.out.println("Tren maglev con retraso critico: " + retraso + " min en Estacion Norte"))
                .onBackpressureBuffer(3);

        Flux<List<String>> flujoSemaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> new String[]{"Verde", "Amarillo", "Rojo"}[random.nextInt(3)])
                .buffer(3)
                .filter(estados -> estados.stream().allMatch(e -> e.equals("Rojo")))
                .doOnNext(estados -> System.out.println("Semaforo en Rojo detectado 3 veces seguidas en cruce Norte"));

        // Fusionar todos los flujos y acumular eventos críticos durante la ejecución
        Flux.merge(flujoTrafico, flujoContaminacion, flujoAccidentes, flujoTrenes, flujoSemaforos.flatMap(Flux::fromIterable))
                .bufferTimeout(5,Duration.ofSeconds(2))
                .filter(eventos -> eventos.size() >= 3)
                .doOnNext( eventosGlobales -> System.out.println("Alerta global: Multiples eventos criticos detectados en Meridian Prime"))
                .subscribe();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}