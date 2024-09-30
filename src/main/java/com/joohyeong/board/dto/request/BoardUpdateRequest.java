package com.joohyeong.board.dto.request;

public record BoardUpdateRequest (
        long boardId,
        String title,
        String content
) {
}
