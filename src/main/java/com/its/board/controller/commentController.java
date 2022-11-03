package com.its.board.controller;

import com.its.board.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.its.board.DTO.CommentDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Controller
@RequestMapping("/comment")
public class commentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public String save(@ModelAttribute CommentDTO commentDTO, Model model) {
        System.out.println(commentDTO);
        boolean result = commentService.save(commentDTO);
        model.addAttribute("comment",commentDTO);
        if (result) {
            return "redirect:/board/board?boardId=" + commentDTO.getBoardId();
        } else {
            return "boardDetail";
        }
    }
}
