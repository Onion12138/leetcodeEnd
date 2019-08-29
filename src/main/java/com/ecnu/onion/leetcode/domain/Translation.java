package com.ecnu.onion.leetcode.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author onion
 * @date 2019/8/27 -8:29 上午
 */
@Document(collection = "translation")
@Getter
@Setter
public class Translation implements Serializable {

    private static final long serialVersionUID = - 8923372171946505619L;
    @Id
    private String id;

    private String book;

    private Integer chapter;

    private String item;

    private String content;

}
