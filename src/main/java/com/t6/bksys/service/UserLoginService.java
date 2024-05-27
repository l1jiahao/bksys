package com.t6.bksys.service;

import com.t6.bksys.entity.User;
import com.t6.bksys.mapper.UserLoginMapper;
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
public class UserLoginService {
    private final UserLoginMapper userLoginMapper;
//    private final AuthenticationManager authenticationManager;

//    @Autowired
//    public UserLoginService(UserLoginMapper userLoginMapper, AuthenticationManager authenticationManager) {
//        this.userLoginMapper = userLoginMapper;
//        this.authenticationManager = authenticationManager;
//    }

    @Autowired
    public UserLoginService(UserLoginMapper userLoginMapper) {
        this.userLoginMapper = userLoginMapper;
    }

    public User loginUser(String account, String password) {

//        // 使用用户名和密码进行身份认证
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(account, password)
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // 如果认证成功，生成JWT令牌
//        if (authentication.isAuthenticated()) {
//            return generateToken(authentication);
//        }
//
//        // 如果认证失败，返回错误信息
//        return "Authentication failed";


        // 通过 userLoginMapper 验证用户名和密码
        User user = userLoginMapper.loginUser(account, password);
//        System.out.println(user.toString());
        if (user != null) {
            // 用户验证成功，生成JWT令牌
//            return generateToken(user);

//            String token = "114514";
            return user;
        }

        // 用户名或密码错误
//        return "Invalid login credentials";
//        throw new IllegalArgumentException("登录失败：用户名或密码错误");
        return null;
    }





//    private String generateToken(User user) {
//        final long EXPIRATION_TIME = 864_000_00; // 24小时的毫秒数
//        final String SECRET_KEY = "YourSecretKey"; // 使用强大且唯一的密钥
//
//        String jwt = Jwts.builder()
//                .setSubject(user.getAccount())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .compact();
//
//        return jwt;
//    }


//    private String generateToken(Authentication authentication) {
//        final long EXPIRATION_TIME = 864_000_00; // 24小时的毫秒数
//        final String SECRET_KEY = "YourSecretKey"; // 使用强大且唯一的密钥
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
