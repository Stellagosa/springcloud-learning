package com.ellaend.cloud.service;

import com.ellaend.cloud.common.CommonResult;
import com.ellaend.cloud.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ellaend
 * @date 2021/1/9 11:07
 * version 1.0
 * 服务降级实现
 */
@Component
public class UserFallbackService implements UserService {

    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1, "defaultUser", "123456");
        return new CommonResult(200, "操作成功", defaultUser);
    }

    @Override
    public CommonResult getUser(Integer id) {
        User defaultUser = new User(-1, "defaultUser", "123456");
        return new CommonResult(200, "操作成功", defaultUser);
    }

    @Override
    public CommonResult getUserByIds(List<Integer> ids) {
        User defaultUser = new User(-1, "defaultUser", "123456");
        List<User> list = new ArrayList<>();
        list.add(defaultUser);
        return new CommonResult(200, "操作成功", list);
    }

    @Override
    public CommonResult getByUsername(String username) {
        User defaultUser = new User(-1, "defaultUser", "123456");
        return new CommonResult(200, "操作成功", defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult(500, "操作失败，服务被降级");
    }

    @Override
    public CommonResult delete(Integer id) {
        return new CommonResult(500, "操作失败，服务被降级");
    }
}
