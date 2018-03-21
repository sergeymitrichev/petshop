package home.petshop.entity;

public abstract class AbstractSeoEntity extends AbstractNamedEntity {
    private String title;
    private String metaDescription;
    private String metaKeywords;

    public AbstractSeoEntity(int id, String name) {
        super(id, name);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }
}
