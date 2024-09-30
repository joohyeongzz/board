package com.joohyeong.reply.dto.request;

public record ReplyRegisterRequest(
        Long boardId,
        String content
) {
}
