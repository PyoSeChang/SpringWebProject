package com.psc.springexam02.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@AllArgsConstructor
@Getter
@Setter
public class BoardPageDTO {
    private List<BoardViewDTO> boardList;
    private int totalCount;

    public BoardPageDTO() {
        
    }

}
