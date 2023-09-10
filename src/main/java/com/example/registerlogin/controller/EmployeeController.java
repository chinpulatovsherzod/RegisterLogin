package com.example.registerlogin.controller;


import com.example.registerlogin.dto.EmployeeDto;
import com.example.registerlogin.dto.LoginDTO;
import com.example.registerlogin.response.LoginMessage;
import com.example.registerlogin.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    @PostMapping(path = "/save")
    public String saveEmployees(@RequestBody EmployeeDto employeeDto){
        String id = employeeService.addEmployee(employeeDto);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
        LoginMessage loginMessage = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }

}
