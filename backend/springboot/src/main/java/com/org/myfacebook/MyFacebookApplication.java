package com.org.myfacebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.org.myfacebook.models.*;
import com.org.myfacebook.repository.LoginRepository;
import com.org.myfacebook.repository.UserRepository;
import com.org.myfacebook.utils.JwtUtil;


@SpringBootApplication
@RestController
@Configuration
 public class MyFacebookApplication  {
    public static void main(String[] args) {
      SpringApplication.run(MyFacebookApplication.class, args);
    }

  
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private LoginRepository loginRepo;

    private JwtUtil jwtUtil;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginRes login(@RequestBody Login login)  {

        try {
           
            User user = new User(login.getEmail(), login.getPassword());
            String token = jwtUtil.createToken(user);
            if(loginRepo.findUserByEmail(login.getEmail()) != null) {
              LoginRes loginRes = new LoginRes(login.getEmail(),token);
              return loginRes;
            }

            return null;

        }catch (Exception e){
           // return e;
        }
        return null;
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