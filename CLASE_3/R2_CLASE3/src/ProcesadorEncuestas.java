import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProcesadorEncuestas {
    private static Encuesta encuesta;

    public static void main(String[] args) {

        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                new Encuesta("Ana","Me cobraron de más en la factura",Calificacion.DOS),
                new Encuesta("Luis", null, Calificacion.CUATRO),
                new Encuesta("Mario",  "La atención fue buena, pero la limpieza puede mejorar",Calificacion.TRES)

                )),
                new Sucursal("Norte", List.of(
                 new Encuesta("Carlos", null,Calificacion.UNO),
                 new Encuesta("Elena", "El trato del personal fue deficiente",Calificacion.DOS),
                 new Encuesta("Pedro", "Me cobraron de más en la factura",Calificacion.CINCO)
                )));

        System.out.println("📋 ENCUESTAS:");


        // 🏁 Procesamos todos los pedidos de todas las sucursales
        sucursales.stream()
                .flatMap(sucursal ->
                sucursal.getEncuestas()
                .stream()
                .filter(e -> e.getCalificacion().getValor() <= 3)
                .filter(conf -> conf.getComentario().isPresent()) // 🔍 Filtrar Optional con valor
                .map(encuesta -> encuesta.getComentario()
                .map(comentario -> "Sucursal " + sucursal.getNombre() +
                                        ": Seguimiento a paciente con comentario: \"" + comentario + "\"")))
                .map(Optional::get)
                .forEach(System.out::println); // 📤 Imprimir mensajes

    }
}