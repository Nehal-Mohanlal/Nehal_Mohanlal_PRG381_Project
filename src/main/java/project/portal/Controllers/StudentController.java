package project.portal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import project.portal.Models.StudentModel;
import project.portal.Models.AdminModel;
import project.portal.Services.*;
import project.portal.Services.AdminServices;

import project.portal.Services.RegisterServices;
import project.portal.Models.RegisterModel;

import project.portal.Services.Aservices;
import project.portal.Models.Amodel; 
//import Repositories.*; 
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    private StudentServices stuService;
    
    @Autowired
    private RegisterServices regServices;

    @Autowired
    private Aservices aService; 

    

    @GetMapping("/")
    public String showStudents(Model model) {
        model.addAttribute("allStudents", stuService.getAllStudents());
        return "index";
    }

    @GetMapping(value="/login")
    public String login(Model model){
        model.addAttribute("allStudents", stuService.getAllStudents());
        return "login"; 
    }

    @PostMapping("/valStudent")
        public String Valuser(){

            return "redirect:/"; 
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

        return "updateStudent";
    }

    @GetMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id, Model model) {
        stuService.deleteStudent(id);
        return "redirect:/";
    }

  
    ///////////// RegisteredStudent Controllers /////////////////////////
    @GetMapping(value = "/ViewReg")
    public String viewAllReg(Model model) {
        model.addAttribute("regStudents", regServices.getAllRegisteredStudents());
        return "viewRegisteredStudents";
    }

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

    @GetMapping(value = "/updateRegStudent/{id}")
    public String updateRegStudent(@PathVariable(value = "id") long id, Model model) {
        RegisterModel rm1 = regServices.getStudentByID(id);
        model.addAttribute("regStudent", rm1);
        return "updateRegStudent";
    }

    @GetMapping(value = "/deleteRegStudent/{id}")
    public String deleteRegisteredStudentbyID(@PathVariable(value = "id") long id, Model model) {
        regServices.deleteRegStudent(id);
        return "redirect:/";
    }

    ////////////////////// Admin Controllers /////////////////////// 
    @GetMapping(value = "/ViewAdmin")
    public String getAllAdmins(Model model) {
        model.addAttribute("allAdmins", aService.getAllAdmins());
        return "viewA";
    }

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

    @GetMapping(value = "/updateA/{id}")
    public String updateAdmin(@PathVariable(value = "id") long id, Model model) {
        Amodel am1 = new Amodel(); 
        model.addAttribute("admin", am1);

        return "updateA";
    }

    @GetMapping(value = "/deleteA/{id}")
    public String deleteAdmin(@PathVariable(value = "id") long id, Model model) {
        aService.deleteAdmin(id);
        return "redirect:/";
    }
}
