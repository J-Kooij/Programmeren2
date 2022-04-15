package Programmeren2.Domain;

public class Module {
    private int version;
    private int contentItemId;
    private ContactPerson contactPerson;
    
    public Module(int version, int contentItemId, ContactPerson contactPerson) {
        this.version = version;
        this.contentItemId = contentItemId;
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
