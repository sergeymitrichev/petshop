package home.petshop.service;

import home.petshop.ActiveDbProfileResolver;
import home.petshop.Profiles;
import home.petshop.entity.user.Address;
import home.petshop.util.exception.NotFoundException;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static home.petshop.AddressTestData.*;
import static home.petshop.UserTestData.ADMIN_ID;
import static home.petshop.UserTestData.USER;
import static home.petshop.UserTestData.USER_ID;
import static org.slf4j.LoggerFactory.getLogger;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles(resolver = ActiveDbProfileResolver.class)
public class AddressServiceTest {
    private static final Logger log = getLogger("result");

    private static StringBuilder results = new StringBuilder();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    // http://stackoverflow.com/questions/14892125/what-is-the-best-practice-to-determine-the-execution-time-of-the-bussiness-relev
    public Stopwatch stopwatch = new Stopwatch() {
        @Override
        protected void finished(long nanos, Description description) {
            String result = String.format("\n%-25s %7d", description.getMethodName(), TimeUnit.NANOSECONDS.toMillis(nanos));
            results.append(result);
            log.info(result + " ms\n");
        }
    };
    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @AfterClass
    public static void printResult() {
        log.info("\n---------------------------------" +
                "\nTest                 Duration, ms" +
                "\n---------------------------------" +
                results +
                "\n---------------------------------");
    }

    @Autowired
    private AddressService service;

    @Test
    public void create() throws Exception {
        Address newAddress = new Address(null, 603123, "Нижний Новгород", "Уличная", "3А", 124, 5, "Описание");
        Address created = service.create(newAddress, USER_ID);
        newAddress.setId(created.getId());
        assertMatch(service.getAll(USER_ID), ADDRESS3, ADDRESS1, newAddress);
    }

    @Test(expected = PersistenceException.class)
    public void duplicateAddressCreate() throws Exception {
        service.create(new Address(null, 603123, "Нижний Новгород", "Уличная", "2А", 124, 5, "Направо, налево"), USER_ID);
    }

    @Test
    public void delete() throws Exception {
        service.delete(ADDRESS1_ID, USER_ID);
        assertMatch(service.getAll(USER_ID), ADDRESS3);
    }

    @Test
    public void deleteNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.delete(ADDRESS1_ID, ADMIN_ID);
    }


    @Test(expected = NotFoundException.class)
    public void notFoundDelete() throws Exception {
        service.delete(0, USER_ID);
    }

    @Test
    public void get() throws Exception {
        Address address = service.get(ADDRESS1_ID, USER_ID);
        assertMatch(address, ADDRESS1);
    }

    @Test
    public void getNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        service.get(0, USER_ID);
    }

    @Test
    public void update() throws Exception {
        Address updated = new Address(ADDRESS1);
        updated.setStreet("NewStreet");
        service.update(updated, USER_ID);
        assertMatch(service.get(ADDRESS1_ID, USER_ID), updated);
    }

    @Test
    public void updateNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id=" + ADDRESS1_ID);
        service.update(ADDRESS1, ADMIN_ID);
    }

    @Test
    public void getAll() throws Exception {
        List<Address> all = service.getAll(USER_ID);
        assertMatch(all, ADDRESS3, ADDRESS1);
    }
}