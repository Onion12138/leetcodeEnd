package com.ecnu.onion.leetcode.util;

import com.ecnu.onion.leetcode.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author onion
 * @date 2019-08-16 -10:39
 */
@Getter
@Setter
@Slf4j
@Component
public class JwtUtil {
    private final static String key = "ECNUSOFT";
    private final static Long ttl = 1000 * 60 * 60 * 24L;

    public static String createJwt(User user){
//        if(user == null || user.getNickname() == null)
//            return null;
//        long cur = System.currentTimeMillis();
//        Date present = new Date(cur);
//        JwtBuilder builder = Jwts.builder()
//                .setId(user.getNickname())
//                .setSubject(user.getRole())
//                .setIssuedAt(present)
//                .signWith(SignatureAlgorithm.HS256, key)
//                .setExpiration(new Date(cur+ttl));
//        return builder.compact();
        return user.getNickname();
    }
//    public static Claims parseJwt(String jwt){
//
//    }
}
