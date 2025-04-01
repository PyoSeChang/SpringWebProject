package com.psc.springexam02.model.board;

import com.psc.springexam02.dto.board.BoardDTO;
import com.psc.springexam02.dto.board.BoardMetaDTO;
import com.psc.springexam02.dto.board.BoardStatusDTO;
import com.psc.springexam02.dto.board.BoardViewDTO;

import java.util.List;

public interface BoardServiceInterface {
    // 추가
    void insertBoard(BoardDTO board);
    // 전체보기
    List<BoardDTO> showBoards();
    // 검색한 보드 보기
    List<BoardDTO> showBoards(String searchField, String searchWord);
    // 갯수
    int countBoards();
    // 검색한 갯수 보기
    int countBoards(String searchField, String searchWord);
    // 상세보기
    BoardViewDTO showBoardDetail(int num);
    // 수정
    void updateBoard(BoardDTO board);
    // 삭제
    void deleteBoard(int num);
    // 보드 가져오기
    BoardDTO getBoard(int num);
    // 메타 정보 가져오기
    BoardMetaDTO getMeta(int num);

    // Status 정보 가져오기
    BoardStatusDTO getStatus(int num);

    // BoardViewDTO 조립
    BoardViewDTO assembleBoardViewDTO(int num);

}
