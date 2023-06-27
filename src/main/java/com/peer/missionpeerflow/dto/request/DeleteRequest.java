package com.peer.missionpeerflow.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DeleteRequest {

	private String type;

	@NotNull
	private String password;
}