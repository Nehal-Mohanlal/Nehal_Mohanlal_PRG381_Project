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

    public List<StudentModel> getAllStudents(){
        return stuRepo.findAll(); 
    }
}
