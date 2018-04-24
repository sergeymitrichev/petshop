package home.petshop.service;

import home.petshop.entity.user.Address;
import home.petshop.entity.user.User;
import home.petshop.repository.AddressRepository;
import home.petshop.repository.UserRepository;
import home.petshop.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static home.petshop.util.ValidationUtil.checkNotFound;
import static home.petshop.util.ValidationUtil.checkNotFoundWithId;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address create(Address address, int userId) {
        Assert.notNull(address, "address must not be null");
        return repository.save(address, userId);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public Address get(int id, int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public Address getByStreet(String street, int userId) throws NotFoundException {
        Assert.notNull(street, "street must not be null");
        return checkNotFound(repository.getByStreet(street, userId), "street=" + street);
    }

    @Override
    public List<Address> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public void update(Address address, int userId) throws NotFoundException {
        Assert.notNull(address, "address must not be null");
        checkNotFoundWithId(repository.save(address, userId), address.getId());
    }
}
