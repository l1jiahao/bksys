package com.t6.bksys.service;

import com.t6.bksys.entity.User;
import com.t6.bksys.mapper.UserRegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import java.util.Date;

@Service
public class UserRegistrationService {
    private final UserRegistrationMapper userRegistrationMapper;
//    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserRegistrationService(UserRegistrationMapper userRegistrationMapper) {
        this.userRegistrationMapper = userRegistrationMapper;
//        this.authenticationManager = authenticationManager;
    }

    public String registerUser(User user) {
        // 插入用户
        userRegistrationMapper.insertUser(user);

        // 进行认证以生成令牌
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getAccount(), user.getPassword())
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // 生成JWT令牌
//        String token = generateToken(authentication);
        String token = "114514";
        return token;
    }

//    private String generateToken(Authentication authentication) {
//        final long EXPIRATION_TIME = 864_000_00; // 24 hours in milliseconds
//        final String SECRET_KEY = "YourSecretKey"; // Use a strong, unique key
//
//        String jwt = Jwts.builder()
//                .setSubject(authentication.getName())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .compact();
//
//        return jwt;
//    }
}
