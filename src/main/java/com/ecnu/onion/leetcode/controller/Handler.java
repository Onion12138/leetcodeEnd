package com.ecnu.onion.leetcode.controller;

import com.ecnu.onion.leetcode.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author onion
 * @date 2019-08-15 -19:31
 */
@RestControllerAdvice
public class Handler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exception(Exception e){
        e.printStackTrace();
        return Result.failure(e.getMessage());
    }
}
