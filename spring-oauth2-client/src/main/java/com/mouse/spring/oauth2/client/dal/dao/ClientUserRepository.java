package com.mouse.spring.oauth2.client.dal.dao;

import com.mouse.spring.oauth2.client.dal.dataobject.ClientUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-26
 * @description
 */
public interface ClientUserRepository extends CrudRepository<ClientUser, Long> {

    Optional<ClientUser> findByUsername(String username);

}
