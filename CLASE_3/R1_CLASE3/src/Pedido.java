import java.util.Optional;

public class Pedido {
    private String cliente;
    private Optional<String> telefono; // Puede ser null
    private Entrega tipoEntrega;

    public Pedido(String cliente, String telefono, Entrega tipoEntrega) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = Optional.ofNullable (telefono);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;

    }

    public Optional<String> getTelefono() {
        return telefono;
    }

    public void setTelefono(Optional<String> telefono) {
        this.telefono = telefono;
    }

    public Entrega getTipoentrega() {
        return tipoEntrega;
    }
    public void setTipoEntrega(Entrega tipoEntrega) {
        this.tipoEntrega= tipoEntrega;
    }

}