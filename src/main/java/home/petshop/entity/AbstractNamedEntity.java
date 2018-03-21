package home.petshop.entity;

public abstract class AbstractNamedEntity extends AbstractBaseEntity {
    protected String name;

    public AbstractNamedEntity() {

    }

    public AbstractNamedEntity(int id, String name) {
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
