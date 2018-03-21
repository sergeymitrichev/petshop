package home.petshop.service;

import home.petshop.entity.product.Product;
import home.petshop.repository.ProductRepository;
import home.petshop.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Product get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public Product getBySku(String sku) throws NotFoundException {
        return null;
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public void update(Product product) throws NotFoundException {

    }

    public ProductRepository getRepository() {
        return repository;
    }
}
