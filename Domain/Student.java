package Programmeren2.Domain;

public class Student{
    private String name;
    private String email;
    private String gender;
    private String birthDate;
    private String password;
    private String address;
    private String city;
    private String country;
    private int studentId;


    public Student(String name, String email, String gender, String birthDate, String password, String address, String city, String country, int studentId){
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.password = password;
        this.address = address;
        this.city = city;
        this.country = country;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

 
}