package com.springbootmultithreading.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="dept_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Dept implements Serializable {

   @Id
   private int deptno;
   private String Dname;
}
