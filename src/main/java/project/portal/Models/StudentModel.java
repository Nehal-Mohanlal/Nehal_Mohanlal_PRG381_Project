package project.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class StudentModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId; 

    @Column(name = "studentFirstName")
    private String studentFirstName; 
    
    @Column(name = "studentLasttName")
    private String studentLastName; 

    @Column(name = "studentAddress")
    private String studentAddress;

    @Column(name = "studentEmail") 
    private String studentEmail;

    @Column(name = "studentPassword")
    private String studentPassword;

    public StudentModel(){

    }
    
    public StudentModel(long studentId, String studentFirstName, String studentLastName, String studentAddress,
            String studentEmail, String studentPassword) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentAddress = studentAddress;
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
    }

    public long getStudentId() {
        return studentId;
    }
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    public String getStudentFirstName() {
        return studentFirstName;
    }
    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }
    public String getStudentLastName() {
        return studentLastName;
    }
    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
    public String getStudentAddress() {
        return studentAddress;
    }
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    public String getStudentPassword() {
        return studentPassword;
    }
    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    } 


}
