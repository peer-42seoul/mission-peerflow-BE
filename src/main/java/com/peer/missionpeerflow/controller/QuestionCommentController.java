package com.peer.missionpeerflow.controller;

import com.peer.missionpeerflow.dto.request.QuestionCommentRequest;
import com.peer.missionpeerflow.dto.response.QuestionCommentResponse;
import com.peer.missionpeerflow.service.QuestionCommentService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/question/comment")
public class QuestionCommentController {

	private final QuestionCommentService questionCommentService;

	@GetMapping("")
	public Page<QuestionCommentResponse> getQuestionComment(@RequestParam long questionId, Pageable pageable) {
		return questionCommentService.getQuestionComment(questionId, pageable);
	}

	@PostMapping("")
	public void postQuestionComment(@RequestBody @Valid QuestionCommentRequest request) {
		questionCommentService.postQuestionComment(request);
	}

	@PutMapping("/{commentId}")
	public void updateQuestionComment(@PathVariable(name = "commentId") Long commentId,
					@RequestBody @Valid QuestionCommentRequest request) {
		questionCommentService.updateQuestionComment(commentId, request);
	}

	@PostMapping("/{commentId}")
	public void deleteQuestionComment(@PathVariable(name = "commentId") Long commentId,
					@RequestBody @Valid QuestionCommentRequest request) {
		questionCommentService.deleteQuestionComment(commentId, request);
	}
}
