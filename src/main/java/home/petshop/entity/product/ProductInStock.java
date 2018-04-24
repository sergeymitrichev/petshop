package home.petshop.entity.product;

import home.petshop.entity.AbstractBaseEntity;
import home.petshop.entity.AbstractNamedEntity;

public class ProductInStock extends AbstractBaseEntity {

    private Product product;
    private Stock stock;
    private Integer quantity;
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

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
