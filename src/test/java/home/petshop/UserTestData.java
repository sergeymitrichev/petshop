package home.petshop;


import home.petshop.entity.user.Role;
import home.petshop.entity.user.User;

import java.util.Arrays;

import static home.petshop.entity.user.Role.ROLE_ADMIN;
import static home.petshop.entity.user.Role.ROLE_USER;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTestData {
    public static final int USER_ID = 100000;
    public static final int ADMIN_ID = USER_ID + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "79200226482", "password", ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "user@yandex.ru", "79101451000", "admin", ROLE_ADMIN);

    public static void assertMatch(User actual, User expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "registered", "roles");
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("registered", "roles").isEqualTo(expected);
    }
}
