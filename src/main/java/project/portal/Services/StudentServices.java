package project.portal.Services;
import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.portal.Repositories.StudentRepository;
import project.portal.Models.*;

@Service
@Transactional
public class StudentServices {
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
        StudentModel emp = null; 
        if(o1.isPresent()){
            emp = o1.get(); 
        }else{
            throw new RuntimeException("Employee is not found with id + " + id); 
        }
        return emp; 
    }

    // delete student by ID
    public void deleteStudent(Long id){
        this.stuRepo.deleteById(id); 
        
    }
}
