package com.mnr.springsecurity_docker.service;

import com.mnr.springsecurity_docker.entities.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);
    Account findByUsername(String username);
    List<Account> getAccount();
}
