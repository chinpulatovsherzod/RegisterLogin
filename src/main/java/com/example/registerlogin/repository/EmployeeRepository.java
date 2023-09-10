package com.example.registerlogin.repository;

import com.example.registerlogin.dto.LoginDTO;
import com.example.registerlogin.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);

    Optional<Employee> findOneByEmailAndPassword(LoginDTO loginDTO);
}
