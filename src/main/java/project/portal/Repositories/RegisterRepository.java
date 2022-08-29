package project.portal.Repositories;

// imports
import org.springframework.data.jpa.repository.JpaRepository;

/////// Repository interface, it extends "JpaRepository" where all methods to perform DB operations are stored

import project.portal.Models.RegisterModel;
public interface RegisterRepository extends JpaRepository<RegisterModel, Long>{
    
}
