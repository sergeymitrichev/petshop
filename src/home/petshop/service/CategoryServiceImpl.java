package home.petshop.service;

import home.petshop.dao.CategoryDao;
import home.petshop.dao.ProductDao;
import home.petshop.entity.Category;
import home.petshop.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void createCategory(Category category) {
        this.categoryDao.createCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        this.categoryDao.updateCategory(category);
    }

    @Override
    public void deleteCategory(int id) {
        this.categoryDao.deleteCategory(id);
    }

    @Override
    public Category getCategoryById(int id) {
        return this.categoryDao.getCategoryById(id);
    }

    @Override
    public List<Category> listCategories() {
        return this.categoryDao.listCategories();
    }
}
