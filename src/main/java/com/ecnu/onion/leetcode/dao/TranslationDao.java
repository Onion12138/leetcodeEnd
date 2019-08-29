package com.ecnu.onion.leetcode.dao;

import com.ecnu.onion.leetcode.domain.Translation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author onion
 * @date 2019/8/27 -8:54 上午
 */
public interface TranslationDao extends MongoRepository<Translation, String> {
    List<Translation> findByChapter(Integer chapter);
}
