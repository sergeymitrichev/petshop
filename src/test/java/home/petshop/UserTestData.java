package home.petshop;

import home.petshop.entity.user.User;

public class UserTestData {
    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;

    public static final User USER = new User("User");
    public static final User ADMIN = new User("Admin");
}
