package com.example.registerlogin.dto;


import lombok.Data;

@Data
public class EmployeeDto {


    private int employeeId;
    private String employeeName;
    private String email;
    private String password;


    public EmployeeDto(int employeeId, String employeeName, String email, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.password = password;
    }

    public EmployeeDto() {
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
