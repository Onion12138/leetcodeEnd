package com.ecnu.onion.leetcode.controller;

import com.ecnu.onion.leetcode.dao.CommentDao;
import com.ecnu.onion.leetcode.dao.UserDao;
import com.ecnu.onion.leetcode.domain.Comment;
import com.ecnu.onion.leetcode.domain.User;
import com.ecnu.onion.leetcode.util.JwtUtil;
import com.ecnu.onion.leetcode.util.KeyUtil;
import com.ecnu.onion.leetcode.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author onion
 * @date 2019-08-15 -19:33
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @PostMapping("/loginOrRegister")
    public Result login(@RequestParam String nickname, @RequestParam String password){
        Optional<User> optional = userDao.findById(nickname);
        Map<String, String> map = new HashMap<>();
        if(optional.isPresent()){
            log.info("登录");
            User login = optional.get();
            if(!encoder.matches(password, login.getPassword()))
                return Result.failure("密码错误");
            map.put("token", JwtUtil.createJwt(login));
            map.put("nickname", login.getNickname());
            map.put("hello", login.getHello());
            map.put("role", login.getRole());
            return Result.success(map, "登录成功");
        }else{
            log.info("错误");
//            User register = new User();
//            register.setNickname(nickname);
//            register.setPassword(encoder.encode(password));
//            register.setHello("enjoy coding");
//            register.setRole("user");
//            map.put("token", JwtUtil.createJwt(register));
//            map.put("nickname", register.getNickname());
//            map.put("hello", register.getHello());
//            map.put("role", register.getRole());
//            userDao.save(register);
            return Result.failure("账号不存在，联系开发者获取账号");
        }
    }
    @PostMapping("/comment")
    public Result comment(@RequestBody Comment comment){
        comment.setId(KeyUtil.getUniqueKey());
        comment.setPublishTime(new Date());
        commentDao.save(comment);
        return Result.success("回复成功");
    }

}

