package com.its.board.Service;

import com.its.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.its.board.DTO.BoardDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public void  save(BoardDTO boardDTO) throws IOException { // 예외처리시 호출한 메소드에 다시 보냄
    /* 
        1. BoardDTO 객체에 담긴 파일을 꺼냄.
        2. 파일의 원본 이름을 가져옴.(originalFileName)
        3. 서버 관리용 이름 생성 (storedFileName)
        4. originalFileName,storedFileName을 DTO 객체에 담음.
        5. 파일 실제 저장위치 지정.
        6. 파일 저장 처리.
        7. repository로 DTO 객체 전달
    */
        if(!boardDTO.getBoardFile().isEmpty()){
            System.out.println("파일있음.");
            MultipartFile boardFile= boardDTO.getBoardFile(); //1.
            String originalFilename= boardFile.getOriginalFilename();//2.
            System.out.println("originalFilename = " + originalFilename);
            System.out.println(System.currentTimeMillis());
            String storedFileName= System.currentTimeMillis()+"-"+ originalFilename;//3.
            System.out.println("stordFileName" + storedFileName); //3번 확인용
            boardDTO.setOriginalFileName(originalFilename);
            boardDTO.setStoredFileName(storedFileName);//4.
            String savePath ="D:\\spring_img\\"+ storedFileName;//5.
            boardFile.transferTo(new File(savePath));//6.
            boardDTO.setFileAttached(1);
            BoardDTO saveBoard = boardRepository.save(boardDTO);//7.
            boardRepository.saveFileName(saveBoard);
        }else {
            System.out.println("파일없음.");
            boardDTO.setFileAttached(0);
            boardRepository.save(boardDTO);
        }

//    int result =boardRepository.save(boardDTO);
//    if(result >0){
//        return true;
//    }else {
//        return false;
//    }
//        return true;
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
