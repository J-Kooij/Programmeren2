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
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return super.getDescription();
    }
    @Override
    public Date getPublicationDate() {
        // TODO Auto-generated method stub
        return super.getPublicationDate();
    }
    @Override
    public Status getStatus() {
        // TODO Auto-generated method stub
        return super.getStatus();
    }
    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return super.getTitle();
    }
    @Override
    public void setDescription(String description) {
        // TODO Auto-generated method stub
        super.setDescription(description);
    }
    @Override
    public void setPublicationDate(Date publicationDate) {
        // TODO Auto-generated method stub
        super.setPublicationDate(publicationDate);
    }
    @Override
    public void setStatus(Status status) {
        // TODO Auto-generated method stub
        super.setStatus(status);
    }
    @Override
    public void setTitle(String title) {
        // TODO Auto-generated method stub
        super.setTitle(title);
    }
    
}
