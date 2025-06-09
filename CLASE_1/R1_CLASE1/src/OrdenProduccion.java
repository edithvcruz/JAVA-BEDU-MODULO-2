public abstract class OrdenProduccion {
    String codigo;
    int cantidad;

    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public void mostrarResumen() {
        System.out.println("Código: " + codigo + " - Cantidad: " + cantidad);


    }
}
