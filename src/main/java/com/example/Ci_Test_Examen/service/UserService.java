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
// tilldela en uppgift Task till User baserat på användarens ID
    public Task assignTaskToUser(Long userId, Task task) {
        User user = userRepository.findById(userId) // försaka hitta en user med userid
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId)); // Kaster ett felmeddelande (skydder mot att försaka tilldel en upgifte till en user)
        task.setUser(user); // länkas uppgiften till den användaren
        return taskRepository.save(task); // uppgiften tilldelead och lagras med rätt koppling till användaren
    }

}