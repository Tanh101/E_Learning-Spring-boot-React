package com.crossguild.elearning.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
    private String fullName;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private Set<String> roles;
}
