import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    @Override

    public String call() throws Exception {
        Thread.sleep(600); // Simula establecimiento de enlace con estación terrestre
        return "📡 Comunicaciones: enlace con estación terrestre establecido.";
    }
}