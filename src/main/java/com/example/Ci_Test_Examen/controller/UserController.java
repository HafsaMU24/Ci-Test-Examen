package com.example.Ci_Test_Examen.controller;

import com.example.Ci_Test_Examen.model.Task;
import com.example.Ci_Test_Examen.model.User;
import com.example.Ci_Test_Examen.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional <User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user); // Spara användaren via Service
        return ResponseEntity.ok(savedUser); // Sparar användaren korrekt i DB
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        User uppdatedUser = userService.UpdateUser(id, user);
        return ResponseEntity.ok (uppdatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<Task> assignTask(@PathVariable Long id, @RequestBody Task task) {
        Task assignedTask = userService.assignTaskToUser(id, task);
        return ResponseEntity.ok(assignedTask);
    }

}
