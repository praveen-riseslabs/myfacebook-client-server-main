package com.org.myfacebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.org.myfacebook.models.*;
import com.org.myfacebook.repository.UserRepository;

@SpringBootApplication
@RestController
public class MyFacebookApplication {
    public static void main(String[] args) {
      SpringApplication.run(MyFacebookApplication.class, args);
    }
    @Autowired
    private UserRepository userRepo;
    
    @GetMapping("/hello")
    public String hello() {
      return "hello world!";
    }
    @PostMapping("/createuser")
    public User createuser(@RequestBody User user) {
       return userRepo.save(user);
    }
    // @PostMapping("/process_register")
    // public String processRegister(User user) {
    //     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //     String encodedPassword = passwordEncoder.encode(user.getPassword());
    //     user.setPassword(encodedPassword);
        
    //     userRepo.save(user);
        
    //     return "register_success";
    // }
}