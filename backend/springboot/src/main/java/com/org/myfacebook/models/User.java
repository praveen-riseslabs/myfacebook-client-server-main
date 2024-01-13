package com.org.myfacebook.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "users")
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 45)
    private Integer id;
     
    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "password", nullable = false,  length = 45)
    private String password;
     
    @Column(name = "phonenumber", nullable = false, length = 64)
    private String phonenumber;
     
    @Column(name = "firstname", nullable = false, length = 20)
    private String firstname;
     
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastname;

    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  

    public String getEmail() {  
        return email;  
    }  
    public void setEmail(String email) {  
        this.email = email;  
    } 
    
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    } 

    public String getPhonenumber() {  
        return phonenumber;  
    }  
    public void setPhonenumber(String phonenumber) {  
        this.phonenumber = phonenumber;  
    } 

    public String getFirstname() {  
        return firstname;  
    }  
    public void setFirstname(String firstname) {  
        this.firstname = firstname;  
    } 
     
    public String getLastname() {  
        return lastname;  
    }  
    public void setLastname(String lastname) {  
        this.lastname = lastname;  
    }
}