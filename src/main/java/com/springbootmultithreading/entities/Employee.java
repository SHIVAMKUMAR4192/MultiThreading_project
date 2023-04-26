package com.springbootmultithreading.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="emp_data")
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@Getter
@Setter
@ToString
public class Employee implements Serializable {
    @Id
    private int empId;
    private String empName;
    private String empAddress;
    private String empDeptNo;
}
