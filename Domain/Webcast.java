package Programmeren2.Domain;

public class Webcast extends ContentItem{
    private Speaker speaker;


    public Webcast(int contentItemId, String publicationDate, String title, String description, Status status,
            Speaker speaker) {
        super(contentItemId, publicationDate, title, description, status);
        this.speaker = speaker;
    }
    
    public int getContentItemId() {
        return contentItemId;
    }
    public void setContentItemId(int contentItemId) {
        this.contentItemId = contentItemId;
    }
    public Speaker getSpeaker() {
        return speaker;
    }
    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }
    
}
