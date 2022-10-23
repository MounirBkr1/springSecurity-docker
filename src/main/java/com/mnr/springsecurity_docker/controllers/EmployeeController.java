package com.mnr.springsecurity_docker.controllers;

import com.mnr.springsecurity_docker.entities.Employee;
import com.mnr.springsecurity_docker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.*;

@RestController
//@RequiredArgsConstructor
//default path
@RequestMapping(path="/api/employees")
public class EmployeeController {



    private final EmployeeService employeeService;
    //@Qualifier..:choose implementation of mysql
    public EmployeeController(@Qualifier(value="MySQLEmployeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployee());

    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployees(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.findById(id));

    }

    @PostMapping
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee){
        //employee.setId(employeeService.getAllEmployee().size() +1);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));

    }

    protected static URI getLocation(int id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployees(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.deleteById(id));

    }

    @PutMapping
    public ResponseEntity<Boolean> updateEmployees(){
        return null;

    }

}
