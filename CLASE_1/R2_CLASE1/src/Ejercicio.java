
public class Ejercicio extends MaterialCurso {
    boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this. revisado=false;
    }

    public void marcarRevisado() {
        revisado = true;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📝 Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + revisado);
    }
}