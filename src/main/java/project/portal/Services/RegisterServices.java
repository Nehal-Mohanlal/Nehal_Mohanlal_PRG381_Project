package project.portal.Services;

// imports
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*; 
import project.portal.Repositories.RegisterRepository;
import project.portal.Models.RegisterModel;

///////// Essentially the business logic of the app is stored here and called in the Controller 
@Service
@Transactional
public class RegisterServices {
    /// have to instantiate our admin repo to have access to all the CRUD methods in repository
    @Autowired
    private RegisterRepository RegRepo; 
    
    /// get all Resgistered Students returns a list, displayed as HTML table
    public List<RegisterModel> getAllRegisteredStudents(){
        return RegRepo.findAll(); 
    }

    // add a new registered Student
    public void newRegisteredStudent(RegisterModel regModel){
        this.RegRepo.save(regModel); 
    }

    // helper function to get StudentByID // to perform things such as update
    public RegisterModel getStudentByID(Long id){
        Optional<RegisterModel> o1 = RegRepo.findById(id); 
        RegisterModel regModel = null; 
        if(o1.isPresent()){
            regModel = o1.get(); 
        }else{
            throw new RuntimeException("registered student is not found with id + " + id); 
        }
        return regModel; 
    } 

    /// delete Student by ID 
    public void deleteRegStudent(Long id){
        this.RegRepo.deleteById(id); 
        
    }
}
