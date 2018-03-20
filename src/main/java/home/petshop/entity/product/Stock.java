package home.petshop.entity.product;

import home.petshop.entity.AbstractNamedEntity;

import java.util.List;

public class Stock extends AbstractNamedEntity {
    private Integer id;
    private String name;
    private List<ProductInStock> products;

}
