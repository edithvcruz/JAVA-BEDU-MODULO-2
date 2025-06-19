package r2.reto02;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @Min(1)
    private double precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    protected Producto() {}

    public Producto(String nombre, String descripcion, double precio, Categoria categoria, Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.marca = marca;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public Categoria getCategoria() { return categoria; }
    public Marca getMarca() { return marca; }

    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f, marca='%s']",
                id, nombre, precio, marca != null ? marca.getNombre() : "Sin marca");
    }
}