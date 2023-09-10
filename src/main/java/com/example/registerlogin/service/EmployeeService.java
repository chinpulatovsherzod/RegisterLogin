package com.example.registerlogin.service;

import com.example.registerlogin.dto.EmployeeDto;
import com.example.registerlogin.dto.LoginDTO;
import com.example.registerlogin.response.LoginMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDto);

    LoginMessage loginEmployee(LoginDTO loginDTO);
}
