package home.petshop.service;

import home.petshop.entity.User;
import home.petshop.repository.UserRepository;
import home.petshop.util.exception.NotFoundException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public User get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public void update(User user) throws NotFoundException {

    }
}
