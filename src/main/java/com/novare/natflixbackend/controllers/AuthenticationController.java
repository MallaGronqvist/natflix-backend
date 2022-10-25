package com.novare.natflixbackend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/registration/", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class AuthenticationController {

    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    UserDetailsManager userDetailsManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/register/")
    public void singup(@RequestBody SignUpData data){
        try {
            UserDetails user = User.builder()
                    .username(data.getEmail())
                    .password(passwordEncoder.encode(data.getPass()))
                    .roles("USER")
                    .build();

            userDetailsManager.createUser(user);
            logger.info("User created " + data.getEmail() + " " + data.getPass());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    @GetMapping("/api/info")
    public String info(Authentication auth){
        return auth.getName();
    }

    @GetMapping("/api/check")
    public String check(){
        return "You need to be logged in to view this endpoint";
    }

    // The /api/admin/** endpoint is restricted to the admin role.
    @GetMapping("/api/admin/check")
    public String checkAdmin(){
        return "You need to be logged in as a admin to view this endpoint";
    }


    public static class SignUpData{
        private String fullname;
        private String email;
        private String pass;
        private Integer type;

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }
}
