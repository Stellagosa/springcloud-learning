package com.ellaend.cloud.service;

import com.ellaend.cloud.entity.User;

import java.util.List;

/**
 * @author ellaend
 * @date 2021/1/4 15:55
 * version 1.0
 */
public interface UserService {

    void create(User user);

    User getUser(Integer id);

    List<User> getUserByIds(List<Integer> ids);

    User getByUsername(String username);

    void update(User user);

    void delete(Integer id);
}
