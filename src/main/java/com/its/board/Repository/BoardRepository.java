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

    public BoardDTO findbyId(Long boardId){ return sql.selectOne("Board.findbyId",boardId);}

    public void delete (Long boardId) {sql.delete("Board.delete",boardId);}
}
