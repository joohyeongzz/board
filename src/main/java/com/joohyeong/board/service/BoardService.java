package com.joohyeong.board.service;

import com.joohyeong.board.domain.Board;
import com.joohyeong.board.dto.request.BoardRegisterRequest;
import com.joohyeong.board.dto.request.BoardUpdateRequest;
import com.joohyeong.board.dto.response.BoardDetailResponse;
import com.joohyeong.board.dto.response.BoardListResponse;
import com.joohyeong.board.service.exception.BoardErrorCode;
import com.joohyeong.board.service.mapper.BoardMapper;
import com.joohyeong.board.repository.BoardRepository;
import com.joohyeong.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public long registerBoard(BoardRegisterRequest request) {
        return boardRepository.save(boardMapper.mapToBoard(request)).getBoardId();
    }

    public void deleteBoard(long boardId) {
        boardRepository.deleteByBoardId(boardId);
    }

    public void updateBoard(BoardUpdateRequest request) {
        Board board = findById(request.boardId());

        board.update(request);
    }

    public BoardDetailResponse getBoardDetail(long boardId) {
        Board board = findById(boardId);

        board.incrementViewCount();

        return boardMapper.mapToBoardDetail(board);
    }

    public Page<BoardListResponse> getBoardList(int index, int size) {

        Page<Board> result = boardRepository.findAll
                (PageRequest.of(index, size, Sort.by("boardId").descending()));

        return boardMapper.mapToBoardList(result);
    }

    public Board findById(long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new GlobalException(BoardErrorCode.NOT_FOUND_BOARD));
    }

}
