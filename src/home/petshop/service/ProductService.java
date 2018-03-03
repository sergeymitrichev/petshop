package home.petshop.service;

import home.petshop.entity.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    Product getProductById(int id);
    List<Product> listProducts();
}
