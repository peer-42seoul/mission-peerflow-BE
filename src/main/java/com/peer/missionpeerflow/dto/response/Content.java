package com.peer.missionpeerflow.dto.response;

import com.peer.missionpeerflow.entity.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Content {

    private long id;
    private long recommand;
    private long view;
    private int answerCount;
    private String title;
    private String content;
    private String category;
    private String createAt;
    private String nickname;

    public Content(Question question) {
        this.id = question.getQuestionId();
        this.recommand = question.getRecommend();
        this.view = question.getView();
        this.answerCount = question.getAnswerList().size();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.category = String.valueOf(question.getCategory());
        this.createAt = question.getCreatedAt().toString();
        this.nickname = question.getNickname();
    }
}
