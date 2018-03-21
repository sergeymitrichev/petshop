package home.petshop.entity.product;

import home.petshop.entity.AbstractSeoEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
public class Category extends AbstractSeoEntity {

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products;

    public Category(int id, String name) {
        super(id, name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
