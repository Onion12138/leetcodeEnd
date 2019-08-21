package com.ecnu.onion.leetcode.controller;

import com.ecnu.onion.leetcode.domain.Answer;
import com.ecnu.onion.leetcode.service.AnswerService;
import com.ecnu.onion.leetcode.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author onion
 * @date 2019-08-15 -17:05
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    private PageRequest getRequest(Boolean sortById, Integer page, Integer size){
        PageRequest pageRequest;
        if(sortById) {
            Sort sort = new Sort(Direction.ASC, "id");
            pageRequest = PageRequest.of(page-1, size, sort);
        }
        else{
            Sort sort = new Sort(Direction.DESC, "star");
            pageRequest = PageRequest.of(page-1, size, sort);
        }
        return pageRequest;
    }
    @GetMapping("/all")
    public Result findAll(@RequestParam Integer page, @RequestParam Integer size,
                          @RequestParam Boolean sortById){
        PageRequest pageRequest = getRequest(sortById, page, size);
        Page<Answer> answers = answerService.findAll(pageRequest);
        return Result.success(answers, "查找成功");
    }
    @GetMapping("/one")
    public Result findOne(@RequestParam String id){
        Answer answer = answerService.findById(id);
        if(answer != null)
            return Result.success(answer, "查找成功");
        else
            return Result.failure("找不到结果");
    }
    @GetMapping("/id")
    public Result findById(@RequestParam Integer page,
                           @RequestParam Integer size,
                           @RequestParam Boolean sortById,
                           @RequestParam String id){
        PageRequest pageRequest = getRequest(sortById, page, size);
        Page<Answer> answers = answerService.findByIdLike(id, pageRequest);
        return Result.success(answers, "查找成功");
    }
    @GetMapping("/title")
    public Result findByTitle(@RequestParam Integer page,
                              @RequestParam Integer size,
                              @RequestParam Boolean sortById,
                              @RequestParam String title){
        PageRequest pageRequest = getRequest(sortById, page, size);
        Page<Answer> answers = answerService.findByTitle(title, pageRequest);
        return Result.success(answers, "查找成功");
    }
    @GetMapping("/type")
    public Result findByType(@RequestParam Integer page,
                             @RequestParam Integer size,
                             @RequestParam Boolean sortById,
                             @RequestParam String type){
        PageRequest pageRequest = getRequest(sortById, page, size);
        Page<Answer> answers = answerService.findByType(type, pageRequest);
        return Result.success(answers, "查找成功");
    }

    @GetMapping("/tag")
    public Result findByTag(@RequestParam Integer page,
                            @RequestParam Integer size,
                            @RequestParam Boolean sortById,
                            @RequestParam String tag){
        PageRequest pageRequest = getRequest(sortById, page, size);
        Page<Answer> answers = answerService.findByTag(tag, pageRequest);
        return Result.success(answers, "查找成功");
    }

    @PostMapping("/add")
    public Result addSolution(@RequestBody Answer answer){
        answerService.addSolution(answer);
        return Result.success("提交成功");
    }

    @PutMapping("/update")
    public Result updateSolution(@RequestBody Answer answer){
        answerService.updateSolution(answer);
        return Result.success("修改成功");
    }

    @GetMapping("/relation")
    public Result findRelated(@RequestParam String tags, @RequestParam String id){
        List<String> tagList = Arrays.asList(tags.split(","));
        List<Answer> related = answerService.findRelated(tagList, id);
        return Result.success(related, "查找成功");
    }


}
