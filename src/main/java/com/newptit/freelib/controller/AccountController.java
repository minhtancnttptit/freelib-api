package com.newptit.freelib.controller;

import com.newptit.freelib.model.Account;
import com.newptit.freelib.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public String home(){
        return "API";
    }

    @GetMapping("/account")
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/account")
    public String Register(@RequestBody Account account) {
        accountRepository.save(account);
        return account.getId();
    }
}
