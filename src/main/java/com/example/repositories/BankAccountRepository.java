package com.example.repositories;

import java.util.List;

import com.example.models.BankAccount;

public interface BankAccountRepository {
    List<BankAccount> getAllAccounts();

    BankAccount getAccountById(int id);

    void createAccount(BankAccount account);

    void updateAccount(BankAccount account);

    void deleteAccount(int id);
}
