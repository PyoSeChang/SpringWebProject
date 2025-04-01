package com.psc.springexam02.controller;

import com.psc.springexam02.dto.board.BoardPageDTO;
import com.psc.springexam02.dto.board.BoardViewDTO;
import com.psc.springexam02.model.board.BoardService;
import com.psc.springexam02.dto.board.BoardDTO;
import com.psc.springexam02.model.comment.CommentService;
import jakarta.servlet.http.HttpSession;
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
    private final CommentService commentService;
    // 추가페이지로 이동하기
    @GetMapping("insertBoard")
    public String toGoInsertBoard() {
        return "board/insertBoard";
    }
    @PostMapping("insertBoard")
    public String insertBoard(@ModelAttribute BoardViewDTO board) {
        boardService.insertBoard(board);
        return "redirect:/board/showBoards";
    }
    @GetMapping("showBoards")
    public String showBoards(
            @RequestParam(name = "category", defaultValue = "free") String category,
            @RequestParam(name = "searchField", required = false) String searchField,
            @RequestParam(name = "searchWord", required = false) String searchWord,
            @RequestParam(name = "page", defaultValue = "1") int page,
            Model model
    ) {
        final int pageSize = 10;
        int offset = (page - 1) * pageSize;

        BoardPageDTO result;

        boolean isSearching = (searchWord != null && !searchWord.trim().isEmpty());

        if (isSearching) {
            result = boardService.selectBoardsByCategory(category, searchField, searchWord, offset, pageSize);
        } else {
            result = boardService.selectBoardsByCategory(category, offset, pageSize);
        }

        int totalPages = (int) Math.ceil((double) result.getTotalCount() / pageSize);

        model.addAttribute("boardList", result.getBoardList());
        model.addAttribute("count", result.getTotalCount());
        model.addAttribute("category", category);
        model.addAttribute("searchField", searchField);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("page", page);
        model.addAttribute("totalPages", totalPages);

        return "board/showBoards";
    }

    @GetMapping("showBoardDetail")
    public String showBoardDetail(@RequestParam(name = "num") int num, Model model, HttpSession session) {
        String sessionKey = "viewed_board_" + num;

        // 같은 세션 내에서 중복 조회 방지
        if (session.getAttribute(sessionKey) == null) {
            boardService.increaseReadCount(num);  // 조회수 증가
            session.setAttribute(sessionKey, true);
        }

        BoardViewDTO board = boardService.assembleBoardViewDTO(num);
        model.addAttribute("board", board);
        model.addAttribute("commentList", commentService.showComments(num));

        return "board/showBoardDetail";
    }
    @PostMapping("/verifyUpdate")
    public String verifyBoardPassword(@RequestParam("num") int num,
                                      @RequestParam("password") String password,
                                      HttpSession session,
                                      RedirectAttributes ra) {
        BoardViewDTO board = boardService.showBoardDetail(num);

        if (board != null && board.getPassword().equals(password)) {
            session.setAttribute("verifiedBoardNum", num);
            session.setAttribute("isPasswordVerified", true);
            session.setAttribute("verifiedUserId", board.getUserid());
            session.setAttribute("verifiedPassword", password);
            return "redirect:/board/updateBoard?num=" + num;
        } else {
            ra.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
            return "redirect:/board/showBoardDetail?num=" + num;
        }
    }
    @GetMapping("/updateBoard")
    public String showUpdateBoardForm(@RequestParam("num") int num,
                                      HttpSession session,
                                      Model model) {
        Object verified = session.getAttribute("verifiedBoardNum");
        if (verified == null || !verified.equals(num)) {
            return "redirect:/board/showBoardDetail?num=" + num;
        }


        BoardViewDTO board = boardService.showBoardDetail(num);
        model.addAttribute("board", board);
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
    @PostMapping("deleteBoard")
    public String deleteBoard( HttpSession session,@RequestParam(name="num") int num,
                              @RequestParam(name="password") String password,
                              RedirectAttributes ra) {
        BoardViewDTO board = boardService.showBoardDetail(num);

        if (board != null && board.getPassword().equals(password)) {

            session.setAttribute("isPasswordVerified", true);
            session.setAttribute("verifiedUserId", board.getUserid());
            session.setAttribute("verifiedPassword", password);
            commentService.deleteAllComments(num);
            boardService.deleteBoard(num);
            return "redirect:/board/showBoards";
        } else {
            ra.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
            return "redirect:/board/showBoardDetail?num=" + num;
        }
    }

    @PostMapping("react")
    public String reactToBoard(
            @RequestParam("num") int num,
            @RequestParam("reactionType") String reactionType,
            HttpSession session
    ) {
        String sessionKey = "reaction_board_" + num;
        String prevReaction = (String) session.getAttribute(sessionKey);

        if (prevReaction != null) {
            // 동일 반응이면 아무것도 안 함
            if (prevReaction.equals(reactionType)) {
                return "redirect:/board/showBoardDetail?num=" + num;
            } else {
                // 다른 반응으로 전환 (like ↔ dislike)
                if ("like".equals(reactionType)) {
                    boardService.decreaseDislikeCount(num);
                    boardService.increaseLikeCount(num);
                    session.setAttribute(sessionKey, "like");
                } else if ("dislike".equals(reactionType)) {
                    boardService.decreaseLikeCount(num);
                    boardService.increaseDislikeCount(num);
                    session.setAttribute(sessionKey, "dislike");
                }
                return "redirect:/board/showBoardDetail?num=" + num;
            }
        } else {
            // 처음 반응 등록
            if ("like".equals(reactionType)) {
                boardService.increaseLikeCount(num);
                session.setAttribute(sessionKey, "like");
            } else if ("dislike".equals(reactionType)) {
                boardService.increaseDislikeCount(num);
                session.setAttribute(sessionKey, "dislike");
            }
            return "redirect:/board/showBoardDetail?num=" + num;
        }
    }
    @GetMapping("/resetAllBoardSession")
    public String resetAllBoardSession(HttpSession session) {
        // 세션에 저장된 reaction, view 관련 속성 전체 제거
        session.getAttributeNames().asIterator().forEachRemaining(attrName -> {
            if (attrName.startsWith("reaction_board_") || attrName.startsWith("viewed_board_")) {
                session.removeAttribute(attrName);
            }
        });
        return "redirect:/board/showBoards"; // 다시 게시판으로
    }
}
