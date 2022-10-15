package com.mnr.springsecurity_docker.service.impl;

import com.mnr.springsecurity_docker.entities.Employee;
import com.mnr.springsecurity_docker.repositories.InMemoryEmployeeRepository;
import com.mnr.springsecurity_docker.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


//remplace injection via constructor
@RequiredArgsConstructor
@Service
public class InMemoryEmployeeServiceImpl implements EmployeeService
{
    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return inMemoryEmployeeRepository.getAllEmployee();
    }

    @Override
    public Employee findById(Integer id) {
        return inMemoryEmployeeRepository.findById(id);
    }

    //assignment
    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public Boolean deleteById(Integer id) {
        return inMemoryEmployeeRepository.deleteById(id);
    }
}
