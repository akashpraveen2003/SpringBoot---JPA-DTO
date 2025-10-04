package com.example.ecom_application.Controller;


import com.example.ecom_application.Service.UserService;
import com.example.ecom_application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/api/users") declared as class level variable where instead of repeating the same code, we can use this to reduce redundancy
public class UserController {
    @Autowired
   private UserService userService;


    @GetMapping("/api/users/{id}") // Getdata
    public ResponseEntity<User> fetchUser(@PathVariable long id) {
        User user = userService.getUser(id);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user); // response with successful code
        //return ResponseEntity.badRequest().body(userService.getUser(id)); // Control over the response status
    }
    @GetMapping("/api/users")
    //@RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> fetchUsers() {
        return userService.getUsers();
    }
    @PostMapping("/api/users") // new data
    public String addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully";
    }
    @PutMapping("/api/users/{id}") // update
    public String updateUser(@PathVariable long id,@RequestBody User user) {
        return userService.updateUser(id,user);
    }
    @DeleteMapping("/api/users/{id}") //delete
    public String deleteUser(@PathVariable long id) {
         return userService.deleteUser(id);
    }

    @GetMapping("api/userss")
    public User getUserWithName(@RequestParam String firstName,@RequestParam String lastName) {
        return userService.getUserWithName(firstName,lastName);
    }
}
/*@GetMapping("api/users/{firstName}/{lastName}")
public User getUserWithName(@PathVariable String firstName,@PathVariable String lastName) {
    return userService.getUserWithName(firstName,lastName);
}*/