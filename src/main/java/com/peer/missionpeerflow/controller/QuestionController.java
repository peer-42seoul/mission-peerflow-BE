package com.peer.missionpeerflow.controller;

import com.peer.missionpeerflow.dto.request.MainPageReqDto;
import com.peer.missionpeerflow.dto.response.Content;
import com.peer.missionpeerflow.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/v1")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("")
    @ResponseBody
    public List<Content> getMainPage(MainPageReqDto mainPageDto) {
        return this.questionService.getList(mainPageDto);
    }
}
