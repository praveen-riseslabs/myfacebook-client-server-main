package com.org.myfacebook.repository;
import com.org.myfacebook.models.Login;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface LoginRepository extends JpaRepository<Login, Long> {
 
}