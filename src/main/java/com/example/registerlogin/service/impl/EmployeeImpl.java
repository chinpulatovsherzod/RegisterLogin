package com.example.registerlogin.service.impl;

import com.example.registerlogin.dto.EmployeeDto;
import com.example.registerlogin.dto.LoginDTO;
import com.example.registerlogin.model.Employee;
import com.example.registerlogin.repository.EmployeeRepository;
import com.example.registerlogin.response.LoginMessage;
import com.example.registerlogin.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(

                employeeDto.getEmployeeId(),
                employeeDto.getEmployeeName(),
                employeeDto.getEmail(),
                this.passwordEncoder.encode(employeeDto.getPassword())
        );

        employeeRepository.save(employee);

        return employee.getEmployeeName();

    }

    @Override
    public LoginMessage loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepository.findByEmail(loginDTO.getEmail());
        if (employee1 != null){
            String password = loginDTO.getPassword();
            String encoderPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encoderPassword);
            if (isPwdRight){
                Optional<Employee> employee = employeeRepository.findOneByEmailAndPassword(loginDTO);
                if (employee.isPresent()){
                    return new LoginMessage("Login Success", true);
                }else {
                    return new LoginMessage("Login Failed", false);
                }
            }else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }

        
    }
}
