package com.niraj.usermanagement.controller;

import com.niraj.usermanagement.model.Users;
import com.niraj.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class Manage {
    @Autowired
    UserService service;
    @GetMapping("/auth/admin")
    public String welcome(){
        return "Welcome admin";
    }
    @PutMapping("auth/update")
    public Users update(@RequestBody Users users){
        return service.update(users);
    }
    @DeleteMapping("/auth/delete")
    public Users delete(@RequestBody Users users){
        return service.delete(users);
    }
}
