package com.example.Ci_Test_Examen.service;

import com.example.Ci_Test_Examen.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceComponentTest {


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
