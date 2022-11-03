package com.its.board.Repository;

import com.its.board.DTO.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int save(CommentDTO commentDTO){
        return sql.insert(("Comment.save"), commentDTO);}
}
