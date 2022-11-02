package com.its.board.controller;

import com.google.protobuf.RpcUtil;
import com.its.board.DTO.BoardDTO;
import com.its.board.Service.BoardService;
import com.its.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("/board")

public class BoardController {
   @Autowired
    private BoardService boardService;
   private  BoardRepository boardRepository;

    @GetMapping("/save")
    // @RequestMapping(value="/save",method=RequestMethod.POST)
    public String saveform(){ return "boardSave";}

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
    boolean saveResult = boardService.save(boardDTO);
    if(saveResult ){
        return "redirect:/board/";
    }else {
        return "savefail";
    }
    }

    @GetMapping("/")
    public String List(Model model){
        List<BoardDTO> boardList = boardService.List();
        model.addAttribute("boardList",boardList);
        return "boardList";
    }
    @GetMapping // 파라미터가 있는경우 안적어도 됨.
    public String findbyId(@RequestParam("boardId") Long boardId, Model model){
        BoardDTO boardDTO= boardService.findbyId(boardId);
        model.addAttribute("board",boardDTO);
        return "boardDetail";
    }
    @GetMapping("/deleteCheck")
    public String deleteCk(Long boardId , Model model){
        BoardDTO boardPassword =boardService.deleteCk(boardId);
        model.addAttribute("board",boardPassword);
        return "deleteCheck";}
    @GetMapping ("/delete")
    public String delete(@RequestParam("boardId") Long boardId) {
        System.out.println(boardId);
        boardService.delete(boardId);
        return "redirect:/board/";
    }

    @GetMapping("/update")
    public String updateform(@RequestParam("boardId") Long boardId, Model model){
    BoardDTO boardDTO=boardService.findbyId(boardId);
    model.addAttribute("board",boardDTO);
        return "boardUpdate";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO){
      boolean result = boardService.update(boardDTO);
        System.out.println(result);
      if(result) {
          return "redirect:/board?boardId=" + boardDTO.getBoardId();
      }else {
          return "boardDetail";
      }
    }
}

