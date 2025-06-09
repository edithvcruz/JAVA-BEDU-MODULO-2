import java.util.Optional;

public class Encuesta {
    private String paciente;
    private Optional<String> comentario; // Puede ser null
    private Calificacion calificacion;


    public Encuesta(String paciente, String comentario, Calificacion calificacion) {
        this.paciente = paciente;
        this.comentario = Optional.ofNullable (comentario);
        this.calificacion = calificacion;

    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;}

    public Calificacion getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    // 📌 Método que devuelve el comentario envuelto en Optional
    public Optional<String> getComentario() {
        return comentario;
    }
    public void setComentario(Optional<String> comentario) {
        this.comentario=comentario;

    }}