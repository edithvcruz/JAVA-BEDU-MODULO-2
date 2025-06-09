import java.util.List;

public class Ordenes {



    //Generico mostrar ordenes
    public static void mostrarOrdenes(List<?extends OrdenProduccion> lista) {
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }
    //Generico personalizadas
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        for (Object o : lista) {
            if (o instanceof OrdenPersonalizada) {
                OrdenPersonalizada op = (OrdenPersonalizada) o;
                System.out.println(" Orden " + op.codigo + " ajustada con costo adicional de $" + costoAdicional);
            }
        }
    }

    //Contar ordenes
    public static void contarOrdenes(List<? extends OrdenProduccion> lista, String tipo) {
        System.out.println(" Total de órdenes de " + tipo + ": " + lista.size());
    }


}
