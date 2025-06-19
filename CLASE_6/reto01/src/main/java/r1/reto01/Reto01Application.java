package r1.reto01;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Reto01Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto01Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductoRepository repository) {
		return (args) -> {
			repository.save(new Producto("Laptop Lenovo", "Portátil de alto rendimiento", 12500));
			repository.save(new Producto("Teclado Mecánico", "Switch azul retroiluminado", 950));
			repository.save(new Producto("Mouse Logitech", "Mouse inalámbrico", 350));
			repository.save(new Producto("Monitor", "Pantalla LED 24 pulgadas", 3200));

			System.out.println("\n📦 Productos con precio mayor a 500:");
			repository.findByPrecioGreaterThan(500).forEach(System.out::println);

			System.out.println("\n🔍 Productos que contienen 'lap':");
			repository.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

			System.out.println("\n🎯 Productos con precio entre 400 y 1000:");
			repository.findByPrecioBetween(400, 1000).forEach(System.out::println);

			System.out.println("\n📘 Productos cuyo nombre empieza con 'm':");
			repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
		};
	}
}