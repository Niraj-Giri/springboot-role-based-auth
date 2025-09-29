package com.niraj.usermanagement.service;


import com.niraj.usermanagement.model.Users;
import com.niraj.usermanagement.repositery.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
   private  UserRepo repo;
    @Autowired
    private  PasswordEncoder passwordEncoder ;
    public Users register(Users user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return  repo.save(user);

    }


    public Users update(Users users) {
        Users newUser = repo.findUsersByEmail(users.getEmail());
        newUser.setPassword(users.getPassword());
        return repo.save(newUser);

    }

    public Users delete(Users users) {
        System.out.println("Hello");
        Users newUser = repo.findUsersByEmail(users.getEmail());
        if (newUser != null) {
            repo.delete(newUser);
        }
        return newUser;
    }

}
