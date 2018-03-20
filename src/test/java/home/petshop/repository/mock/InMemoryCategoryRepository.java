package java.home.petshop.repository.mock;

import home.petshop.entity.product.Category;
import home.petshop.repository.CategoryRepository;
import home.petshop.util.CategoriesUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryCategoryRepository implements CategoryRepository {
    private Map<Integer, Category> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        CategoriesUtil.CATEGORIES.forEach(this::save);
    }

    @Override
    public Category save(Category category) {
        if (category.isNew()) {
            category.setId(counter.incrementAndGet());
            repository.put(category.getId(), category);
            return category;
        }
        return repository.computeIfPresent(category.getId(), (id, oldCategory) -> category);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public Category get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Category> list() {
        return new ArrayList<>(repository.values());
    }
}
