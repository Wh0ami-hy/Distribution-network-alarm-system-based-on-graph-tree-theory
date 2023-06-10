package com.hy.controller;

import com.hy.entity.User;
import com.hy.service.UserService;
import com.hy.util.JwtUtils;
import com.hy.util.Result;
import com.hy.util.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        String password = userService.login(user.getUsername());
        if (password.equals(user.getPassword())){
            String token = JwtUtils.generateToken(user.getUsername());
            System.out.println("name-->" + user.getUsername() + "\npassword-->" + user.getPassword());
            // 将用户名存入缓存
            UserCache.put("username", user.getUsername());
            return Result.ok().data("token",token);
        }else {
            return Result.error();
        }
    }
    @GetMapping("/info")
    public Result info(String token){
        String username = JwtUtils.getClaimsByToken(token).getSubject();
        String url = userService.info(username);
        System.out.println(url); // "http://127.0.0.1:8888/用户名.jpg";
        return Result.ok().data("name",username).data("avatar",url);
    }
    @PostMapping("/logout")
    public Result logout(){return Result.ok();}

    @PostMapping("/update")
    public Result update(@RequestBody User user){
        String picture = "http://127.0.0.1:8888/images/" + UserCache.get("username") + ".jpg";
        user.setPicture(picture);
        userService.update(user);
        System.out.println(user);
        return Result.ok();
    }

    @PostMapping("/register")
        public Result register(@RequestBody User user){
        userService.register(user);
        return Result.ok();
    }
}