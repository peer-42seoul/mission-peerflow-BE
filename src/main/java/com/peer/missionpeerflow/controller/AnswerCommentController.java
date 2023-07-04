package com.peer.missionpeerflow.controller;

import com.peer.missionpeerflow.dto.request.AnswerCommentRequest;
import com.peer.missionpeerflow.dto.request.DeleteRequest;
import com.peer.missionpeerflow.dto.response.AnswerCommentResponse;
import com.peer.missionpeerflow.service.AnswerCommentService;
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
@RequestMapping("/v1/answer/comment")
public class AnswerCommentController {

	private final AnswerCommentService answerCommentService;

	@GetMapping("")
	public Page<AnswerCommentResponse> getQuestionComment(@RequestParam long answerId, Pageable pageable) {
		return answerCommentService.getAnswerComment(answerId, pageable);
	}

	@PostMapping("")
	public void postAnswerComment(@RequestBody @Valid AnswerCommentRequest request) {
		answerCommentService.postAnswerComment(request);
	}

	@PutMapping("/{commentId}")
	public void updateAnswerComment(@PathVariable(name = "commentId") Long commentId,
					@RequestBody @Valid AnswerCommentRequest request) {
		answerCommentService.updateAnswerComment(commentId, request);
	}

	@PostMapping("/{commentId}")
	public void deleteAnswerComment(@PathVariable(name = "commentId") Long commentId,
					@RequestBody @Valid DeleteRequest request) {
		answerCommentService.deleteAnswerComment(commentId, request);
	}
}
