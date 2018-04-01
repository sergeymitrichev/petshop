package home.petshop.service;

import home.petshop.entity.user.Address;
import home.petshop.util.exception.NotFoundException;

import java.util.List;

public interface AddressService {
    Address create(Address address);

    void delete(int id) throws NotFoundException;

    Address get(int id) throws NotFoundException;

    Address getByStreet(String street) throws NotFoundException;

    List<Address> getAll();

    void update(Address address) throws NotFoundException;
}
