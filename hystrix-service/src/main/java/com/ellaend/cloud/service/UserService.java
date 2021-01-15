package com.ellaend.cloud.service;

import com.ellaend.cloud.common.CommonResult;
import com.ellaend.cloud.entity.User;

import java.util.concurrent.Future;

/**
 * @author ellaend
 * @date 2021/1/5 17:49
 * version 1.0
 */
public interface UserService {

    CommonResult getUser(Integer id);

    CommonResult getUserCommand(Integer id);

    CommonResult getUserException(Integer id);

    CommonResult getUserCache(Integer id);

    Future<User> GetUserFuture(Integer id);
}
