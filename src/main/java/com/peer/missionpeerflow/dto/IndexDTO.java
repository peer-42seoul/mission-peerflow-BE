package com.peer.missionpeerflow.dto;

import com.peer.missionpeerflow.entity.Question;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IndexDTO {

	private Long questionId;

	private String title;

	private Integer answerCount;

	private String category;

	private Long recommend;

	private Long view;

	private String nickname;

	private LocalDateTime createdAt;

	private String content;

	public static IndexDTO toIndexDTO(Question question) {
		return new IndexDTO(
						question.getQuestionId(),
						question.getTitle(),
						question.getAnswerList().size(),
						question.getCategory(),
						question.getRecommend(),
						question.getView(),
						question.getNickname(),
						question.getCreatedAt(),
						question.getContent()
		);
	}
}
