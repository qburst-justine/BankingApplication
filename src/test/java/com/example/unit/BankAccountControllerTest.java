package com.example.unit;

import com.example.controllers.BankAccountController;
import com.example.models.BankAccount;
import com.example.repositories.BankAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BankAccountControllerTest {

    @Mock
    private BankAccountRepository accountRepository;

    private BankAccountController accountController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        accountController = new BankAccountController(accountRepository);
    }

    @Test
    public void testGetAllAccounts() {
        // Arrange
        BankAccount account1 = new BankAccount(1, "123456789", 1000.0);
        BankAccount account2 = new BankAccount(2, "987654321", 500.0);
        List<BankAccount> accounts = Arrays.asList(account1, account2);
        when(accountRepository.getAllAccounts()).thenReturn(accounts);

        // Act
        List<BankAccount> result = accountController.getAllAccounts();

        // Assert
        assertEquals(accounts, result);
        verify(accountRepository, times(1)).getAllAccounts();
    }

	/*
	 * @Test public void testCreateAccount() { // Arrange BankAccount account = new
	 * BankAccount(1, "123456789", 1000.0);
	 * 
	 * // Act ResponseEntity<Void> response =
	 * accountController.createAccount(account);
	 * 
	 * // Assert assertEquals(HttpStatus.CREATED, response.getStatusCode());
	 * verify(accountRepository, times(1)).createAccount(account); }
	 */
    


   

}
