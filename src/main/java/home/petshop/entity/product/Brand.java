package home.petshop.entity.product;

import home.petshop.entity.AbstractSeoEntity;

public class Brand extends AbstractSeoEntity {
    private Integer id;
    private String name;
    private String description;
    private String hgu;

    public Brand(int id, String name) {
        super(id, name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHgu() {
        return hgu;
    }

    public void setHgu(String hgu) {
        this.hgu = hgu;
    }
}
