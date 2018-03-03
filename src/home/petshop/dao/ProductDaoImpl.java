package home.petshop.dao;

import home.petshop.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private SessionFactory sessionFactory;

    @Override
    public void createProduct(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);

        if (product != null) {
            session.delete(product);
        }
    }

    @Override
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> listProducts() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Product");

        return (List<Product>) query.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
