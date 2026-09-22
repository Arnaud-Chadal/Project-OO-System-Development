package com.graniteam.gameview.services;
import com.graniteam.gameview.data.User;
import com.graniteam.gameview.data.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices
{

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find user with id: " + id));
    }

    public User updateUser(User newUser, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Cannot find user with id: " + userId));
        if (!newUser.getName().isEmpty() && !newUser.getName().isBlank()) {
            user.setName(newUser.getName());
        }
        userRepository.save(user);
        return user;
    }
}