package com.myexam.controller;

import com.myexam.entity.ResponseEntity;
import com.myexam.po.User;
import com.myexam.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/login")
    public ResponseEntity<User> login(HttpServletRequest request,
                                @RequestParam String username,
                                @RequestParam String password){
        User user = userService.getByUserName(username);
        if(user == null){
            return ResponseEntity.fail("用户名不存在");
        }
        password = password+user.getSalt();
        String verifiedPassword = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if( !user.getPassword().equals(verifiedPassword)){
            return ResponseEntity.fail("密码错误");
        }
        user.setPassword("");

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(user.getId(),user);

        return ResponseEntity.success(user);
    }

    @RequestMapping("/signOut")
    public ResponseEntity signOut(HttpServletRequest request, @RequestParam String userId){
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute(userId);
        return ResponseEntity.success();
    }

    @RequestMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        if(userService.isRegister(user.getUsername())){
            return ResponseEntity.fail("用户名已被注册");
        }
        String salt = RandomStringUtils.randomAlphanumeric(5);
        String password = user.getPassword()+salt;
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)));
        user.setSalt(salt);
        userService.register(user);
        return ResponseEntity.success();
    }

    @RequestMapping("/saveUserInfo")
    public ResponseEntity saveUserInfo(@RequestBody User user, HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(user.getId(),user);
        userService.saveUserInfo(user);
        return ResponseEntity.success();
    }

    @RequestMapping("uploadAvatar")
    public ResponseEntity uploadAvatar(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileName="D:/Projects/other/img/"+multipartFile.getOriginalFilename();
        File file = new File(fileName);
        file.getParentFile().mkdirs();
        multipartFile.transferTo(file);
        return ResponseEntity.success();
    }

    @RequestMapping("getUserInfo")
    public ResponseEntity<User> getUserInfo(String userId){
        User user = userService.getByUserId(userId);
        user.setPassword("");
        return ResponseEntity.success(user);
    }
}
