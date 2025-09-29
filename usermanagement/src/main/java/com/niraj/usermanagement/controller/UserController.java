package com.niraj.usermanagement.controller;

import com.niraj.usermanagement.model.Users;
import com.niraj.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
class UserController {
 @Autowired
 UserService service;

 @PostMapping("/auth/register")
 public Users register(@RequestBody Users user) {
  Users u = service.register(user);
  return u;
 }
}