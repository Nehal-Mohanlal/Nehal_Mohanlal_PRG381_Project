package project.portal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import project.portal.Repositories.AdminRepository;
import project.portal.Models.AdminModel;

@Service
@Transactional
public class AdminServices {
    
    @Autowired 
    private AdminRepository adminRepo; 

    public List<AdminModel> getAllAdmins(){
        return adminRepo.findAll(); 

    }

    public void addAdmin(AdminModel aModel){
        this.adminRepo.save(aModel); 
    }

}
