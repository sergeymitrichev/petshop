package home.petshop.repository.mock;

import home.petshop.entity.product.Product;
import home.petshop.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MockProductRepository implements ProductRepository {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> list() {
        return null;
    }
}
