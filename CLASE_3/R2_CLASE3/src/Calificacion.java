public enum Calificacion {
    UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5);

    private final int valor;

    Calificacion(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
