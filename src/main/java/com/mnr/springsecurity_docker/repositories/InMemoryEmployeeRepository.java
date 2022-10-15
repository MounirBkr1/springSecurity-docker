package com.mnr.springsecurity_docker.repositories;

import com.mnr.springsecurity_docker.entities.Employee;
import com.mnr.springsecurity_docker.service.EmployeeService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Repository

public class InMemoryEmployeeRepository  {

    public static final List<Employee> DATABASE= new ArrayList<>();

    static {
        DATABASE.add(new Employee(1,"baakk","mnr","bakk@email.com"));
        DATABASE.add(new Employee(2,"sikoli","mohamed","med@email.com"));
        DATABASE.add(new Employee(3,"chantouf","jamal","jamal@email.com"));
    }

    public Employee addEmployee(Employee employee) {
        DATABASE.add(employee);
        return employee;
    }


    public List<Employee> getAllEmployee() {

        return List.copyOf(DATABASE);
    }


    public Employee findById(Integer id) {
        return DATABASE
                .stream()
                .filter(emp-> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();

    }


    //assignement
    public void updateEmployee(Employee employee) {

    }

    public Boolean deleteById(Integer id) {
        Employee employee= DATABASE
                .stream()
                .filter(emp-> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
        DATABASE.remove(employee);
        return TRUE;

    }
}
