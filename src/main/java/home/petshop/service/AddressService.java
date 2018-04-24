package home.petshop.service;

import home.petshop.entity.user.Address;
import home.petshop.util.exception.NotFoundException;

import java.util.List;

public interface AddressService {
    Address create(Address address, int userId);

    void delete(int id, int userId) throws NotFoundException;

    Address get(int id, int userId) throws NotFoundException;

    Address getByStreet(String street, int userId) throws NotFoundException;

    List<Address> getAll(int userId);

    void update(Address address, int userId) throws NotFoundException;
}
