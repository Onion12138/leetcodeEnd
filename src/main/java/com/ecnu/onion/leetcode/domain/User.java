package com.ecnu.onion.leetcode.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author onion
 * @date 2019-08-15 -17:04
 */
@Document(collection = "user")
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 4428517241302196749L;
    @Id
    private String nickname;

    private String password;

    private String hello;

    private String role;

}
