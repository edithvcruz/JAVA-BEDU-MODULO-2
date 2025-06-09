package Ejemplo1;
public class CajaMisteriosa <T>{

    private T valor;

    public void guardar(T nuevoValor) {
        this.valor = nuevoValor;
    }

    public T sacar() {
        return valor;
    }

    public boolean estaVacia() {
        return valor == null;
    }
}




// PascalCase -> Primera letra de c/palabra mayuscula
// camelCase -> La primer letra es minúscula y luego la de c/palabra mayuscula

