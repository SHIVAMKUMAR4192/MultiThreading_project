package com.springbootmultithreading.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommmonData {
    @Id
    private int empId;
    private String empName;
    private String empAddress;
    private String empDeptNo;
    private int deptno;
    private String Dname;

}
