package project.portal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import project.portal.Services.*; 
//import Repositories.*; 

@Controller
public class StudentController {
    @Autowired 
    private StudentServices stuService; 

    @GetMapping("/") 
    public String showStudents(Model model){
        model.addAttribute("allStudents", stuService.getAllStudents()); 
        return "index"; 

    }
}
