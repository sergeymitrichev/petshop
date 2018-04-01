package home.petshop.repository;

import home.petshop.entity.user.Address;

import java.util.List;

public interface AddressRepository {
    Address save(Address address);

    boolean delete(int id);

    Address get(int id);

    Address getByStreet(String street);

    List<Address> getAll();
}
