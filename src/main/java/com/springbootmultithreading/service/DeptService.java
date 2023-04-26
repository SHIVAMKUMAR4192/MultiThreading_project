package com.springbootmultithreading.service;


import com.springbootmultithreading.entities.Dept;
import com.springbootmultithreading.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptRepository deptRepository;

    public List<Dept> getAllDept() {
        return deptRepository.findAll();
    }
}
