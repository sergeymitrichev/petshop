package home.petshop.entity.product;

import home.petshop.entity.AbstractNamedEntity;

import java.util.List;

public class Stock extends AbstractNamedEntity {

    private List<ProductInStock> products;

    public List<ProductInStock> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInStock> products) {
        this.products = products;
    }
}
