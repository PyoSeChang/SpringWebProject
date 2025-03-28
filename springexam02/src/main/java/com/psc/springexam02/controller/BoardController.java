package com.psc.springexam02.controller;

import com.psc.springexam02.model.board.BoardService;
import com.psc.springexam02.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    // 추가페이지로 이동하기
    @GetMapping("insertBoard")
    public String toGoInsertBoard() {
        return "board/insertBoard";
    }
    @PostMapping("insertBoard")
    public String insertBoard(@ModelAttribute BoardDTO board) {
        boardService.insertBoard(board);
        return "redirect:/board/showBoards";
    }
    // 전체보기
    @GetMapping("showBoards")
    public String showBoards(@RequestParam(name="searchField", required = false)String searchField,
                             @RequestParam(name="searchWord", required = false)String searchWord,Model model) {
        List<BoardDTO> blist;
        int count;
        if (searchWord != null && !searchWord.trim().isEmpty()) {
            blist = boardService.showBoards(searchField, searchWord);
            count = boardService.countBoards(searchField, searchWord);
        } else {
            // 검색어 없으면 전체 조회
            blist = boardService.showBoards();
            count = boardService.countBoards();
        }
        model.addAttribute("blist", blist);
        model.addAttribute("count", count);
        return "board/showBoards";
    }
    // 상세보기
    @GetMapping("showBoardDetail")
    public String showBoardDetail(@RequestParam(name="num") int num,Model model) {
        model.addAttribute("board", boardService.showBoardDetail(num));
        return "board/showBoardDetail";
    }
    // 수정 페이지 이동
    @GetMapping("updateBoard")
    public String toGOUpdateBoard(@RequestParam(name="num") int num,Model model) {
        model.addAttribute("board", boardService.showBoardDetail(num));
        return "board/updateBoard";
    }
    // 수정하기
    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute BoardDTO board,
                              @RequestParam("num") int num,
                              RedirectAttributes rttr) {
        board.setNum(num);
        // 게시물 수정
        boardService.updateBoard(board);

        // 상세페이지로 리다이렉트 (파라미터 전달)
        rttr.addAttribute("num", num);
        return "redirect:/board/showBoardDetail";
    }
    // 삭제하기
    @GetMapping("deleteBoard")
    public String deleteBoard(@RequestParam(name="num") int num) {
        boardService.deleteBoard(num);
        return "redirect:/board/showBoards";
    }
}
