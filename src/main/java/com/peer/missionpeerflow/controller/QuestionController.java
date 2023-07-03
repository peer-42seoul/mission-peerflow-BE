package com.peer.missionpeerflow.controller;

import com.peer.missionpeerflow.dto.request.DeleteRequest;
import com.peer.missionpeerflow.dto.request.QuestionRequest;
import com.peer.missionpeerflow.dto.response.QuestionResponse;
import com.peer.missionpeerflow.service.QuestionService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/question")
public class QuestionController {

	private final QuestionService questionService;

	@GetMapping("/{questionId}")
	@ResponseBody
	public QuestionResponse getQuestion(@PathVariable(name = "questionId") Long questionId) {
		return questionService.getQuestion(questionId);
	}

	@PostMapping("")
	public void postQuestion(@RequestBody @Valid QuestionRequest request) {
		questionService.postQuestion(request);
	}

	@PutMapping("/{questionId}")
	public void updateQuestion(@PathVariable(name = "questionId") Long questionId,
					@RequestBody @Valid QuestionRequest request) {
		questionService.updateQuestion(questionId, request);
	}

	@PostMapping("/{questionId}")
	public void deleteQuestion(@PathVariable(name = "questionId") Long questionId,
					@RequestBody @Valid DeleteRequest request) {
		questionService.deleteQuestion(questionId, request);
	}

	@PostMapping("/{questionId}/recommend")
	public String recommendQuestion(@PathVariable Long questionId) {
		questionService.recommendQuestion(questionId);
		return "redirect:/v1/question/" + questionId; // 해당 글로 리다이렉트
	}

}
