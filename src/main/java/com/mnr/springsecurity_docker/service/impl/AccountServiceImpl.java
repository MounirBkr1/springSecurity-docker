package com.mnr.springsecurity_docker.service.impl;

import com.mnr.springsecurity_docker.entities.Account;
import com.mnr.springsecurity_docker.entities.Role;
import com.mnr.springsecurity_docker.repositories.AccountRepository;
import com.mnr.springsecurity_docker.repositories.RoleRepository;
import com.mnr.springsecurity_docker.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Account createAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        Role role= roleRepository.findByName("ROLE_USER");
        Set<Role> roles= new HashSet<>();
        roles.add(role);
        account.setRoles(roles);
        return accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getAccount() {
        return accountRepository.findAll();
    }
}
