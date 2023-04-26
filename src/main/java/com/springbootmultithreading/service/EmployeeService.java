package com.springbootmultithreading.service;

import com.springbootmultithreading.entities.Employee;
import com.springbootmultithreading.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee>getAllEmployee(){
        return employeeRepository.findAll();
    }

}
