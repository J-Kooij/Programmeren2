package Programmeren2.Domain;

public class Webcast {
    private int contentItemId;
    private Speaker speaker;
    public Webcast(int contentItemId, Speaker speaker) {
        this.contentItemId = contentItemId;
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
