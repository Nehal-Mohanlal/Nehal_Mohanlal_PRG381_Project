package project.portal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.portal.Models.*;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel ,Long> {
    
}
