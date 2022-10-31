package com.its.board.controller;

import com.google.protobuf.RpcUtil;
import com.its.board.DTO.BoardDTO;
import com.its.board.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class BoardController {
   @Autowired
    private BoardService boardService;

    @GetMapping("/board/save")
    public String saveform(){ return "boardSave";}

    @PostMapping("/board/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
    boolean saveResult = boardService.save(boardDTO);
    if(saveResult ){
        return "boardList";
    }else {
        return "savefail";
    }
    }

    @GetMapping("/board/")
    public String List(Model model){
        List<BoardDTO> boardList = boardService.List();
        model.addAttribute("boardList",boardList);
        return "boardList";
    }
    @GetMapping("/board")
    public String findbyId(@RequestParam("boardId") Long boardId, Model model){
        BoardDTO boardDTO = boardService.findbyId(boardId);
        model.addAttribute("board",boardDTO);
        return "boardDetail";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("boardId") Long boardId){
        boardService.delete(boardId);
        return "redirect:/board/";
    }
}

