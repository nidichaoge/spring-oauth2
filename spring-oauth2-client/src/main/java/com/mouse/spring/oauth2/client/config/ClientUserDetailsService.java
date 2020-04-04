package com.mouse.spring.oauth2.client.config;

import java.util.Optional;

import com.mouse.spring.oauth2.client.dal.dao.ClientUserRepository;
import com.mouse.spring.oauth2.client.dal.dataobject.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ClientUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientUserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<ClientUser> optionalUser = users.findByUsername(username);

        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("invalid username or password");
        }

        return new ClientUserDetails(optionalUser.get());
    }

}
