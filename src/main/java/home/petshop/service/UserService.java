package home.petshop.service;

import home.petshop.entity.user.User;
import home.petshop.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user) throws NotFoundException;
}
