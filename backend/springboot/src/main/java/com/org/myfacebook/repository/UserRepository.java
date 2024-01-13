package com.org.myfacebook.repository;
import com.org.myfacebook.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface UserRepository extends JpaRepository<User, Long> {

   
    default User findUserByEmail(String Email){ return null;}
 
}