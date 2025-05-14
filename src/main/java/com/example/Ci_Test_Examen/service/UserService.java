package com.example.Ci_Test_Examen.service;

import com.example.Ci_Test_Examen.model.Task;
import com.example.Ci_Test_Examen.model.User;
import com.example.Ci_Test_Examen.repository.TaskRepository;
import com.example.Ci_Test_Examen.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public UserService(UserRepository userRepository, TaskRepository taskRepository){
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return  userRepository.save(user);
    }

    public User UpdateUser(Long id,User user){
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public Task assignTaskToUser(Long userId, Task task) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        task.setUser(user);
        return taskRepository.save(task);
    }

}