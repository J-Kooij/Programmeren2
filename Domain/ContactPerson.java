package Programmeren2.Domain;

public class ContactPerson {
    private String contactPerson;
    private String emailContactPerson;
    
    public ContactPerson(String contactPerson, String emailContactPerson) {
        this.contactPerson = contactPerson;
        this.emailContactPerson = emailContactPerson;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmailContactPerson() {
        return emailContactPerson;
    }

    public void setEmailContactPerson(String emailContactPerson) {
        this.emailContactPerson = emailContactPerson;
    }

    
}
