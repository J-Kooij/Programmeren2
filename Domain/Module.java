package Programmeren2.Domain;

public class Module extends ContentItem{
    private int version;
    private int contentItemId;
    private ContactPerson contactPerson;
    
    public Module(int contentItemId, String publicationDate, String title, String descriptionl, Status status,
            int version, int contentItemId2, ContactPerson contactPerson) {
        super(contentItemId, publicationDate, title, descriptionl, status);
        this.version = version;
        contentItemId = contentItemId2;
        this.contactPerson = contactPerson;
    }

    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public int getContentItemId() {
        return contentItemId;
    }
    public void setContentItemId(int contentItemId) {
        this.contentItemId = contentItemId;
    }
    public ContactPerson getContactPerson() {
        return contactPerson;
    }
    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }
    
}
