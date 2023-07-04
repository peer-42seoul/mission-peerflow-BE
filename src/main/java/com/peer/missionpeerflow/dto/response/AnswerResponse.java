package com.peer.missionpeerflow.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerResponse extends BaseResponse {

	private String type = "answer";
	private boolean isAdopted;
	private long recommend;
	private long questionId;
	private long answerId;
}
