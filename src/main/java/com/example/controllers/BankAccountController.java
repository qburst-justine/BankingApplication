package com.example.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.models.BankAccount;
import com.example.repositories.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {
    private BankAccountRepository accountRepository;

    public BankAccountController(BankAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable int id) {
        return accountRepository.getAccountById(id);
    }

    @PostMapping
    public void createAccount(@RequestBody BankAccount account) {
        accountRepository.createAccount(account);
    }

    @PostMapping("/{id}/deposit")
    public void depositMoney(@PathVariable int id, @RequestParam double amount) {
        BankAccount account = accountRepository.getAccountById(id);
        if (account != null) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            accountRepository.updateAccount(account);
        }
    }

    @PostMapping("/{id}/withdraw")
    public void withdrawMoney(@PathVariable int id, @RequestParam double amount) {
        BankAccount account = accountRepository.getAccountById(id);
        if (account != null) {
            double newBalance = account.getBalance() - amount;
            if (newBalance >= 0) {
                account.setBalance(newBalance);
                accountRepository.updateAccount(account);
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable int id) {
        accountRepository.deleteAccount(id);
    }
}
