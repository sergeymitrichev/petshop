package home.petshop.service;

import home.petshop.entity.product.Product;
import home.petshop.util.exception.NotFoundException;

import java.util.List;

public interface ProductService {
    public Product save(Product product);

    public void delete(int id) throws NotFoundException;

    public Product get(int id) throws NotFoundException;

    public Product getBySku(String sku) throws NotFoundException;

    public List<Product> list();

    public void update(Product product) throws NotFoundException;
}
