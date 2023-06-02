package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.models.BankAccount;
import com.example.repositories.BankAccountRepository;


@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {
    private List<BankAccount> accounts;

    public BankAccountRepositoryImpl() {
        accounts = new ArrayList<>();
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return accounts;
    }

    @Override
    public BankAccount getAccountById(int id) {
        for (BankAccount account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void createAccount(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public void updateAccount(BankAccount account) {
        for (BankAccount existingAccount : accounts) {
            if (existingAccount.getId() == account.getId()) {
                existingAccount.setAccountNumber(account.getAccountNumber());
                existingAccount.setBalance(account.getBalance());
                break;
            }
        }
    }

    @Override
    public void deleteAccount(int id) {
        accounts.removeIf(account -> account.getId() == id);
    }
}

