package Programmeren2.Domain;

public class Webcast extends ContentItem{
    private int contentItemId;
    private Speaker speaker;
    public Webcast(int contentItemId, String publicationDate, String title, String descriptionl, Status status,
            int contentItemId2, Speaker speaker) {
        super(contentItemId, publicationDate, title, descriptionl, status);
        contentItemId = contentItemId2;
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
