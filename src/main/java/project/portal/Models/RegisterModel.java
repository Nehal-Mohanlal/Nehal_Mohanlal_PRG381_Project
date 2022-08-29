package project.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Register")
public class RegisterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long registerId; 
    
    @Column(name = "regStudentFirstName") 
    private String regStudentFirstName; 

    @Column(name = "regStudentLastName") 
    private String regStudentLastName; 

    @Column(name = "regStudentEmail") 
    private String regStudentEmail; 

    @Column(name = "regStudentPassword") 
    private String regStudentPassword; 
    
    @Column(name = "regCourseName") 
    private String regCourseName;


    
    public RegisterModel(){

    }

    public RegisterModel(long registerId, String regStudentFirstName, String regStudentLastName, String regStudentEmail,
            String regStudentPassword, String regCourseName) {
        this.registerId = registerId;
        this.regStudentFirstName = regStudentFirstName;
        this.regStudentLastName = regStudentLastName;
        this.regStudentEmail = regStudentEmail;
        this.regStudentPassword = regStudentPassword;
        this.regCourseName = regCourseName;
    }

    public long getRegisterId() {
        return registerId;
    }
    public void setRegisterId(long registerId) {
        this.registerId = registerId;
    }
    public String getRegStudentFirstName() {
        return regStudentFirstName;
    }
    public void setRegStudentFirstName(String regStudentFirstName) {
        this.regStudentFirstName = regStudentFirstName;
    }
    public String getRegStudentLastName() {
        return regStudentLastName;
    }
    public void setRegStudentLastName(String regStudentLastName) {
        this.regStudentLastName = regStudentLastName;
    }
    public String getRegStudentEmail() {
        return regStudentEmail;
    }
    public void setRegStudentEmail(String regStudentEmail) {
        this.regStudentEmail = regStudentEmail;
    }
    public String getRegStudentPassword() {
        return regStudentPassword;
    }
    public void setRegStudentPassword(String regStudentPassword) {
        this.regStudentPassword = regStudentPassword;
    }
    public String getRegCourseName() {
        return regCourseName;
    }
    public void setRegCourseName(String regCourseName) {
        this.regCourseName = regCourseName;
    } 


}
