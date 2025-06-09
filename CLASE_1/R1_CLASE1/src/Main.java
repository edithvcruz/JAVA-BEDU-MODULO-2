import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 🔧 Crear lista de órdenes de producción en masa
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        // 🛠️ Crear lista de órdenes personalizadas
        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        // 🧪 Crear lista de órdenes prototipo
        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        // 📋 Mostrar órdenes registradas
        System.out.println("\n \uD83D\uDCCB Órdenes registradas:");
        Ordenes.mostrarOrdenes(ordenesMasa);
        System.out.println("\n \uD83D\uDCCB Órdenes registradas:");
        Ordenes.mostrarOrdenes(ordenesPersonalizadas);
        System.out.println("\n \uD83D\uDCCB Órdenes registradas:");
        Ordenes.mostrarOrdenes(ordenesPrototipo);

        // 💰 Procesar órdenes personalizadas con un costo adicional de $200
        System.out.println("\n \uD83D\uDC9C Procesando órdenes personalizadas...");
        Ordenes.procesarPersonalizadas(ordenesPersonalizadas, 200);

        // 📊 Mostrar el total de órdenes de cada tipo
        System.out.println("\n ✅ Resumen total de órdenes:");
        Ordenes.contarOrdenes(ordenesMasa, "Producción en masa");
        Ordenes.contarOrdenes(ordenesPersonalizadas, "Personalizadas");
        Ordenes.contarOrdenes(ordenesPrototipo, "Prototipos");
    }
}