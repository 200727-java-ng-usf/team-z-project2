package com.revature.project2.services;

import com.revature.project2.exceptions.AuthenticationException;
import com.revature.project2.exceptions.InvalidRequestException;
import com.revature.project2.models.Role;
import com.revature.project2.models.User;
import com.revature.project2.repos.UserRepository;
import com.revature.project2.web.dtos.Credentials;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

public class UserServiceTests {

    private UserService sut;

    private UserRepository mockUserRepo = Mockito.mock(UserRepository.class);
    List<User> mockUsers = new ArrayList<>();

    @Before
    public void setup() {
        sut = new UserService(mockUserRepo);
        mockUsers.add(new User(1, "Adam", "Inn", "admin", "secret", "admin@app.com", Role.ADMIN));
        mockUsers.add(new User(2, "Manny", "Gerr", "manager", "manage", "manager@app.com", Role.MANAGER));
        mockUsers.add(new User(3, "Alice", "Anderson", "aanderson", "password", "admin@app.com", Role.USER));
        mockUsers.add(new User(4, "Bob", "Bailey", "bbailey", "dev", "dev@app.com", Role.USER));
    }

    @After
    public void tearDown() {
        sut = null;
        mockUsers.removeAll(mockUsers);
    }

    @Test(expected = InvalidRequestException.class)
    public void authenticationWithInvalidCredentials() {
        sut.authenticate(null);
    }

    @Test(expected = RuntimeException.class)
    public void authenticationWithUnknownCredentials() {
        Credentials credentials = new Credentials("garbage", "user");
        sut.authenticate(credentials);
    }

    @Test (expected = NullPointerException.class)
    public void registerWithNullAppUser() {
        // Arrange
        // nothing to do here for this test; nothing to mock or expect

        // Act
        sut.save(null);

        // Assert
        // nothing here, because the method should have raised an exception
    }

    @Test
    public void updateWithNullUserReturnsFalse() {
        Assert.assertEquals(false, sut.update(null));
    }
    
    @Test (expected = InvalidRequestException.class)
    public void deleteWithNegativeId() {
        sut.deleteById(-10);
    }

    @Test (expected = RuntimeException.class)
    public void findUserByUsernameAndPasswordNull() {
        sut.findUserByUsernameAndPassword(null, null);
    }

    @Test (expected = InvalidRequestException.class)
    public void findByIdNegativeId() {
        sut.findById(-10);
    }








}
