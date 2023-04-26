package com.springbootmultithreading.controller;

import com.springbootmultithreading.entities.Employee;
import com.springbootmultithreading.repository.EmployeeRepository;
import com.springbootmultithreading.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

   @Autowired
    private EmployeeRepository employeeRepository;
   @Autowired
   private EmployeeService employeeService;

   @GetMapping(value = "/getDetailsofEmployee")
   public List<Employee> getDetailsofEmployee(){
       return employeeService.getAllEmployee();
   }
}
