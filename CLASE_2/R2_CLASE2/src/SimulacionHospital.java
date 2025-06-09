import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de acceso a recursos médicos iniciada...");

        // 🏥 Creación del recurso médico
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // 🔹 Creación de profesionales médicos
        String[] profesionales = {"Dra. Sánchez", "Dr. Gómez", "Enfermero Pérez", "Dra. Rodríguez"};

        // 🔄 ExecutorService para manejar concurrencia
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String profesional : profesionales) {
            executor.submit(new ProfesionalMedico(profesional, salaCirugia));
        }

        // 🔚 Cerrar el executor cuando termine la simulación
        executor.shutdown();
    }
}