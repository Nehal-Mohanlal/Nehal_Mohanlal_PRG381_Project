package project.portal.Services;

// imports
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.portal.Repositories.Arepository; 
import project.portal.Models.Amodel;

///////// Essentially the business logic of the app is stored here and called in the Controller 

@Service
@Transactional
public class Aservices {

    /// have to instantiate our admin repo to have access to all the CRUD methods in repository
    @Autowired 
    private Arepository aRepo; 

    // get all admins returns a list in html table 
    public List<Amodel> getAllAdmins(){
        return aRepo.findAll(); 
    }

    /// add a new admin 
    public void addAdmin(Amodel a){
        this.aRepo.save(a); 
    }

     // helper function 
     public Amodel getAdminbyID(Long id){
        Optional<Amodel> o1 = aRepo.findById(id); 
        Amodel aModel = null; 
        if(o1.isPresent()){
            aModel = o1.get(); 
        }else{
            throw new RuntimeException("admin is not found with id + " + id); 
        }
        return aModel; 
    }

    // delete student by ID
    public void deleteAdmin(Long id){
        this.aRepo.deleteById(id); 
        
    }




}
