package home.petshop.util;

import home.petshop.entity.user.User;

import java.util.Arrays;
import java.util.List;

public class UsersUtil {
    public static final List<User> USERS = Arrays.asList(
            new User("Vasya"),
            new User("Igor"),
            new User("Nastya")
    );
}
