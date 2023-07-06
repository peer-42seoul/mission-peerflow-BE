package com.peer.missionpeerflow.service;

import com.peer.missionpeerflow.dto.request.MainPageReqDto;
import com.peer.missionpeerflow.dto.response.Content;
import com.peer.missionpeerflow.entity.Question;
import com.peer.missionpeerflow.repository.QuestionRepository;
import com.peer.missionpeerflow.util.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Content> getList(MainPageReqDto mainPageReqDto) {
        Category category = Category.ofType(mainPageReqDto.getCategory());
        List<Question> questionList = this.questionRepository.findAllByCategory(category);
        List<Content> mainPage = new ArrayList<>();
        for (Question question : questionList) {
            Content content = new Content(question);
            mainPage.add(content);
        }
        return mainPage;
    }
}
