package inc.skt.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import inc.skt.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String name);

}
