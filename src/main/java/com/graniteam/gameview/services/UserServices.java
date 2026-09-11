package com.graniteam.gameview.services;
import com.graniteam.gameview.data.User;
import com.graniteam.gameview.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices
{

    @Autowired
    private UserRepository userRepository;

    public User addUser(User User) {
        return userRepository.save(User);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}