package home.petshop.repository;

import home.petshop.entity.Product;

public interface ProductRepository {
    Product save(Product product);

    boolean delete(int id);

    Product get(int id);


}
