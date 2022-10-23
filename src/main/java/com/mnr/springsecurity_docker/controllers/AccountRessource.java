package com.mnr.springsecurity_docker.controllers;


import com.mnr.springsecurity_docker.entities.Account;
import com.mnr.springsecurity_docker.entities.Employee;
import com.mnr.springsecurity_docker.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mnr.springsecurity_docker.controllers.EmployeeController.getLocation;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api/accounts")
public class AccountRessource {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getLocation(account.getId().intValue())).body(newAccount);

    }

    @GetMapping

    public ResponseEntity<List<Account>> getAccount(){
        return ResponseEntity.ok(accountService.getAccount());
    }


}
