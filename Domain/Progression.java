package Programmeren2.Domain;

public class Progression {
    Student student;
    ContentItem contentItem;
    int percentage;
    
    public Progression(Student student, ContentItem contentItem, int percentage) {
        this.student = student;
        this.contentItem = contentItem;
        this.percentage = percentage;
    }

    public Progression(ContentItem contentItem, int percentage) {
        this.contentItem = contentItem;
        this.percentage = percentage;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public ContentItem getContentItem() {
        return contentItem;
    }
    public void setContentItem(ContentItem contentItem) {
        this.contentItem = contentItem;
    }
    public int getPercentage() {
        return percentage;
    }
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    
}
