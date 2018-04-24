package home.petshop.entity.user;

import home.petshop.entity.AbstractBaseEntity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Address.DELETE, query = "DELETE FROM Address a WHERE a.id=:id"),
        @NamedQuery(name = Address.BY_STREET, query = "SELECT a FROM Address a WHERE a.street=?1 AND a.user.id=?2"),
        @NamedQuery(name = Address.ALL_SORTED, query = "SELECT a FROM Address a WHERE a.user.id=?1 ORDER BY a.postal")
})
@Entity
@Table(name = "USER_ADDRESSES")
public class Address extends AbstractBaseEntity {

    public static final String DELETE = "Address.delete";
    public static final String BY_STREET = "Address.getByStreet";
    public static final String ALL_SORTED = "Address.getAllSorted";

    @Column(name = "postal", nullable = false)
    private Integer postal;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house", nullable = false)
    private String house;

    @Column(name = "flat")
    private Integer flat;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Address(Address a) {
        this(a.getId(), a.getPostal(), a.getCity(), a.getStreet(), a.getHouse(), a.getFlat(), a.floor, a.getDescription(), a.getUser());
    }

    public Address(Integer id, Integer postal, String city, String street, String house, Integer flat, Integer floor, String description, User user) {
        super(id);
        this.postal = postal;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.floor = floor;
        this.description = description;
        this.user = user;
    }

    public Address(Integer id, Integer postal, String city, String street, String house, Integer flat, Integer floor, String description) {
        super(id);
        this.postal = postal;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.floor = floor;
        this.description = description;
    }

    public Address() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPostal() {
        return postal;
    }

    public void setPostal(Integer postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                "postal=" + postal +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", flat=" + flat +
                ", floor=" + floor +
                ", description='" + description + '\'' +
                ", user=" + user.getEmail() +
                '}';
    }
}
