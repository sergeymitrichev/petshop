package home.petshop.entity;

public class NamedEntity extends BaseEntity {
    protected String name;

    public NamedEntity() {
    }

    public NamedEntity(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
