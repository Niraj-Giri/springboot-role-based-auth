package com.niraj.usermanagement.repositery;

import com.niraj.usermanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findUsersByEmail(String email);
}
