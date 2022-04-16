package Programmeren2.Domain;

public abstract class ContentItem {
    protected int contentItemId;
    private String publicationDate;
    private String title;
    private String description;
    private Status status;
    public ContentItem(int contentItemId, String publicationDate, String title, String description, Status status) {
        this.contentItemId = contentItemId;
        this.publicationDate = publicationDate;
        this.title = title;
        this.description = description;
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
        return description;
    }
    public void setDescriptionl(String descriptionl) {
        this.description = descriptionl;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
}
