package project.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Administrator")
public class AdminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long adminId; 

    @Column(name = "adminUserName")
    private String adminUserName;

    @Column(name = "adminPassword") 
    private String adminPassword; 

    @Column(name = "adminPhone")
    private String adminPhone;

    public AdminModel(){

    }
    
    public AdminModel(long adminId, String adminUserName, String adminPassword, String adminPhone) {
        this.adminId = adminId;
        this.adminUserName = adminUserName;
        this.adminPassword = adminPassword;
        this.adminPhone = adminPhone;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    } 


}
