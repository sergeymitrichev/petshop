package home.petshop.repository.jpa;

import home.petshop.entity.user.Address;
import home.petshop.entity.user.User;
import home.petshop.repository.AddressRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaAddressRepository implements AddressRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Address save(Address address, int userId) {
        if (!address.isNew() && get(address.getId(), userId) == null) {
            return null;
        }
        address.setUser(em.getReference(User.class, userId));
        if (address.isNew()) {
            em.persist(address);
            return address;
        }
        return em.merge(address);
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        Query query = em.createQuery("DELETE FROM Address a WHERE a.id =:id AND a.user.id = :userId");
        return query
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate() != 0;
    }

    @Override
    public Address get(int id, int userId) {
        Address address = em.find(Address.class, id);
        return address != null && address.getUser().getId() == userId ? address : null;
    }

    @Override
    public Address getByStreet(String street, int userId) {
        return em.createNamedQuery(Address.BY_STREET, Address.class)
                .setParameter(1, street)
                .setParameter(2, userId)
                .getSingleResult();
    }

    @Override
    public List<Address> getAll(int userId) {
        return em.createNamedQuery(Address.ALL_SORTED, Address.class)
                .setParameter(1, userId)
                .getResultList();
    }
}
