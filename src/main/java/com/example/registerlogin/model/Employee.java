package com.example.registerlogin.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id

    @Column(name = "employee_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    @Column(name = "employee_name", length = 255)
    private String employeeName;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

//    public Employee(int employeeId, String employeeName, String email, String password) {
//        this.employeeId = employeeId;
//        this.employeeName = employeeName;
//        this.email = email;
//        this.password = password;
//    }
//
//    public Employee() {
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
