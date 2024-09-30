package com.joohyeong.board.domain;

import com.joohyeong.board.dto.request.BoardUpdateRequest;
import com.joohyeong.global.domain.BaseEntity;
import com.joohyeong.reply.domain.Reply;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 5000, nullable = false)
    private String content;

    private int view;



    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(BoardUpdateRequest request) {
        if (!this.title.equals(request.title())) {
            this.title = request.title();
        }
        if (!this.content.equals(request.content())) {
            this.content = request.content();
        }
    }

    public void incrementViewCount() {
        this.view++;
    }


}
