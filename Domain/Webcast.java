package Programmeren2.Domain;

import java.util.Date;


public class Webcast extends ContentItem{
    private Speaker speaker;
    private int lengthInMinute;
    private String url;
    
    public Webcast(int contentItemId, Date publicationDate, String title, String description, Status status,
            Speaker speaker, int lengthInMinute, String url) {
        super(contentItemId, publicationDate, title, description, status);
        this.speaker = speaker;
        this.lengthInMinute = lengthInMinute;
        this.url = url;
    }

    public int getLengthInMinute(){
        return this.lengthInMinute;
    }
    public int setLengthInMinute(int lengthInMinute){
        return this.lengthInMinute = lengthInMinute;
    }
    public String getUrl(){
        return this.url;
    }
    public String setUrl(String url){
        return this.url = url;
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
