package home.petshop.entity.product;

import home.petshop.entity.AbstractNamedEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ATTRIBUTES")
public class Attribute extends AbstractNamedEntity {

    @Column(name = "unit")
    private String unit;

    @Column(name = "type")
    private AttributeValueType type;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AttributeValue> attributeValues;

    public Attribute() {
    }

    public Attribute(Integer id, String name, String unit, AttributeValueType type, Set<AttributeValue> attributeValues) {
        super(id, name);
        this.unit = unit;
        this.type = type;
        this.attributeValues = attributeValues;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public AttributeValueType getType() {
        return type;
    }

    public void setType(AttributeValueType type) {
        this.type = type;
    }

    public Set<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Set<AttributeValue> values) {
        this.attributeValues = values;
    }
}
