package home.petshop.repository;

import home.petshop.entity.product.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    Product save(Product product);

    boolean delete(int id);

    Product get(int id);

    List<Product> list();
}
