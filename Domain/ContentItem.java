package Programmeren2.Domain;

public abstract class ContentItem {
    private int contentItemId;
    private String publicationDate;
    private String title;
    private String descriptionl;
    private Status status;
    public ContentItem(int contentItemId, String publicationDate, String title, String descriptionl, Status status) {
        this.contentItemId = contentItemId;
        this.publicationDate = publicationDate;
        this.title = title;
        this.descriptionl = descriptionl;
        this.status = status;
    }
    public int getContentItemId() {
        return contentItemId;
    }
    public void setContentItemId(int contentItemId) {
        this.contentItemId = contentItemId;
    }
    public String getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescriptionl() {
        return descriptionl;
    }
    public void setDescriptionl(String descriptionl) {
        this.descriptionl = descriptionl;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
}
