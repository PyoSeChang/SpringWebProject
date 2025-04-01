package com.psc.springexam02.mapper.board;

import com.psc.springexam02.dto.board.BoardStatusDTO;
import org.apache.ibatis.annotations.Param;

public interface BoardStatusMapper {

    BoardStatusDTO selectBoardStatus(@Param("num")int num);
}
