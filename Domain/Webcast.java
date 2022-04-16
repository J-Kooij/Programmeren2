package Programmeren2.Domain;

import java.util.Date;

public class Webcast extends ContentItem{
    private Speaker speaker;


    public Webcast(int contentItemId, Date publicationDate, String title, String description, Status status,
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

    @Override
    public String getDescriptionl() {
        // TODO Auto-generated method stub
        return super.getDescriptionl();
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
    public void setDescriptionl(String descriptionl) {
        // TODO Auto-generated method stub
        super.setDescriptionl(descriptionl);
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
