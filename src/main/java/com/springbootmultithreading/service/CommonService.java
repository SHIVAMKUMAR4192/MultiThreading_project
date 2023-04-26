package com.springbootmultithreading.service;

import com.springbootmultithreading.entities.CommmonData;
import com.springbootmultithreading.entities.Dept;
import com.springbootmultithreading.entities.Employee;
import com.springbootmultithreading.repository.DeptRepository;
import com.springbootmultithreading.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class CommonService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DeptRepository deptRepository;

    public List<CommmonData> getCommondata() throws ExecutionException, InterruptedException {


//        List<Employee> listEmployee = employeeRepository.findAll();
//        List<Dept> deptList = deptRepository.findAll();

        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture<List<Employee>> employeeFetchAsync =  CompletableFuture.supplyAsync(()->{
            List<Employee> listEmployeeAsync = employeeRepository.findAll();
            return listEmployeeAsync;
        });

       employeeFetchAsync.get();

       CompletableFuture<List<Dept>> deptFetchAsync = CompletableFuture.supplyAsync(()->{
           List<Dept> deptListAsync =deptRepository.findAll();
           return deptListAsync;
       },executor);



        List<CommmonData> listOfCommonData = new ArrayList<>();

        int noOfEmployees = employeeFetchAsync.get().size();
        int sizedeptList = deptFetchAsync.get().size();

        for(int i=0;i<noOfEmployees;i++){
            for(int j=0;j<sizedeptList;j++){
                if(employeeFetchAsync.get().get(i).getEmpId() == deptFetchAsync.get().get(j).getDeptno()){
                    CommmonData cd = new CommmonData(employeeFetchAsync.get().get(i).getEmpId(), employeeFetchAsync.get().get(i).getEmpName(),employeeFetchAsync.get().get(i).getEmpAddress(),employeeFetchAsync.get().get(i).getEmpDeptNo(),deptFetchAsync.get().get(i).getDeptno(),deptFetchAsync.get().get(i).getDname());
                    listOfCommonData.add(cd);
                }
            }
        }
        return listOfCommonData;

    }
}
