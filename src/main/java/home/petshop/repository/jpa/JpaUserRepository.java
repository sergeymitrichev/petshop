package home.petshop.repository.jpa;

import home.petshop.entity.user.User;
import home.petshop.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaUserRepository implements UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        }
        return em.merge(user);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        Query query = em.createQuery("DELETE FROM User u WHERE u.id =:id");
        return query.setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User getByEmail(String email) {
        return em.createNamedQuery(User.BY_EMAIL, User.class)
                .setParameter(1, email)
                .getSingleResult();
    }

    //TODO Add getByPhone
    //TODO Add getByRole

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }
}
