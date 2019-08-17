package com.ecnu.onion.leetcode.dao;

import com.ecnu.onion.leetcode.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author onion
 * @date 2019-08-16 -20:29
 */
public interface CommentDao extends MongoRepository<Comment, String> {
}
