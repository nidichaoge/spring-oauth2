package com.mouse.spring.oauth2.client.dal.dataobject;

import lombok.Data;

import javax.persistence.*;
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
@Entity
public class ClientUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String accessToken;

    private Calendar accessTokenValidity;

    private String refreshToken;

    @Transient
    private List<Entry> entries = new ArrayList<>();

}
