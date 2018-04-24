package home.petshop.entity.product;


import home.petshop.entity.AbstractBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ATTRIBUTE_VALUES")
public class AttributeValue<T> extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id")
    private int attributeId;

    @Column(name = "value")
    private T value;

    public AttributeValue() {
    }

    public AttributeValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
