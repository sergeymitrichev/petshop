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
    public Address create(Address address) {
        Assert.notNull(address, "address must not be null");
        return repository.save(address);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Address get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public Address getByStreet(String street) throws NotFoundException {
        Assert.notNull(street, "street must not be null");
        return checkNotFound(repository.getByStreet(street), "street=" + street);
    }

    @Override
    public List<Address> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Address address) throws NotFoundException {
        Assert.notNull(address, "address must not be null");
        checkNotFoundWithId(repository.save(address), address.getId());
    }
}
