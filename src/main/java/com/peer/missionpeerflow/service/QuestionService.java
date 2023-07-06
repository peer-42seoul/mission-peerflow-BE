package com.peer.missionpeerflow.service;

import com.peer.missionpeerflow.dto.response.MainPageQuestionDto;
import com.peer.missionpeerflow.entity.Question;
import com.peer.missionpeerflow.repository.QuestionRepository;
import com.peer.missionpeerflow.util.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Page<MainPageQuestionDto> getList(Category category, String sort, int pageIndex, int pageSize) {
        String sortRule = new String();
        switch(sort) {
            case "lastest":
                sortRule = "createdAt";
                break;
            case "views":
                sortRule = "view";
                break;
            case "recommends":
                sortRule = "recommend";
                break;
            default:
                sortRule = "createAt";
                break;
        }
        Pageable pageable = PageRequest.of(pageIndex, pageSize, Sort.by(Sort.Direction.DESC, sortRule));
        Page<Question> questions = this.questionRepository.findAllByCategory(pageable, category);
        Page<MainPageQuestionDto> questionDtos = questions.map(new Function<Question, MainPageQuestionDto>() {
            @Override
            public MainPageQuestionDto apply(Question question) {
                return new MainPageQuestionDto(question);
            }
        });
        return questionDtos;
    }
}