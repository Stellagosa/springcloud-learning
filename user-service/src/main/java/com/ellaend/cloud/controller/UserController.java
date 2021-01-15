package com.ellaend.cloud.controller;

import com.ellaend.cloud.common.CommonResult;
import com.ellaend.cloud.entity.User;
import com.ellaend.cloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ellaend
 * @date 2021/1/4 15:49
 * version 1.0
 */
@RequestMapping("/user")
@RestController
public class UserController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        userService.create(user);
        LOGGER.info("创建用户，用户名为：{}", user.getUsername());
        return new CommonResult(200, "操作成功");
    }

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        LOGGER.info("根据用户id获取用户信息，用户名为：{}", user.getUsername());
        return new CommonResult(200, "操作成功", user);
    }

    @GetMapping("/getUserByIds")
    public CommonResult getUserByIds(@RequestParam List<Integer> ids) {
        List<User> userList = userService.getUserByIds(ids);
        LOGGER.info("根据ids获取用户信息，用户列表为：{}", userList);
        return new CommonResult(200, "操作成功", userList);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam("username") String username) {
        User user = userService.getByUsername(username);
        LOGGER.info("根据用户名获取用户信息，用户名为：{}", user.getUsername());
        return new CommonResult(200, "操作成功", user);
    }

    @PutMapping("/update")
    public CommonResult update(@RequestBody User user) {
        userService.update(user);
        LOGGER.info("更新用户信息，用户名为：{}", user.getUsername());
        return new CommonResult(200, "操作成功");
    }

    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        LOGGER.info("根据id删除用户，用户id为：{}", id);
        return new CommonResult(200, "操作成功");
    }

}
