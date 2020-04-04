package com.mouse.spring.oauth2.resource.server.jwt.service;

import com.mouse.spring.oauth2.resource.server.jwt.response.UserInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-24
 * @description
 */
@Service
public class UserService {

    private static final Map<String, UserInfo> MAP = new HashMap<>(8);

    static {
        MAP.put("1", new UserInfo().setId("1").setUsername("mouse").setAge(24));
        MAP.put("2", new UserInfo().setId("2").setUsername("zhangsan").setAge(23));
        MAP.put("3", new UserInfo().setId("3").setUsername("lisi").setAge(22));
    }

    public UserInfo getUserInfo(String id) {
        return MAP.get(id);
    }

}
