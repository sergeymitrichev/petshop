package home.petshop.dao;

import home.petshop.entity.Category;

import java.util.List;

public interface CategoryDao {
    void createCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    Category getCategoryById(int id);
    List<Category> listCategories();
}
