package com.psc.springexam02.controller;

import com.psc.springexam02.dto.CommentDTO;
import com.psc.springexam02.model.comment.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/insertComment")
    public String insertComment(@ModelAttribute CommentDTO comment, RedirectAttributes rttr) {
        commentService.insertComment(comment);
        rttr.addAttribute("num", comment.getBnum());
        return "redirect:/board/showBoardDetail";
    }
    @PostMapping("/deleteComment")
    public String deleteComment(@RequestParam(name="cnum") int cnum,
                                @RequestParam(name="bnum") int bnum,
                                @RequestParam(name="password") String password,
                                RedirectAttributes ra, HttpSession session) {
        CommentDTO comment = commentService.showComment(cnum);

        if (comment != null && comment.getPassword().equals(password)) {

            session.setAttribute("isPasswordVerified", true);
            session.setAttribute("verifiedUserId", comment.getUserid());
            session.setAttribute("verifiedPassword", password);

            commentService.deleteComment(cnum);
            return "redirect:/board/showBoardDetail?num=" + bnum;
        } else {
            ra.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
            return "redirect:/board/showBoardDetail?num=" + bnum;
        }
    }
    @PostMapping("/verifyUpdate")
    public String verifyCommentPassword(@RequestParam("cnum") int cnum,
                                        @RequestParam("bnum") int bnum,
                                        @RequestParam("password") String password,
                                        HttpSession session,
                                        RedirectAttributes ra) {
        CommentDTO comment = commentService.showComment(cnum);

        if (comment != null && comment.getPassword().equals(password)) {
            session.setAttribute("verifiedCommentCnum", cnum);
            session.setAttribute("isPasswordVerified", true);
            session.setAttribute("verifiedUserId", comment.getUserid());
            session.setAttribute("verifiedPassword", password);
            return "redirect:/comment/updateComment?cnum=" + cnum + "&bnum=" + bnum;
        } else {
            ra.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
            return "redirect:/board/showBoardDetail?num=" + bnum;
        }
    }
    @GetMapping("/updateComment")
    public String toGoUpdateComment(@RequestParam("cnum") int cnum,
                                        @RequestParam("bnum") int bnum,
                                        HttpSession session,
                                        Model model) {
        Object verified = session.getAttribute("verifiedCommentCnum");
        if (verified == null || !verified.equals(cnum)) {
            return "redirect:/board/showBoardDetail?num=" + bnum;
        }

        CommentDTO comment = commentService.showComment(cnum);
        model.addAttribute("comment", comment);
        return "comment/updateComment";
    }

    @PostMapping("/updateComment")
    public String updateComment(@ModelAttribute CommentDTO comment, RedirectAttributes rttr) {
        commentService.updateComment(comment);
        rttr.addAttribute("num", comment.getBnum());
        return "redirect:/board/showBoardDetail";
    }
}
