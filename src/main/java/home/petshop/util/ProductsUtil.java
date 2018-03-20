package home.petshop.util;

import home.petshop.entity.product.Product;

import java.util.Arrays;
import java.util.List;

public class ProductsUtil {
    public static final List<Product> PRODUCTS = Arrays.asList(
            new Product(100, true, "Product 1", 1),
            new Product(200, false, "Product 2", 2),
            new Product(300, true, "Product 3", 1)
    );
}
