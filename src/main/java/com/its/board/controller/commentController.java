package com.its.board.controller;

import com.its.board.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.its.board.DTO.CommentDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Controller
@RequestMapping("/comment")
public class commentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO commentDTO) {
      boolean commentResult=  commentService.save(commentDTO);
      List<CommentDTO> commentList = commentService.saveList(commentDTO.getBoardId());
        System.out.println("commentList = " + commentList);
      if(commentResult) {
          return commentList;
      }else{
          return null;
      }
    }
}
