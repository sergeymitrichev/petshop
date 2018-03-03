package home.petshop.service;

import home.petshop.dao.ProductDao;
import home.petshop.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void createProduct(Product product) {
        this.productDao.createProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        this.productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        this.productDao.deleteProduct(id);
    }

    @Override
    public Product getProductById(int id) {
        return this.productDao.getProductById(id);
    }

    @Override
    public List<Product> listProducts() {
        return this.productDao.listProducts();
    }
}
