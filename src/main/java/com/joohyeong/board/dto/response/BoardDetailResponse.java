package com.joohyeong.board.dto.response;

import lombok.Builder;


public record BoardDetailResponse (
        long boardId,
        String title,
        String content,
        int view
){

    public BoardDetailResponse (long boardId, String title, String content, int view) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.view = view;
    }

}
