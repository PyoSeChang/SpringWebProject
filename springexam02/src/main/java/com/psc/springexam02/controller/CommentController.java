package com.psc.springexam02.controller;

import com.psc.springexam02.dto.CommentDTO;
import com.psc.springexam02.model.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/insertComment")
    public String insertComment(@ModelAttribute CommentDTO comment) {
        commentService.insertComment(comment);

        return "redirect:/board/showBoardDetail?num=" + comment.getBnum();
    }
}
