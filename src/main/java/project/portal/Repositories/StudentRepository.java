package project.portal.Repositories;

// imports
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/////// Repository interface, it extends "JpaRepository" where all methods to perform DB operations are stored

import project.portal.Models.*;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel ,Long> {
    
}
