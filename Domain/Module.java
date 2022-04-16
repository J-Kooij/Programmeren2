package Programmeren2.Domain;

import java.util.Date;

public class Module extends ContentItem{
    private int version;
    private ContactPerson contactPerson;
    

    public Module(int contentItemId, Date publicationDate, String title, String description, Status status,
            int version, ContactPerson contactPerson) {
        super(contentItemId, publicationDate, title, description, status);
        this.version = version;
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
