package home.petshop.repository.jpa;

import home.petshop.entity.user.Address;
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
    public Address save(Address address) {
        if (address.isNew()) {
            em.persist(address);
            return address;
        }
        return em.merge(address);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        Query query = em.createQuery("DELETE FROM Address u WHERE u.id =:id");
        return query.setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Address get(int id) {
        return em.find(Address.class, id);
    }

    @Override
    public Address getByStreet(String street) {
        return em.createNamedQuery(Address.BY_STREET, Address.class)
                .setParameter(1, street)
                .getSingleResult();
    }

    @Override
    public List<Address> getAll() {
        return em.createNamedQuery(Address.ALL_SORTED, Address.class).getResultList();
    }
}
