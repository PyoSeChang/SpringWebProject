package com.psc.springexam02.mapper.board;

import com.psc.springexam02.dto.board.BoardMetaDTO;
import org.apache.ibatis.annotations.Param;

public interface BoardMetaMapper {
    //
    public BoardMetaDTO getMeta(int num);

    BoardMetaDTO selectBoardMeta(@Param("num")int num);
}
