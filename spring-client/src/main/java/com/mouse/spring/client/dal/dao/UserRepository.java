package com.mouse.spring.client.dal.dao;

import com.mouse.spring.client.dal.dataobject.UserDO;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-26
 * @description
 */
public interface UserRepository extends CrudRepository<UserDO, Long> {

    UserDO findByUsername(String username);

}
