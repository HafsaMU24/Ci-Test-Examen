package com.example.Ci_Test_Examen.service;

import com.example.Ci_Test_Examen.model.User;
import com.example.Ci_Test_Examen.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
//@Rollback(value = false)
public class UserRepositoryJPATest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
     public void testSaveAndFindUser(){
        User user = new User(null, "Fofo");
        entityManager.persistAndFlush(user);
        // entityManager.persist(user);
        // massa annat
        // entityManager.flush();

        // Act
        User savedUser = userRepository.save(user);

        //Assert
        assertNotNull(savedUser.getId());
        assertTrue(userRepository.findById(savedUser.getId()).isPresent());

    }
}
