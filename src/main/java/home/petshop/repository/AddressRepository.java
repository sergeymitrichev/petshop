package home.petshop.repository;

import home.petshop.entity.user.Address;

import java.util.List;

public interface AddressRepository {
    Address save(Address address, int userId);

    boolean delete(int id, int userId);

    Address get(int id, int userId);

    Address getByStreet(String street, int userId);

    List<Address> getAll(int userId);
}
