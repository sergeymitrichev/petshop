package home.petshop.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="COMPANIES")
public class Company extends Group {

    public Company() {
    }

    public Company(Company c) {
        this(c.getId(), c.getName(), c.getUsers());
    }

    public Company(Integer id, String name, List<User> users) {
        super(id, name, users);
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
