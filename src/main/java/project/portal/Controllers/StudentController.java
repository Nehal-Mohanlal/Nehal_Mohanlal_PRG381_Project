package project.portal.Controllers;

// imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import project.portal.Models.StudentModel;
//import project.portal.Models.AdminModel;
import project.portal.Services.*;
//import project.portal.Services.AdminServices;

import project.portal.Services.RegisterServices;
import project.portal.Models.RegisterModel;

import project.portal.Services.Aservices;
import project.portal.Models.Amodel; 
//import Repositories.*; 
//import org.springframework.web.bind.annotation.RequestParam;


/////////////////////////// This is the main controller that handles all get, post , delete and patch requests  (All rest API methods) ////////// 

@Controller
public class StudentController {

    // instantiate each entity service 
    @Autowired
    private StudentServices stuService;
    
    @Autowired
    private RegisterServices regServices;

    @Autowired
    private Aservices aService; 

    // get index page can navigate to all other pages from index
    @GetMapping(value = "/")
    
    public String getMenu(){
        return "index"; 
    }

    // view all students endpoint 
    @GetMapping("/viewStudents")
    public String showStudents(Model model) {
        model.addAttribute("allStudents", stuService.getAllStudents());
        return "viewStudents";
    }

    // login endpoint , sp all users can login 
    @GetMapping(value="/stulogin")
    public String login(Model model){
        model.addAttribute("allStudents", stuService.getAllStudents());
        return "stulogin"; 
    }

    // the actual function for validating student 
    @PostMapping("/valStudent")
        public String Valuser(){
            /// empty because could not implement validation Method for login is in /services/studentservices line 47 
            return "menu"; 
        }


    /// end point for getting a new Student 
    @GetMapping(value = "/newStudent")
    public String addNewStudent(Model model) {
        StudentModel s1 = new StudentModel();
        model.addAttribute("student", s1);

        return "addStudent";
    }

    // once student form has been submitted
    @PostMapping(value = "/saveStudent")
    public String addStudent(@ModelAttribute("student") StudentModel studentModel) {
        stuService.addStudent(studentModel);
        return "redirect:/";

    }

    // update student endpoint 
    @GetMapping(value = "/updateStudent/{id}")
    public String updateStudent(@PathVariable(value = "id") long id, Model model) {
        StudentModel student = stuService.getStudentByID(id);
        model.addAttribute("student", student);

        return "updateStudent";
    }

    // delete Student endpoint 
    @GetMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id, Model model) {
        stuService.deleteStudent(id);
        return "redirect:/";
    }

  
    ///////////// RegisteredStudent Controllers /////////////////////////
    
    // View all registered students from "register" entity in DB  
    @GetMapping(value = "/ViewReg")
    public String viewAllReg(Model model) {
        model.addAttribute("regStudents", regServices.getAllRegisteredStudents());
        return "viewRegisteredStudents";
    }

    // endpoint for adding a new registered student 
    @GetMapping(value = "/newReg")
    public String newReg(Model model) {
        RegisterModel rm1 = new RegisterModel();
        model.addAttribute("regStudent", rm1);

        return "addRegisteredStudent";
    }

    
    @PostMapping(value = "/saveReg")
    public String addReg(@ModelAttribute("regStudent") RegisterModel regModel) {
        regServices.newRegisteredStudent(regModel);
        return "redirect:/";

    }

    // endpoint for updating a registered student 
    @GetMapping(value = "/updateRegStudent/{id}")
    public String updateRegStudent(@PathVariable(value = "id") long id, Model model) {
        RegisterModel rm1 = regServices.getStudentByID(id);
        model.addAttribute("regStudent", rm1);
        return "updateRegStudent";
    }

    // endpoint for deleting a registered student 
    @GetMapping(value = "/deleteRegStudent/{id}")
    public String deleteRegisteredStudentbyID(@PathVariable(value = "id") long id, Model model) {
        regServices.deleteRegStudent(id);
        return "redirect:/";
    }

    ////////////////////// Admin Controllers /////////////////////// 

    // end point for viewing all admins 
    @GetMapping(value = "/ViewAdmin")
    public String getAllAdmins(Model model) {
        model.addAttribute("allAdmins", aService.getAllAdmins());
        return "viewA";
    }

    // end point for adding new admins 
    @GetMapping(value = "/newAdmin")
    public String addNewAdmin(Model model) {
        Amodel a1 = new Amodel(); 
        model.addAttribute("admin", a1);

        return "addA";
    }

    @PostMapping(value = "/saveA")
    public String addAdmin(@ModelAttribute("admin") Amodel a) {
       aService.addAdmin(a); 
        return "redirect:/";
    }

    // endpoint for updaating admins
    @GetMapping(value = "/updateA/{id}")
    public String updateAdmin(@PathVariable(value = "id") long id, Model model) {
        Amodel am1 = new Amodel(); 
        model.addAttribute("admin", am1);

        return "updateA";
    }

    // endpoint for deleting admins
    @GetMapping(value = "/deleteA/{id}")
    public String deleteAdmin(@PathVariable(value = "id") long id, Model model) {
        aService.deleteAdmin(id);
        return "redirect:/";
    }
}
