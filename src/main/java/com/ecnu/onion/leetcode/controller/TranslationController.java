package com.ecnu.onion.leetcode.controller;

import com.ecnu.onion.leetcode.dao.TranslationDao;
import com.ecnu.onion.leetcode.domain.Translation;
import com.ecnu.onion.leetcode.util.KeyUtil;
import com.ecnu.onion.leetcode.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author onion
 * @date 2019/8/27 -8:55 上午
 */
@RestController
@RequestMapping("/translation")
public class TranslationController {
    @Autowired
    private TranslationDao translationDao;

    @GetMapping("/chapter")
    public Result findByChapter(@RequestParam Integer chapter){
        List<Translation> translationList = translationDao.findByChapter(chapter);
        return Result.success(translationList, "查找成功");
    }

    @GetMapping("/one")
    public Result findOne(@RequestParam String id){
        Translation translation = translationDao.findById(id).get();
        return Result.success(translation, "查找成功");
    }
    @PostMapping("/post")
    public Result postTranslation(@RequestBody Translation translation){
        translation.setId(KeyUtil.getUniqueKey());
        translationDao.save(translation);
        return Result.success("成功添加");
    }

    @PutMapping("/update")
    public Result updateTranslation(@RequestBody Translation translation){
        translationDao.save(translation);
        return Result.success("成功修改");
    }
}
