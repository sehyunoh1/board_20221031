package com.its.board.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.its.board.DTO.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public BoardDTO save(BoardDTO boardDTO){
        System.out.println("insert 전 boardDTO = " + boardDTO);
        sql.insert("Board.save",boardDTO);
        System.out.println("insert 후 boardDTO = " + boardDTO);
        return boardDTO;
    }
    public void saveFileName(BoardDTO boardDTO) {
        sql.insert("Board.saveFile", boardDTO);
    }
    public List<BoardDTO> List (){return sql.selectList("Board.List");}

    public BoardDTO findbyId(Long boardId) {
        BoardDTO boardDTO = sql.selectOne("Board.findbyId", boardId);
        if (boardDTO.getFileAttached() == 1){
            return sql.selectOne("Board.fingbyIdFile", boardId);
    } else {
            return boardDTO;
        }
    }
    public int Hits(Long boardId){return sql.update("Board.boardHits",boardId);}
    public void delete (Long boardId) {sql.delete("Board.delete",boardId);}
    public BoardDTO deleteCk(Long boardId){return sql.selectOne("Board.deleteCk",boardId);}

    public int update(BoardDTO boardDTO){ return sql.update("Board.update",boardDTO);}


    public List<BoardDTO> pagingList(Map<String, Integer> pagingParams) {
        return sql.selectList("Board.pagingList",pagingParams);
    }

    public int boardCount (){
        return sql.selectOne("Board.boardCount");
    }

    public List<BoardDTO> search(Map<String, String> searchParams) {
        return sql.selectList("Board.search",searchParams);
    }
}
