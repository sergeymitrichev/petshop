package home.petshop.util;

import home.petshop.entity.product.Category;

import java.util.Arrays;
import java.util.List;

public class CategoriesUtil {
    public static final List<Category> CATEGORIES = Arrays.asList(
            new Category("Category 1"),
            new Category("Category 2"),
            new Category("Category 3")
    );
}
