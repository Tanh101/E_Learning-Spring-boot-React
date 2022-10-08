package com.crossguild.elearning.controller;

import com.crossguild.elearning.dto.request.SignUpForm;
import com.crossguild.elearning.dto.response.ResponseMessage;
import com.crossguild.elearning.model.user.ERole;
import com.crossguild.elearning.model.user.Role;
import com.crossguild.elearning.model.user.User;
import com.crossguild.elearning.service.impl.RoleServiceImpl;
import com.crossguild.elearning.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final UserServiceImpl userService;
    private RoleServiceImpl roleService;

    private PasswordEncoder passwordEncoder;

    public AuthController(UserServiceImpl userService, RoleServiceImpl roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("The username existed! Please try again!"), HttpStatus.OK);
        }
        if (userService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("The email existed! Please try again!"), HttpStatus.OK);
        }
        User user = new User(signUpForm.getFullName(), signUpForm.getUsername(), signUpForm.getEmail(),
                passwordEncoder.encode(signUpForm.getPassword()), signUpForm.getAvatar());
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "ROLE_ADMIN":
                    Role adminRole = roleService.findByRoleName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Role not found!"));
                    roles.add(adminRole);
                    break;
                case "ROLE_TEACHER":
                    Role teacherRole = roleService.findByRoleName(ERole.ROLE_TEACHER)
                            .orElseThrow(() -> new RuntimeException("Role not found!"));
                    roles.add(teacherRole);
                    break;
                case "ROLE_USER":
                    Role studentRole = roleService.findByRoleName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Role not found!"));
                    roles.add(studentRole);
                    break;
                default:
                    Role userRole1 = roleService.findByRoleName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(userRole1);
            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new ResponseMessage("Signup success!"), HttpStatus.OK);
    }
}
