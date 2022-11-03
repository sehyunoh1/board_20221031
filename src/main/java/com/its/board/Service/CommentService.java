package com.its.board.Service;

import com.its.board.DTO.CommentDTO;
import com.its.board.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public boolean save(CommentDTO commentDTO){
        System.out.println("commentDTO = " + commentDTO);
        int result =  commentRepository.save(commentDTO);
      if(result >= 1){
          return true;
      }else {
          return false;
      }
    }
}
