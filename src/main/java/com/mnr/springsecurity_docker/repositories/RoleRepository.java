package com.mnr.springsecurity_docker.repositories;

import com.mnr.springsecurity_docker.entities.Account;
import com.mnr.springsecurity_docker.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
