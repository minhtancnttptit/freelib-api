package com.newptit.freelib.repository;

import com.newptit.freelib.model.Account;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    public Account getAccountByUsernameAndPassword(String username, String password);
}