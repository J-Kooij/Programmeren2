package Programmeren2.Domain;

public class Speaker {
    private String speakerName;
    private String organisationOfSpeaker;
    
    public Speaker(String speakerName, String organisationOfSpeaker) {
        this.speakerName = speakerName;
        this.organisationOfSpeaker = organisationOfSpeaker;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getOrganisationOfSpeaker() {
        return organisationOfSpeaker;
    }

    public void setOrganisationOfSpeaker(String organisationOfSpeaker) {
        this.organisationOfSpeaker = organisationOfSpeaker;
    }

    
}
