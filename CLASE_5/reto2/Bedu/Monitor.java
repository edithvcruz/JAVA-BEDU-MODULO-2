import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class Monitor {
    private static final Random random = new Random();
    private static final int MAX_EVENTOS = 2;
    private static final Duration INTERVALO_GENERACION = Duration.ofMillis(300);
    private static final Duration INTERVALO_PROCESAMIENTO = Duration.ofSeconds(1);

    public static void main(String[] args) throws InterruptedException {
        Flux<SignosVitales> paciente1 = generarSignosVitales(1);
        Flux<SignosVitales> paciente2 = generarSignosVitales(2);
        Flux<SignosVitales> paciente3 = generarSignosVitales(3);

        Flux.merge(paciente1, paciente2, paciente3)
                .filter(SignosVitales::esCritico)
                .sort((e1, e2) -> e1.prioridad() - e2.prioridad())
                .delayElements(INTERVALO_PROCESAMIENTO)
                .doOnNext(System.out::println)
                .last()
                .doOnNext(eventoFinal -> System.out.println("  \n"+"Evaluacion completa de pacientes."))

                .subscribe();

        Thread.sleep(15000);
    }

    private static Flux<SignosVitales> generarSignosVitales(int pacienteId) {
        return Flux.interval(INTERVALO_GENERACION)
                .map(tick -> SignosVitales.generarAleatorio(pacienteId))
                .take(MAX_EVENTOS);
    }
}

class SignosVitales {
    private final int pacienteId;
    private final int frecuenciaCardiaca;
    private final int presionSistolica;
    private final int presionDiastolica;
    private final int nivelOxigeno;
    private static final Random random = new Random();

    private SignosVitales(int pacienteId, int fc, int pas, int pad, int spo2) {
        this.pacienteId = pacienteId;
        this.frecuenciaCardiaca = fc;
        this.presionSistolica = pas;
        this.presionDiastolica = pad;
        this.nivelOxigeno = spo2;
    }

    public static SignosVitales generarAleatorio(int pacienteId) {
        return new SignosVitales(
                pacienteId,
                40 + random.nextInt(100),
                80 + random.nextInt(80),
                50 + random.nextInt(50),
                85 + random.nextInt(15)
        );
    }

    public boolean esCritico() {
        return frecuenciaCardiaca < 50 || frecuenciaCardiaca > 120 ||
                presionSistolica < 90 || presionSistolica > 140 ||
                presionDiastolica < 60 || presionDiastolica > 90 ||
                nivelOxigeno < 90;
    }

    public int prioridad() {
        if (frecuenciaCardiaca < 50 || frecuenciaCardiaca > 120) return 1;
        if (nivelOxigeno < 90) return 2;
        return 3;
    }

    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder("Paciente " + pacienteId + "  :"+"\n");
        if (frecuenciaCardiaca < 50 || frecuenciaCardiaca > 120)
            mensaje.append("->Frecuencia cardiaca critica: ").append(frecuenciaCardiaca).append(" bpm  ");
        if (nivelOxigeno < 90)
            mensaje.append("->Nivel de oxigeno bajo: ").append(nivelOxigeno).append("% "+ "  \n");
        if (presionSistolica < 90 || presionSistolica > 140 || presionDiastolica < 60 || presionDiastolica > 90)
            mensaje.append(" ->Presion arterial critica: ").append(presionSistolica).append("/").append(presionDiastolica).append(" mmHg  ");
        return mensaje.toString().trim();
    }
}