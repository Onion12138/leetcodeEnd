package com.ecnu.onion.leetcode.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author onion
 * @date 2019-08-15 -17:03
 */
@Document(collection = "answer")
@Getter
@Setter
public class Answer implements Serializable {


    private static final long serialVersionUID = 1956495420467550421L;
    @Id
    private String id;

    private Integer star;

    private String title;

    private String publisher;

    private String description;

    private String type;

    private TreeSet<String> tags;

    private String mdContent;

    private String note;

}
