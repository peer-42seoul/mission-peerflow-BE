package com.peer.missionpeerflow.controller;

import com.peer.missionpeerflow.dto.response.MainPageQuestionDto;
import com.peer.missionpeerflow.service.QuestionService;
import com.peer.missionpeerflow.util.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    @ResponseBody
    public Page<MainPageQuestionDto> getMainPage(@RequestParam("category") String category,
                                                 @RequestParam("sort") String sort,
                                                 @RequestParam("pageIndex") int pageIndex,
                                                 @RequestParam("pageSize") int pageSize) {
        Category categoryEnum = Category.ofType(category);
        return this.questionService.getList(categoryEnum, sort, pageIndex, pageSize);
    }
}
