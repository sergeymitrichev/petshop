package home.petshop.service;

import home.petshop.entity.product.Category;

import java.util.List;

public interface CategoryService {
    void createCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    Category getCategoryById(int id);
    List<Category> listCategories();
}
