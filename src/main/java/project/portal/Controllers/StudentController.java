package project.portal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import project.portal.Models.StudentModel;
import project.portal.Services.*;
//import Repositories.*; 
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    private StudentServices stuService;

    @GetMapping("/")
    public String showStudents(Model model) {
        model.addAttribute("allStudents", stuService.getAllStudents());
        return "index";

    }

    @GetMapping(value = "/newEmpForm")
    public String addNewStudent(Model model) {
        StudentModel s1 = new StudentModel();
        model.addAttribute("student", s1);

        return "addStudent";
    }

    @PostMapping(value = "/saveStudent")
    public String addStudent(@ModelAttribute("student") StudentModel studentModel) {
        stuService.addStudent(studentModel);
        return "redirect:/";

    }

    @GetMapping(value = "/updateStudent/{id}")
    public String updateStudent(@PathVariable(value = "id") long id, Model model) {
        StudentModel student = stuService.getStudentByID(id);
        model.addAttribute("student", student);

        return "updateEmployee";
    }

    @GetMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id, Model model) {
        stuService.deleteStudent(id);
        return "redirect:/";
    }

}
