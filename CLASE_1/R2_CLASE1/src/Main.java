import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 🎥 Videos
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("Biología", "Dr.Carlos", 15));
        videos.add(new Video("Estadistica", "Dra.Karla", 20));

        // 📄 Artículos
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo("Moleculas del Apego", "Dra.Ana", 1200));
        articulos.add(new Articulo("Neurodesarrollo", "Dra. Karen", 800));

        // 📝 Ejercicios
        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(new Ejercicio("Plan de intervecion", "Dr.Eric"));
        ejercicios.add(new Ejercicio("Reestructuracion cognitiva", "Dra.Ana"));

        // 📚 Mostrar materiales del curso
        List<MaterialCurso> todosLosMateriales = new ArrayList<>();
        todosLosMateriales.addAll(videos);
        todosLosMateriales.addAll(articulos);
        todosLosMateriales.addAll(ejercicios);

        GestorMateriales.mostrarMateriales(todosLosMateriales);

        // 🎥 Calcular duración total de los videos
        GestorMateriales.contarDuracionVideos(videos);

        // ✅ Marcar ejercicios como revisados
        GestorMateriales.marcarEjerciciosRevisados(ejercicios);

        // 🔍 BUSCAR

        String autorBuscado = "Dra.Ana"; // Este valor puede cambiar dinámicamente
        Predicate<MaterialCurso> filtroPorAutor = material -> material.autor.equalsIgnoreCase(autorBuscado);

        // 🔍 Filtrando materiales
        GestorMateriales.filtrarMateriales(todosLosMateriales, filtroPorAutor);
    }
}