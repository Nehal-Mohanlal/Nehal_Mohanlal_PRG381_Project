package project.portal.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.portal.Repositories.Arepository; 
import project.portal.Models.Amodel;

@Service
@Transactional
public class Aservices {
    @Autowired 
    private Arepository aRepo; 

    public List<Amodel> getAllAdmins(){
        return aRepo.findAll(); 
    }

    public void addAdmin(Amodel a){
        this.aRepo.save(a); 
    }

     // helper function 
     public Amodel getAdminbyID(Long id){
        Optional<Amodel> o1 = aRepo.findById(id); 
        Amodel stuModel = null; 
        if(o1.isPresent()){
            stuModel = o1.get(); 
        }else{
            throw new RuntimeException("Student is not found with id + " + id); 
        }
        return stuModel; 
    }

    // delete student by ID
    public void deleteAdmin(Long id){
        this.aRepo.deleteById(id); 
        
    }




}
