package com.psc.springexam02.mapper.board;

import com.psc.springexam02.dto.board.BoardStatusDTO;
import org.apache.ibatis.annotations.Param;

public interface BoardStatusMapper {

    BoardStatusDTO selectBoardStatus(@Param("num")int num);

    void updateLikeCount(@Param("num")int num, @Param("amount")int amount);
    void updateDislikeCount(@Param("num")int num, @Param("amount")int amount);

    void updateReadCount(@Param("num")int num);
}

