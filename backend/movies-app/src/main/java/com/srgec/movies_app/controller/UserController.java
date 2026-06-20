package com.srgec.movies_app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srgec.movies_app.dto.LoginRequest;
import com.srgec.movies_app.models.User;
import com.srgec.movies_app.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {
    private final UserService service;
    
    public UserController(UserService service){
        this.service=service;
    }
   /*  @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }*/
    
    @PostMapping("/register")
    public User creatUser(@RequestBody User user) throws Exception{
        return service.register(user);
        
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginrequest)throws Exception{
        return service.login(loginrequest.getEmail(),loginrequest.getPassword());
    }

   /*  @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }
        @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User user){
        return service.updateUser(id,user);
}*/
}