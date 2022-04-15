package Programmeren2.Domain;

public class Registration {
    private String registrationDate;
    private int certificateId;
    private String courseName;
    private String studentEmail;

    public Registration(String registrationDate, int certificateId, String courseName, String studentEmail) {
        this.registrationDate = registrationDate;
        this.certificateId = certificateId;
        this.courseName = courseName;
        this.studentEmail = studentEmail;
    }
    
    public String getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    public int getCertificateId() {
        return certificateId;
    }
    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    
}
