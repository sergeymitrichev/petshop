package home.petshop;


import home.petshop.entity.user.Address;
import home.petshop.entity.user.User;

import java.util.Arrays;

import static home.petshop.UserTestData.ADMIN;
import static home.petshop.UserTestData.USER;
import static home.petshop.entity.user.Role.ROLE_ADMIN;
import static home.petshop.entity.user.Role.ROLE_USER;
import static org.assertj.core.api.Assertions.assertThat;

public class AddressTestData {
    public static final int ADDRESS1_ID = 1;
    public static final int ADDRESS2_ID = 2;
    public static final int ADDRESS3_ID = 3;

    public static final Address ADDRESS1 = new Address(ADDRESS1_ID, 123456, "Нижний Новгород", "Уличная", "2А", 124, 5, "Направо, налево", USER);
    public static final Address ADDRESS2 = new Address(ADDRESS2_ID, 123351, "Москва", "Проспектная", "12А/2", 24, 12, null, ADMIN);
    public static final Address ADDRESS3 = new Address(ADDRESS3_ID, 123351, "Москва", "Проспектная", "12А/2", 24, 12, null, USER);

    public static void assertMatch(Address actual, Address expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static void assertMatch(Iterable<Address> actual, Address... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Address> actual, Iterable<Address> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user").isEqualTo(expected);
    }
}
