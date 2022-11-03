package com.its.board.controller;

import com.google.protobuf.RpcUtil;
import com.its.board.DTO.BoardDTO;
import com.its.board.DTO.PageDTO;
import com.its.board.Service.BoardService;
import com.its.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
     boardService.save(boardDTO);
        return "redirect:/board/";
    }

    @GetMapping("/")
    public String List(Model model){
        List<BoardDTO> boardList = boardService.List();
        model.addAttribute("boardList",boardList);
        return "boardList";
    }
    //페이징 목록
    @GetMapping("/paging")
    public  String paging(Model model,
                          @RequestParam(value = "page", required = false,defaultValue = "1") int page){
        //해당 페이지에서 보여줄 글 목록
        List<BoardDTO> pagingList = boardService.pagingList(page);
        //하단 페이지 번호 표현을 위한 데이터
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList",pagingList);
        model.addAttribute("paging",pageDTO);
        return "boardPaging";
    }

    @GetMapping // 파라미터가 있는경우 안적어도 됨.
    public String findbyId(@RequestParam("boardId") Long boardId, Model model,
                           @RequestParam(value = "page", required = false,defaultValue = "1") int page){
        BoardDTO boardDTO= boardService.findbyId(boardId);
        model.addAttribute("board",boardDTO);
        model.addAttribute("page",page);
        System.out.println("조회: boardDTO = " + boardDTO);
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
      // BoardDTO DTO= boardService.findById(boardDTO.getId());
      // model.addAttribute("board",DTO) 조회수가 늘어나지 않는 방법;
      if(result) {
          return "redirect:/board?boardId=" + boardDTO.getBoardId(); //조회수가 하나 늘어나는 방법
      }else {
          return "boardDetail";
      }
    }

    //검색 처리
    @GetMapping("/search")
    public String search(@RequestParam("type") String type,
                         @RequestParam("q") String q, Model model){
    List<BoardDTO> searchList = boardService.search(type,q);
    model.addAttribute("boardList",searchList);
    return "boardList";
    }
}

