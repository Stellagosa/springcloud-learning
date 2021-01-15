package com.ellaend.cloud.controller;

import com.ellaend.cloud.common.CommonResult;
import com.ellaend.cloud.entity.User;
import com.ellaend.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ellaend
 * @date 2021/1/9 10:55
 * version 1.0
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/getUserByIds")
    public CommonResult getUserByIds(@RequestParam List<Integer> ids) {
        return userService.getUserByIds(ids);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam("username") String username) {
        return userService.getByUsername(username);
    }

    @PutMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable("id") Integer id) {
        return userService.delete(id);
    }

}
