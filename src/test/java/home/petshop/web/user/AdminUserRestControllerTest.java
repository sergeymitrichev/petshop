package home.petshop.web.user;

import home.petshop.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminUserRestControllerTest {

    @Autowired
    private AdminRestController controller;

    @Test
    public void testCreate() throws Exception {
        //controller.create(new User("Name1"));
    }

    @Test
    public void testDelete() throws Exception {
        controller.delete(7);
    }

    @Test
    public void testDeleteNotFound() throws Exception {
        controller.delete(0);
    }
}