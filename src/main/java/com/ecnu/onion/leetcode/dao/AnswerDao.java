package com.ecnu.onion.leetcode.dao;

import com.ecnu.onion.leetcode.domain.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author onion
 * @date 2019-08-15 -17:04
 */
public interface AnswerDao extends MongoRepository<Answer, String> {
    Page<Answer> findByIdLike(String id, Pageable pageable);
    Page<Answer> findByTitleLike(String title, Pageable pageable);
    Page<Answer> findByType(String type, Pageable pageable);
    Page<Answer> findByTagsContains(String tag, Pageable pageable);

}
