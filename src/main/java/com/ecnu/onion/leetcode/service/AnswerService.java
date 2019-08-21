package com.ecnu.onion.leetcode.service;

import com.ecnu.onion.leetcode.dao.AnswerDao;
import com.ecnu.onion.leetcode.domain.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author onion
 * @date 2019-08-15 -17:04
 */
@Service
public class AnswerService {
    @Autowired
    private AnswerDao answerDao;

    public Answer findById(String id){
        return answerDao.findById(id).get();
    }

    public Page<Answer> findByIdLike(String id, Pageable pageable){
        return answerDao.findByIdLike(id, pageable);
    }
    public Page<Answer> findByTitle(String title, Pageable pageable){
        return answerDao.findByTitleLike(title, pageable);
    }

    public Page<Answer> findByType(String type, Pageable pageable){
        return answerDao.findByType(type, pageable);
    }

    public Page<Answer> findByTag(String tag, Pageable pageable){
        return answerDao.findByTagsContains(tag, pageable);
    }

    public void addSolution(Answer answer){
        answerDao.save(answer);
    }

    public void updateSolution(Answer answer) {
        answerDao.save(answer);
    }

    public Page<Answer> findAll(Pageable pageable) {
        return answerDao.findAll(pageable);
    }

    public List<Answer> findRelated(List<String> tagList, String id){
        Map<String,Answer> map = new HashMap<>();
        for (String s : tagList) {
            answerDao.findByTagsContains(s).forEach(e->map.put(e.getId(),e));
        }
        map.remove(id);
        List<Answer> res = new ArrayList<>();
        map.keySet().forEach(e->res.add(map.get(e)));
        return res;
    }
}
