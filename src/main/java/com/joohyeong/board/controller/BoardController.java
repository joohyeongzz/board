package com.joohyeong.board.controller;

import com.joohyeong.board.domain.Board;
import com.joohyeong.board.dto.request.BoardRegisterRequest;
import com.joohyeong.board.dto.response.BoardDetailResponse;
import com.joohyeong.board.dto.response.BoardListResponse;
import com.joohyeong.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // JSON 반환 컨트롤러 의존성 주입
@RequiredArgsConstructor
@RequestMapping("/board")// final, @NotNull 필드의 생성자 자동 생성
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    private ResponseEntity<Long> registerBoard(@RequestBody BoardRegisterRequest request) {
        return ResponseEntity.ok(boardService.registerBoard(request));
    }

    @GetMapping
    private ResponseEntity<BoardDetailResponse> readBoard(@RequestParam long boardId) {
        return ResponseEntity.ok(boardService.getBoardDetail(boardId));
    }

    @GetMapping("/list")
    private ResponseEntity<Page<BoardListResponse>> readBoardList(@RequestParam int index, @RequestParam int size) {
        return ResponseEntity.ok(boardService.getBoardList(index,size));
    }

}
