package home.petshop.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity {
    @NotEmpty
    @Column(name = "name", nullable = false)
    protected String name;

    public AbstractNamedEntity() {

    }

    public AbstractNamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ". " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
