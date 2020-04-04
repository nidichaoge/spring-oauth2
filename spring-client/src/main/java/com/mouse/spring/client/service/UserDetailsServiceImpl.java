package com.mouse.spring.client.service;

import com.mouse.spring.client.dal.dao.UserRepository;
import com.mouse.spring.client.dal.dataobject.UserDO;
import com.mouse.spring.client.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-28
 * @description
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("username can not be empty.");
        }

        UserDO userDO = userRepository.findByUsername(username);
        if (Objects.isNull(userDO)) {
            throw new UsernameNotFoundException("can not find username");
        }

        return new UserInfo(userDO);
    }

}
