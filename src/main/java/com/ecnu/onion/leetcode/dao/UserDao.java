package com.ecnu.onion.leetcode.dao;

import com.ecnu.onion.leetcode.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author onion
 * @date 2019-08-15 -19:34
 */
public interface UserDao extends MongoRepository<User, String> {
}
