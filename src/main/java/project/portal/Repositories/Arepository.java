package project.portal.Repositories;

// imports
import org.springframework.data.jpa.repository.JpaRepository;

/////// Repository interface, it extends "JpaRepository" where all methods to perform DB operations are stored

import project.portal.Models.Amodel;

public interface Arepository extends JpaRepository<Amodel, Long>{
    
}
