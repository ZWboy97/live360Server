package com.jackchance.readlist.controller;

import com.jackchance.readlist.data.User;
import com.jackchance.readlist.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LiJiaChang
 * @Date: 2019/4/23 14:41
 */
@RestController
@RequestMapping("/live360/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> userLogin(@RequestBody User user) {
        User result = null;
        HttpStatus status = HttpStatus.NOT_FOUND;
        if (user == null) {
            return new ResponseEntity<User>(result, status);
        }
        result = userRepository.findUserByUserName(user.getUserName());
        if (result == null) {
            status = HttpStatus.NOT_FOUND;
        }
        if (result != null)
            if (user.getPassWord().equals(result.getPassWord())) {
                status = HttpStatus.OK;
            } else {
                status = HttpStatus.UNAUTHORIZED;
            }
        return new ResponseEntity<User>(result, status);
    }


}
