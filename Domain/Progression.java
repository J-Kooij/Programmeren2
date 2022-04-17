package Programmeren2.Domain;

public class Progression {
    Student student;
    Course course;
    int percentage;
    
    public Progression(Student student, Course course, int percentage) {
        this.student = student;
        this.course = course;
        this.percentage = percentage;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public int getPercentage() {
        return percentage;
    }
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    
}
