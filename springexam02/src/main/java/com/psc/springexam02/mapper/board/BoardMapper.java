package com.psc.springexam02.mapper.board;

import com.psc.springexam02.dto.board.BoardDTO;
import com.psc.springexam02.dto.board.BoardMetaDTO;
import com.psc.springexam02.dto.board.BoardStatusDTO;
import com.psc.springexam02.dto.board.BoardViewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    // 추가
    void insertBoard(BoardViewDTO board);
    List<BoardViewDTO> selectBoardsByCategory(
            @Param("category") String category,
            @Param("offset") int offset,
            @Param("limit") int limit);

    List<BoardViewDTO> selectBoardsByCategoryWithSearch(
            @Param("category") String category,
            @Param("field") String field,
            @Param("word") String word,
            @Param("offset") int offset,
            @Param("limit") int limit);

    int countBoardsByCategory(@Param("category") String category);

    int countBoardsByCategoryWithSearch(
            @Param("category") String category,
            @Param("field") String field,
            @Param("word") String word);
    // 상세 보기
    BoardViewDTO showBoardDetail(@Param("num")int num);
    // 수정
    void updateBoard(BoardDTO board);
    // 삭제
    void deleteBoard(int num);
    //
    BoardDTO selectBoard(@Param("num")int num);


}
