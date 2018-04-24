package home.petshop.repository.datajpa;

import home.petshop.entity.user.Address;
import home.petshop.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataJpaAddressRepositoryImpl implements AddressRepository {

    @Autowired
    private CrudAddressRepository crudRepository;

    @Override
    public Address save(Address address, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public Address get(int id, int userId) {
        return null;
    }

    @Override
    public Address getByStreet(String street, int userId) {
        return null;
    }

    @Override
    public List<Address> getAll(int userId) {
        return null;
    }
}
