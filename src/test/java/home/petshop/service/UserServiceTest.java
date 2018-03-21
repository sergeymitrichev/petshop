package home.petshop.service;

import home.petshop.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static home.petshop.UserTestData.USER;
import static home.petshop.UserTestData.USER_ID;
import static home.petshop.UserTestData.assertMatch;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDb.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceTest {


    @Autowired
    private UserService service;

    @Test
    public void create() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void get() throws Exception {
        User user = service.get(USER_ID);
        assertMatch(user, USER);
    }

    @Test
    public void getByEmail() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

}