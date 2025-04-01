package com.psc.thymeleef.model;

import com.psc.thymeleef.dto.BoardDTO;

import java.util.List;

public interface BoardDAO {
    List<BoardDTO> searchAllBoard();
}
