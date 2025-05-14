package com.example.Ci_Test_Examen.service;

import com.example.Ci_Test_Examen.model.User;
import com.example.Ci_Test_Examen.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class UserServiceComponentTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testCreateAndFetchUser(){
        //Arrange
        User user = new User(null, "Fofo");

        //Act
        User savedUser = userService.createUser(user);
        User fetchedUser= userService.getUserById(savedUser.getId()).orElse(null);

        //Assert
        assertNotNull(fetchedUser);
        assertEquals("Fofo", fetchedUser.getName());
    }

}
