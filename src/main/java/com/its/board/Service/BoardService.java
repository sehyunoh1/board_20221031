package com.its.board.Service;

import com.its.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.its.board.DTO.BoardDTO;
import java.util.List;
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public boolean save(BoardDTO boardDTO){
    int result =boardRepository.save(boardDTO);
    if(result >0){
        return true;
    }else {
        return false;
    }
    }
    public List<BoardDTO> List(){ return boardRepository.List();}

    public BoardDTO findbyId(Long boardId){
        boardRepository.Hits(boardId);
        BoardDTO boardDTO=  boardRepository.findbyId(boardId);
        return boardDTO;
    }
    public BoardDTO deleteCk(Long boardId){
        return boardRepository.deleteCk(boardId);
    }
    public void delete(Long boardId){boardRepository.delete(boardId);}

    public boolean update (BoardDTO boardDTO){
      int result =  boardRepository.update(boardDTO);
        if(result>0) {
            return true;
        }else{
            return false;
        }
    }
}
