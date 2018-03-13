package home.petshop;

import home.petshop.entity.Role;

import java.util.Set;

public class LoggedUser {
    protected int id;
    protected Set<Role> roles;
    protected boolean enabled;

    public int getId() {
        return id;
    }
}
