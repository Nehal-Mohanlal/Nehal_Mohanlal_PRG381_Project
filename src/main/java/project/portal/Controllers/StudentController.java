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
//import Repositories.*; 
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    private StudentServices stuService;
    @Autowired
    private AdminServices adminService;
    @Autowired
    private RegisterServices regServices;

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

        return "updateStudent";
    }

    @GetMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id, Model model) {
        stuService.deleteStudent(id);
        return "redirect:/";
    }

    //////////////// Admin Controllers .//////////////////
    @GetMapping(value = "/ViewAdmin")
    public String getAllAdmins(Model model) {
        model.addAttribute("allAdmins", adminService.getAllAdmins());
        return "viewAdmins";
    }

    @GetMapping(value = "/newAdmin")
    public String addAdmin(Model model) {
        AdminModel am1 = new AdminModel();
        model.addAttribute("admin", am1);

        return "addAdmin";

    }

    @PostMapping(value = "/saveAdmin")
    public String newAdmin(@ModelAttribute("admin") AdminModel adminModel) {
        adminService.addAdmin(adminModel);
        return "redirect:/viewAdmins";
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
}
