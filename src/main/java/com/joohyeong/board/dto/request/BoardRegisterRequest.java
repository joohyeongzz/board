package com.joohyeong.board.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BoardRegisterRequest(
        @NotBlank
        String title,
        String content
) {
}
