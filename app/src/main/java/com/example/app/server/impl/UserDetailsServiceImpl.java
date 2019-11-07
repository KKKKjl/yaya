package com.example.app.server.impl;

import com.example.app.mapper.UserMapper;
import com.example.app.model.JwtUser;
import com.example.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
//    private Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userMapper.getUserInfo(s);
        if (user == null) {
            throw new UsernameNotFoundException("This username didn't exist.");
        }
        return new JwtUser(user);
    }
}
