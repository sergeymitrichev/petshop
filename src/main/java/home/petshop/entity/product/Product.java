package home.petshop.entity.product;

import home.petshop.entity.AbstractSeoEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//@Entity
//@Table(name = "PRODUCT", uniqueConstraints = {@UniqueConstraint(columnNames = "SKU", name = "UNIQUE_SKU")})
public class Product extends AbstractSeoEntity {

    //@Column(name = "EXTERNAL_ID")
    private int externalId;

    //@Column(name = "PRICE")
    private int price;

    //@Column(name = "PRICE_IN")
    private int priceIn;

    @Column(name = "PRICE_OLD")
    private int priceOld;

    @Column(name = "WEIGHT")
    private int weight;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "WARRANTY")
    private String warranty;

    private Integer categoryId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_CATEGORY", joinColumns = {
            @JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID",
                    nullable = false, updatable = false) })
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_IN_STOCK", joinColumns = {
            @JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "STOCK_ID",
                    nullable = false, updatable = false) })
    private Set<Stock> stocks;

    public Product(int id, int price, boolean isActive, String name, Integer categoryId) {
        super(id, name);
        this.price = price;
        this.isActive = isActive;
        this.name = name;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", isActive=" + isActive +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    /*
        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "PRODUCT_ATTRIBUTE", joinColumns = {
                @JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false) },
                inverseJoinColumns = { @JoinColumn(name = "ATTRIBUTE_ID",
                        nullable = false, updatable = false) })
        private List<Attribute> attributes;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "PRODUCT_IMAGE", joinColumns = {
                @JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false) },
                inverseJoinColumns = { @JoinColumn(name = "IMAGE_ID",
                        nullable = false, updatable = false) })
        private List<Image> images;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "PRODUCT_MODIFICATION", joinColumns = {
                @JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false) },
                inverseJoinColumns = { @JoinColumn(name = "MODIFICATION_ID",
                        nullable = false, updatable = false) })
        private List<Modification> modifications;


    */

    public int getExternalId() {
        return externalId;
    }

    public void setExternalId(int externalId) {
        this.externalId = externalId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(int priceIn) {
        this.priceIn = priceIn;
    }

    public int getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(int priceOld) {
        this.priceOld = priceOld;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
/*
    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modification> modifications) {
        this.modifications = modifications;
    }

   */
}
