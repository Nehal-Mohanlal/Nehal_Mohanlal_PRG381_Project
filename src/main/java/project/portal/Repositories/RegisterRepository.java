package project.portal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.portal.Models.RegisterModel;
public interface RegisterRepository extends JpaRepository<RegisterModel, Long>{
    
}
