import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    //Simulacion de profesional accediendo al recurso
    public void usar(String profesional) {
        lock.lock();

        try {
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(2000);
            // Simulación de uso del recurso
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println("⚠️ " + profesional + " fue interrumpido mientras usaba " + nombre);
        } finally {
            lock.unlock(); // 🔓 Liberar el recurso para el siguiente profesional
        }
    }
}