package com.example.app.server.impl;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.example.app.exception.ApiException;
import com.example.app.mapper.PostMapper;
import com.example.app.mapper.UserMapper;
import com.example.app.model.Post;
import com.example.app.model.Resp;
import com.example.app.model.User;
import com.example.app.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.Timestamp;

@Service
public class UserServerImpl implements UserServer {
    private Timestamp timestamp;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userMapper;

    public UserServerImpl() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public Resp insertUserInfo(User user) {
        Resp resp = new Resp();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreateTime(timestamp);
        userMapper.insertUserInfo(user);
        resp.setMessage("success");
        return resp;
    }

    @Override
    public Resp auth(User user) {
        Resp resp = new Resp();
        resp.setData(this.userMapper.getUserInfo(user.getNickname()));
//        if (!bCryptPasswordEncoder.matches(user.getPassword(), userMapper.getPasswordHash(user))) {
//            throw new ApiException("wrong password");
//        }
        resp.setMessage("success");
        return resp;
    }

    @Override
    public Resp getAllUsers() {
        Resp resp = new Resp();
        resp.setData(this.userMapper.getAllUsers());
        return resp;
    }

    @Override
    public Resp getUserInfo() {
        Resp resp = new Resp();
        resp.setData(this.userMapper.selectById((Serializable) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        return resp;
    }
}