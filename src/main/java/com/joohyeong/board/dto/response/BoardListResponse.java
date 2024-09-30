package com.joohyeong.board.dto.response;

public record BoardListResponse (
        long boardId,
        String title,
        int view
) {
}
