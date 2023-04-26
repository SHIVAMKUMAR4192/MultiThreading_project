package com.springbootmultithreading.controller;

import com.springbootmultithreading.entities.Dept;
import com.springbootmultithreading.repository.DeptRepository;
import com.springbootmultithreading.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private DeptService deptService;

    @GetMapping(value ="/getDeptDetails")
    public List<Dept> getDeptDetails(){
        return deptService.getAllDept();
    }

}
