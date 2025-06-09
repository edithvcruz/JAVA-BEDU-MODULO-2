import java.util.List;
import java.util.function.Predicate;

public class GestorMateriales {

    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("📚 Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video videos1 : lista) {
            total += videos1.getDuracion();
        }
        System.out.println("\n🎥 Duración total de videos: " + total + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        System.out.println("\n✅ Marcando ejercicios como revisados...");
        for (Object o : lista) {
            if (o instanceof Ejercicio) {
                Ejercicio ejercicio = (Ejercicio) o;
                ejercicio.marcarRevisado();
                System.out.println("✅ Ejercicio '" + ejercicio.titulo + "' marcado como revisado.");
            }
        }
    }






        // 🔹 Método genérico que filtra materiales según un criterio usando Predicate
        public static void filtrarMateriales(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> criterio) {
            System.out.println("\n🔍 Filtrando materiales por Autor...");
            for (MaterialCurso material : lista) {
                if (criterio.test(material)) {  // Aplica el filtro dinámico
                    material.mostrarDetalle();



                }

            }

        }}