package com.newptit.freelib.controller;

import com.newptit.freelib.model.*;
import com.newptit.freelib.repository.AccountRepository;
import com.newptit.freelib.repository.AdminRepository;
import com.newptit.freelib.repository.CommentRepository;
import com.newptit.freelib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://freelib.vercel.app", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "API";
    }

    @GetMapping("/account")
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/account")
    public String Register(@RequestBody Account account) {
        accountRepository.save(account);
        return account.getId();
    }



    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginForm loginForm) {
        Account account = accountRepository.getAccountByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword());
        if (account != null) {
            System.out.println(account.getRole());
            if (account.getRole().equals("admin")) {
                Admin admin = adminRepository.findAdminById(account.getId());
                if (admin != null) {
                    return new ResponseEntity(admin, HttpStatus.OK);
                }
            } else {
                User user = userRepository.findUserById(account.getId());
                if (user != null) {
                    return new ResponseEntity(user, HttpStatus.OK);
                }
            }

        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterForm registerForm) {
        System.out.println(registerForm.toString());
        Account account = new Account(registerForm.getId(), registerForm.getUsername(), registerForm.getPassword(), "user");
        accountRepository.save(account);
        User user = new User(registerForm.getId(), registerForm.getName(), registerForm.getGender(), registerForm.getEmail(), registerForm.getDob(), registerForm.getAddress());
        User saved = userRepository.save(user);
        if (saved != null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


//    @PostMapping("/register")

//    public String register()

//    @PostMapping("/test")
//    public List<Account> test(String user)
}


