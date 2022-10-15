package com.mnr.springsecurity_docker.repositories;

import com.mnr.springsecurity_docker.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee,Integer> {
}
