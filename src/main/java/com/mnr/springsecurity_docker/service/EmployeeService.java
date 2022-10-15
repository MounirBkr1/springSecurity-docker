package com.mnr.springsecurity_docker.service;

import com.mnr.springsecurity_docker.entities.Employee;


import java.util.List;
//interface a implementer , contient des methode a implementer

public interface EmployeeService {

    //save employee
    public Employee addEmployee(Employee employee);



    //get employee
    public List<Employee> getAllEmployee();


    //get one employee

    public Employee findById(Integer id);


    //update employee
    public void updateEmployee(Employee employee);



    //delete employee
    public Boolean deleteById(Integer id);



}
