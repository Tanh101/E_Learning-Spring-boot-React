package com.crossguild.elearning.controller;

import com.crossguild.elearning.dto.reponse.ResponseMessage;
import com.crossguild.elearning.dto.request.SignUpForm;
import com.crossguild.elearning.model.Role;
import com.crossguild.elearning.model.RoleName;
import com.crossguild.elearning.model.User;
import com.crossguild.elearning.service.impl.RoleServiceImpl;
import com.crossguild.elearning.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Validated @RequestBody SignUpForm signUpForm) {
        if(userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(new ResponseMessage("The username is exitsted"), HttpStatus.OK);
        }
        if(userService.existsByEmail(signUpForm.getEmail())){
            return new ResponseEntity<>(new ResponseMessage("The email is exitsted"), HttpStatus.OK);
        }
        User users = new User(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(), passwordEncoder.encode(signUpForm.getPassword()));
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN.toString()).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM.toString()).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER.toString()).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(userRole);
                    break;
            }
        });
        users.setRoles(roles);
        userService.save(users);
        return new ResponseEntity<>(new ResponseMessage("Create success!"), HttpStatus.OK);

    }


}
