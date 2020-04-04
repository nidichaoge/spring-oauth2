package com.mouse.spring.client.entity;

import com.mouse.spring.client.dal.dataobject.UserDO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-28
 * @description
 */
public class UserInfo implements UserDetails {

    private UserDO userDO;

    public UserInfo(UserDO userDO){
        this.userDO = userDO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

    @Override
    public String getPassword() {
        return userDO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
