package com.ellaend.cloud.service;

import com.ellaend.cloud.common.CommonResult;
import com.ellaend.cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ellaend
 * @date 2021/1/8 20:57
 * version 1.0
 */
// 表示对user-service服务的接口调用客户端
@FeignClient(value = "user-service", fallback = UserFallbackService.class)
public interface UserService {

    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    @GetMapping("/user/{id}")
    CommonResult getUser(@PathVariable("id") Integer id);

    @GetMapping("/user/getUserByIds")
    CommonResult getUserByIds(@RequestParam List<Integer> ids);

    @GetMapping("/user/getByUsername")
    CommonResult getByUsername(@RequestParam("username") String username);

    @PutMapping("/user/update")
    CommonResult update(@RequestBody User user);

    @DeleteMapping("/user/{id}")
    CommonResult delete(@PathVariable("id") Integer id);

}
