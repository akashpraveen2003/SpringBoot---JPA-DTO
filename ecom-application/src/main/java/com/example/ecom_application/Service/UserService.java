package com.example.ecom_application.Service;

import com.example.ecom_application.Repository.UserRepository;
import com.example.ecom_application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public User getUser(long id) {
       return userRepository.findById(id).orElse(null);
    }
    public String updateUser(long id,User newuser) {
       User user=userRepository.findById(id).orElse(null);
       if(user==null) {
            return "User not found";
       }
        user.setFirstName(newuser.getFirstName());
        user.setLastName(newuser.getLastName());
       userRepository.save(user);
       return "User updated successfully";
    }
    public String deleteUser(long id) {
        User user=userRepository.findById(id).orElse(null);
        if(user==null)
        {
            return "User not found";
        }
        userRepository.delete(user);
        return "User deleted successfully";
    }

    public User getUserWithName(String firstName, String lastName) {
        return  userRepository.findByFirstNameAndLastName(firstName,lastName);
    }
}
