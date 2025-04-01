package com.psc.thymeleef.model;



import com.psc.thymeleef.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    List<BoardDTO> getList();


    BoardDTO getBoardByNum();


    void writeBoard(BoardDTO dto);


    void removeBoard(BoardDTO dto);


    void modifyBoard(BoardDTO dto);
}
