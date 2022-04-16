package Programmeren2.Domain;

import java.sql.Date;

public class Registration {
    private Date registrationDate;
    private Course course;
    private Student student;

    public Registration(Date registrationDate, Course course, Student student) {
        this.registrationDate = registrationDate;
        this.course = course;
        this.student = student;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    
}
