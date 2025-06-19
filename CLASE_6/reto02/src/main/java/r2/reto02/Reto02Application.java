package r2.reto02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Reto02Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto02Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo, MarcaRepository marcaRepo) {
		return args -> {
			Categoria tecnologia = new Categoria("Tecnología");
			categoriaRepo.save(tecnologia);

			Marca apple = new Marca("Apple");
			Marca samsung = new Marca("Samsung");
			marcaRepo.save(apple);
			marcaRepo.save(samsung);

			productoRepo.save(new Producto("iPhone 15", "Smartphone Apple", 28000.00, tecnologia, apple));
			productoRepo.save(new Producto("iPad Pro", "Tablet Apple", 32000.00, tecnologia, apple));
			productoRepo.save(new Producto("Galaxy S23", "Smartphone Samsung", 25000.00, tecnologia, samsung));
			productoRepo.save(new Producto("Smart TV", "Televisor Samsung 50\"", 18000.00, tecnologia, samsung));

			System.out.println("\n📚 Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("🏷️ " + marca.getNombre() + ":");
				productoRepo.findByMarcaId(marca.getId())
						.forEach(p -> System.out.println("   - " + p.getNombre()));
			});
		};
	}
}