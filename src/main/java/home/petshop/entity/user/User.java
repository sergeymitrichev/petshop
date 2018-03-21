package home.petshop.entity.user;

import home.petshop.entity.AbstractNamedEntity;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class User extends AbstractNamedEntity {

    private String email;

    private String password;

    private String phone;

    private Date registered = new Date();

    private Boolean enabled = true;

    private Set<Role> roles;

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPhone(), u.getPassword(), u.isEnabled(), u.getRegistered(), u.getRoles());
    }

    public User(Integer id, String name, String email, String phone, String password, Role role, Role... roles) {
        this(id, name, email, phone, password, true, new Date(), EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String phone, String password, boolean enabled, Date registered, Collection<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.enabled = enabled;
        this.registered = registered;
        setRoles(roles);
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
    }
}
