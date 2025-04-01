package com.psc.thymeleef.model;

import com.psc.thymeleef.dto.BoardDTO;
import com.psc.thymeleef.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {
    private final BoardMapper boardMapper;
    @Override
    public List<BoardDTO> searchAllBoard() {
        return boardMapper.selectAll();
    }
}
