import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(800); // Simula monitoreo de presión y oxígeno
        return "🧪 Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}
