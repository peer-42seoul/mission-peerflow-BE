package com.peer.missionpeerflow.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionResponse extends BaseResponse {

	List<AnswerResponse> answerList;
	private String type = "question";
	private String title;
	private String category;
	private long recommend;
	private long view;
}
