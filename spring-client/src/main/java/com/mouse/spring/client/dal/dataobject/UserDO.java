package com.mouse.spring.client.dal.dataobject;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-03-26
 * @description
 */
@Data
@Entity(name = "user")
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String accessToken;

    private LocalDateTime accessTokenValidity;

    private String refreshToken;

}
