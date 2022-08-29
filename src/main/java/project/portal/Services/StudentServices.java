package project.portal.Services;
// imports
import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.portal.Repositories.StudentRepository;
import project.portal.Models.*;

///////// Essentially the business logic of the app is stored here and called in the Controller 

@Service
@Transactional
public class StudentServices {
    /// have to instantiate our admin repo to have access to all the CRUD methods in repository
    @Autowired
    private StudentRepository stuRepo; 

    // display all students
    public List<StudentModel> getAllStudents(){
        return stuRepo.findAll(); 
    }

    // add student
    public void addStudent(StudentModel student){
        this.stuRepo.save(student); 
    }

    // helper function 
    public StudentModel getStudentByID(Long id){
        Optional<StudentModel> o1 = stuRepo.findById(id); 
        StudentModel stuModel = null; 
        if(o1.isPresent()){
            stuModel = o1.get(); 
        }else{
            throw new RuntimeException("Student is not found with id + " + id); 
        }
        return stuModel; 
    }

    // delete student by ID
    public void deleteStudent(Long id){
        this.stuRepo.deleteById(id); 
        
    }

    
    // Student login 
    public String valUser(String email, String Password){
        
        List<StudentModel> ls = stuRepo.findAll();
        String msg = "";  
        for (StudentModel student : ls) {
            if(student.getStudentEmail() == email && student.getStudentPassword() == Password){
            msg ="Valid";
            }
            else{
                msg= "Invalid";  
            } 
        }
        return msg; 
            
        };
    
}
