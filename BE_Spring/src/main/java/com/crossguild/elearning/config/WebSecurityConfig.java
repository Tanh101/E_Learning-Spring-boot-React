package com.crossguild.elearning.config;

import com.crossguild.elearning.security.filter.JwtAuthenticationFilter;
import com.crossguild.elearning.security.service.MyUserDetailsService;
import com.crossguild.elearning.security.util.JwtEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService userDetailsService;

    private final JwtEntryPoint jwtEntryPoint;

    private final AppConfig appConfig;

    public WebSecurityConfig(MyUserDetailsService userDetailsService, JwtEntryPoint jwtEntryPoint, AppConfig appConfig) {
        this.userDetailsService = userDetailsService;
        this.jwtEntryPoint = jwtEntryPoint;
        this.appConfig = appConfig;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(appConfig.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/quiz/all").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/quiz/**").authenticated()
                .antMatchers("/api/user/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/quiz/add").access("hasRole('ROLE_TEACHER')")
                .antMatchers(HttpMethod.POST, "/api/question/add").access("hasRole('ROLE_TEACHER')")
                //.antMatchers("/api/")
                .anyRequest().authenticated()
                .and().exceptionHandling()
                .authenticationEntryPoint(jwtEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(appConfig.jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
