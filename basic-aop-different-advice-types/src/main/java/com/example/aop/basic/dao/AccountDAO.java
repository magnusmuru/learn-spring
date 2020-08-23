package com.example.aop.basic.dao;

import com.example.aop.basic.account.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    // add new method: findAccounts()
    public List<Account> findAccounts(boolean tripwire) {

        if (tripwire) {
            throw new RuntimeException("Tripwire was engaged");
        }

        List<Account> accounts = new ArrayList<>();

        // create sample accounts and add to the list
        accounts.add(new Account("Big", "Platinum"));
        accounts.add(new Account("Tiny", "Bronze"));
        accounts.add(new Account("Grandpa", "Pants"));

        return accounts;
    }

    public void addAccount(Account account) {
        System.out.println(getClass() + ": DOING MY DATABASE WORK");
    }
}
