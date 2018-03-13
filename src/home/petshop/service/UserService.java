package home.petshop.service;

import home.petshop.entity.User;
import home.petshop.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    public User save(User user);

    public void delete(int id) throws NotFoundException;

    public User get(int id) throws NotFoundException;

    public User getByEmail(String email) throws NotFoundException;

    public List<User> list();

    public void update(User user) throws NotFoundException;
}
