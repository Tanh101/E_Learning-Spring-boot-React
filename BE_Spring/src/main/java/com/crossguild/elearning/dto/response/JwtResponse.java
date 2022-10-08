package com.crossguild.elearning.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer ";
    private String username;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String token, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.roles = authorities;
    }
}
