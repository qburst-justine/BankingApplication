package com.example.unit;

import com.example.models.BankAccount;
import com.example.repositories.BankAccountRepository;
import com.example.services.BankAccountRepositoryImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BankAccountRepositoryTest {
	
    @Mock
    private BankAccountRepository bankAccountRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAccounts() {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount(1, "123456789", 1000.0));
        accounts.add(new BankAccount(2, "987654321", 2000.0));

        when(bankAccountRepository.getAllAccounts()).thenReturn(accounts);

        // Perform method under test
        List<BankAccount> response = bankAccountRepository.getAllAccounts();

        // Verify the repository method was called
        assertEquals(accounts, response);
    }
    
    @Test
    public void testCreateAccount() {
        // Arrange
        List<BankAccount> accounts = new ArrayList<>();
        BankAccount account = new BankAccount(1, "123456789", 1000.0);

        // Act
        bankAccountRepository.createAccount(account);

        // Assert
        //verify(accounts, times(1)).add(account);
    }
}
