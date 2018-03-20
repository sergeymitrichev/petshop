package java.home.petshop.repository.mock;

import home.petshop.entity.product.Product;
import home.petshop.repository.ProductRepository;
import home.petshop.util.ProductsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryProductRepository implements ProductRepository {
    private Map<Integer, Product> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        ProductsUtil.PRODUCTS.forEach(this::save);
    }

    @Override
    public Product save(Product product) {
        if (product.isNew()) {
            product.setId(counter.incrementAndGet());
            repository.put(product.getId(), product);
            return product;
        }
        return repository.computeIfPresent(product.getId(), (id, oldUser) -> product);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Product get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Product> list() {
        return new ArrayList<>(repository.values());
    }
}
