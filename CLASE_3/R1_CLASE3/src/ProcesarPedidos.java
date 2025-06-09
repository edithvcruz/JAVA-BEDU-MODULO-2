import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;


public class ProcesarPedidos {
    public static void main(String[] args) {
        // 🔹 Lista de pedidos

        List<Pedido> pedido = new ArrayList<>();
        pedido.add(new Pedido("Ana", "555-1234", Entrega.DOMICILIO));
        pedido.add(new Pedido("Luis", null, Entrega.LOCAL));
        pedido.add(new Pedido("Mario", null,Entrega.DOMICILIO));
        pedido.add(new Pedido("Carlos", "554-1234",Entrega.DOMICILIO));


        Predicate<Pedido> entregaDomicilio = (u) -> u.getTipoentrega() == Entrega.DOMICILIO;
        List<Pedido> entregaDom = pedido
                .stream()
                .filter(entregaDomicilio)
                .filter((u) -> u.getTelefono().isPresent())
                .collect(Collectors.toList());

        Function<Pedido, String> imprimirPedido = (u) -> "\uD83D\uDCDE Confirmación enviada al cliente " + u.getCliente() + " con el número " +
                u.getTelefono().orElse("Numero no dispobible");

        entregaDom
                .stream()
                .map(imprimirPedido)
                .forEach(System.out::println);



    }
}

