package com.crossguild.service;

import com.crossguild.model.Account;
import com.crossguild.repo.AccountRepo;
import com.crossguild.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Get user trong db
        Account account = accountRepo.getAccountByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " was not found!");
        }
        // Lấy các quyền của user trong db
        List<String> roles = roleRepo.getRolesName(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (roles != null) {
            // Chuyển các quyền từ kiểu String sang kiểu GrandtedAuthority của Spring Security
            for (String role : roles) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                grantedAuthorities.add(grantedAuthority);
            }
        }
        // Tạo user theo cách của Spring Security
        UserDetails userDetails = new User(username, account.getPassword(), grantedAuthorities);
        return userDetails;
    }


}
