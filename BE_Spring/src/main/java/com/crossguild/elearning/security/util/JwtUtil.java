package com.crossguild.elearning.security.util;

import com.crossguild.elearning.security.filter.JwtAuthenticationFilter;
import com.crossguild.elearning.security.service.MyUserDetails;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private static final String SECRET_KEY = "secret";

    // Set time for token = 8 hours
    private static final long TIME_TOKEN = 1000 * 60 * 60 * 8;

    public String createToken(Authentication authentication) {
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        return Jwts.builder().setSubject(myUserDetails.getUsername())
                .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + TIME_TOKEN))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT Signature: ", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT format token: ", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token: ", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token: ", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT Claims string is empty: ", e.getMessage());
        }
        return false;
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token)
                .getBody().getSubject();
    }
}
