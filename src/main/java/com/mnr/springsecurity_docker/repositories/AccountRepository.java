package com.mnr.springsecurity_docker.repositories;

import com.mnr.springsecurity_docker.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByUsername(String username);
}
