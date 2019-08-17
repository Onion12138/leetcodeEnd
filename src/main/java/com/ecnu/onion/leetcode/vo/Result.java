package com.ecnu.onion.leetcode.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author onion
 * @date 2019-08-15 -19:02
 */
@Getter
@Setter
public class Result implements Serializable {
    private Object data;
    private String msg;
    private Integer code;

    private Result(Object data, String msg, Integer code) {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }
    private Result(String msg, Integer code){
        this(null, msg, code);
    }

    public static Result success(String msg){
        return new Result(msg, 0);
    }

    public static Result success(Object data, String msg){
        return new Result(data, msg, 0);
    }

    public static Result failure(String msg){
        return new Result(msg, -1);
    }
}
