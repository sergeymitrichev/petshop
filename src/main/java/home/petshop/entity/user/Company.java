package home.petshop.entity.user;

import home.petshop.entity.AbstractNamedEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="COMPANIES")
public class Company extends AbstractNamedEntity {

    @OneToMany(mappedBy = "company")
    private List<User> users;

    public Company() {
    }

    public Company(Company c) {
        this(c.getId(), c.getName(), c.getUsers());
    }

    public Company(Integer id, String name, List<User> users) {
        super(id, name);
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
