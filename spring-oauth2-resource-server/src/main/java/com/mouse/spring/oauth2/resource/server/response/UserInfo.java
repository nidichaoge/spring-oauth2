package com.mouse.spring.oauth2.resource.server.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-24
 * @description
 */
@Data
@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 5433513420053058164L;

    private String id;

    private String username;

    private Integer age;

}
