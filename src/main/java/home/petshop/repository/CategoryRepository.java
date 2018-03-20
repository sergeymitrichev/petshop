package home.petshop.repository;

import home.petshop.entity.product.Category;
import home.petshop.entity.user.User;

import java.util.List;

public interface CategoryRepository {
    Category save(Category user);

    boolean delete(int id);

    Category get(int id);

    List<Category> list();
}
