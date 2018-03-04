package home.petshop.dao;

import home.petshop.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(category);
    }

    @Override
    public void updateCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
    }

    @Override
    public void deleteCategory(int id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, id);

        if(category != null) {
            session.delete(category);
        }
    }

    @Override
    public Category getCategoryById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> listCategories() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Category");
        return (List<Category>) query.list();
    }
}
