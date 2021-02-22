package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Lucky
 * @version 1.0.0
 * @date 2020/8/31 1:10
 * @copyright 老九学堂
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String account;
    private String password;

}
