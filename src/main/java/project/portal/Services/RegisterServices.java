package project.portal.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*; 
import project.portal.Repositories.RegisterRepository;
import project.portal.Models.RegisterModel;

@Service
@Transactional
public class RegisterServices {
    @Autowired
    private RegisterRepository RegRepo; 
    
    public List<RegisterModel> getAllRegisteredStudents(){
        return RegRepo.findAll(); 
    }

    public void newRegisteredStudent(RegisterModel regModel){
        this.RegRepo.save(regModel); 
    }

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

    public void deleteRegStudent(Long id){
        this.RegRepo.deleteById(id); 
        
    }
}
