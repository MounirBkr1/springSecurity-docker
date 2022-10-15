package com.mnr.springsecurity_docker.service.impl;

import com.mnr.springsecurity_docker.entities.Employee;
import com.mnr.springsecurity_docker.repositories.InMemoryEmployeeRepository;
import com.mnr.springsecurity_docker.repositories.JpaEmployeeRepository;
import com.mnr.springsecurity_docker.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.TRUE;


//remplace injection via constructor
@RequiredArgsConstructor
@Service
//tell to serice wich implementation to choose
@Qualifier(value="MySQLEmployeeService")
public class JpaEmployeeServiceImpl implements EmployeeService
{
    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        //save come from JpaRepository
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    //assignment
    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public Boolean deleteById(Integer id) {
         jpaEmployeeRepository.deleteById(id);
        return  TRUE;
    }
}
