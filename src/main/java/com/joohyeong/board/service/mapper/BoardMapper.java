package com.joohyeong.board.service.mapper;

import com.joohyeong.board.domain.Board;
import com.joohyeong.board.dto.request.BoardRegisterRequest;
import com.joohyeong.board.dto.response.BoardDetailResponse;
import com.joohyeong.board.dto.response.BoardListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {

    public Board mapToBoard(BoardRegisterRequest request) {
        return new Board(request.title(), request.content());
    }

    public Page<BoardListResponse> mapToBoardList(Page<Board> result) {
        return result.map(board -> new BoardListResponse(board.getBoardId(), board.getTitle(), board.getView()));
    }

    public BoardDetailResponse mapToBoardDetail(Board board) {
        return new BoardDetailResponse(board.getBoardId(), board.getTitle(), board.getContent(), board.getView());
    }

}
