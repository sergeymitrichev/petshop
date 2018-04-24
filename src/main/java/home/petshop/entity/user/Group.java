package home.petshop.entity.user;

import home.petshop.entity.AbstractNamedEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="GROUPS")
public class Group extends AbstractNamedEntity {
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_GROUP",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    protected List<User> users;

    public Group() {
    }

    public Group(Company c) {
        this(c.getId(), c.getName(), c.getUsers());
    }

    public Group(Integer id, String name, List<User> users) {
        super(id, name);
        this.users = users;
    }
}
