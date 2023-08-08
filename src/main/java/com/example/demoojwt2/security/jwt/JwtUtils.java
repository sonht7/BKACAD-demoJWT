package com.example.demoojwt2.security.jwt;

import com.example.demoojwt2.security.service.UserDetailImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${demo.app.jwtSecret}")
    private String jwtSecret;

    @Value("${demo.app.jwtExpriation}")
    private int jwtExpiration;
    //Từ thông tin đăng nhập tạo ra token
    public String generateJwtToken(Authentication authentication){
        UserDetailImpl userPrincipal = (UserDetailImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration))
                .signWith(key(), SignatureAlgorithm.HS256).compact();
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));

    }

    // Từ token lấy ra người dùng
    public String getUsernameFromJwtToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

}
