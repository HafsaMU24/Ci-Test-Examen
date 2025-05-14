package com.example.Ci_Test_Examen.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateAndGetUser(){
        // Arrange
        User user = new User(null, "Anna");

        // Act
        ResponseEntity<User> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/users", user,User.class);

        assertEquals(HttpStatus.OK.value(), postResponse.getStatusCode().value());

        Long id = postResponse.getBody().getId();

        User getResponse =
                restTemplate.getForObject("http://localhost:" + port + "/users/" + id, User.class);

        // Assert -kontrollera svar

        assertEquals("Anna", getResponse.getName());
        assertEquals(id, getResponse.getId());

    }

}