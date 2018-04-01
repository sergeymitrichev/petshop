package home.petshop.service;

import home.petshop.entity.user.Address;
import home.petshop.util.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import java.util.List;

import static home.petshop.AddressTestData.*;
import static home.petshop.UserTestData.USER;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class AddressServiceTest {

    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private AddressService service;

    @Test
    public void create() throws Exception {
        Address newAddress = new Address(null, 603123, "Нижний Новгород", "Уличная", "3А", 124, 5, "Описание", USER);
        Address created = service.create(newAddress);
        newAddress.setId(created.getId());
        assertMatch(service.getAll(), ADDRESS2, ADDRESS3, ADDRESS1, newAddress);
    }

    @Test(expected = PersistenceException.class)
    public void duplicateAddressCreate() throws Exception {
        service.create(new Address(null, 603123, "Нижний Новгород", "Уличная", "2А", 124, 5, "Направо, налево", USER));
    }

    @Test
    public void delete() throws Exception {
        service.delete(ADDRESS1_ID);
        assertMatch(service.getAll(), ADDRESS2, ADDRESS3);
    }

    @Test(expected = NotFoundException.class)
    public void notFoundDelete() throws Exception {
        service.delete(0);
    }

    @Test
    public void get() throws Exception {
        Address address = service.get(ADDRESS1_ID);
        assertMatch(address, ADDRESS1);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() throws Exception {
        service.get(0);
    }

    @Test
    public void getByStreet() throws Exception {
        Address address = service.getByStreet("Уличная");
        assertMatch(address, ADDRESS1);
    }

    @Test
    public void update() throws Exception {
        Address updated = new Address(ADDRESS1);
        updated.setStreet("NewStreet");
        service.update(updated);
        assertMatch(service.get(ADDRESS1_ID), updated);
    }

    @Test
    public void getAll() throws Exception {
        List<Address> all = service.getAll();
        assertMatch(all, ADDRESS2, ADDRESS3, ADDRESS1);
    }
}