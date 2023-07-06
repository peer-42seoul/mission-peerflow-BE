package com.peer.missionpeerflow.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainPageReqDto {

    private String category;
    private String sort;
    private int pageIndex;
    private int pageSize;
}
