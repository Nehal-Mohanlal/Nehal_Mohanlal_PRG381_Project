package project.portal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.portal.Models.AdminModel;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel ,Long>{
    
}
