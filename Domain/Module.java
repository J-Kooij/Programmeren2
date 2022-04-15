package Programmeren2.Domain;

public class Module {
    private int version;
    private int contentItemId;
    private String contactPerson;
    public Module(int version, int contentItemId, String contactPerson) {
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
    public String getContactPerson() {
        return contactPerson;
    }
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
    
}
