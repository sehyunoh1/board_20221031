package com.its.board.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.its.board.DTO.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save(BoardDTO boardDTO){return sql.insert("Board.save",boardDTO);}

    public List<BoardDTO> List (){return sql.selectList("Board.List");}

    public BoardDTO findbyId(Long boardId){
      BoardDTO boardDTO =  sql.selectOne("Board.findbyId",boardId);
//      boardDTO.setBoardHits(sql.update("Board.boardHits",boardId));
        return boardDTO;
    }
    public int Hits(Long boardId){return sql.update("Board.boardHits",boardId);}
    public void delete (Long boardId) {sql.delete("Board.delete",boardId);}
    public BoardDTO deleteCk(Long boardId){return sql.selectOne("Board.deleteCk",boardId);}

    public int update(BoardDTO boardDTO){ return sql.update("Board.update",boardDTO);}
}
