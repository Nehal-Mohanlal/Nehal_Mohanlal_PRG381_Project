package project.portal.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Amodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long aId; 

    @Column(name = "aName") 
    private String aName;

    @Column(name = "aPassword") 
    private String aPassword;

    @Column(name = "aPhone")  
    private String aPhone;

    
    public Amodel(){

    }

    public Amodel(long aId, String aName, String aPassword, String aPhone) {
        this.aId = aId;
        this.aName = aName;
        this.aPassword = aPassword;
        this.aPhone = aPhone;
    }

    public long getaId() {
        return aId;
    }
    public void setaId(long aId) {
        this.aId = aId;
    }
    public String getaName() {
        return aName;
    }
    public void setaName(String aName) {
        this.aName = aName;
    }
    public String getaPassword() {
        return aPassword;
    }
    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }
    public String getaPhone() {
        return aPhone;
    }
    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    } 


}
