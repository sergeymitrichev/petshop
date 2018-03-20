package home.petshop.entity.product;

import home.petshop.entity.AbstractNamedEntity;

public class ProductInStock extends AbstractNamedEntity {
    private Integer id;
    private String name;
    private Product product;
    private Stock stock;
    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
