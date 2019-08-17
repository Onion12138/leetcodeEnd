package com.ecnu.onion.leetcode.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author onion
 * @date 2019-08-16 -20:25
 */
@Getter
@Setter
@Document(collection = "comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = - 6618740201276839289L;
    @Id
    private String id;

    private String nickname;

    private Date publishTime;

    private String content;
}
