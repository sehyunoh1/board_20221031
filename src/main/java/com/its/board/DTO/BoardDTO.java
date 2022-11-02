package com.its.board.DTO;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
   private Long BoardId;
   private String BoardWriter;
   private String BoardPass;
   private String BoardTitle;
   private String BoardContents;
   private Timestamp BoardCreatedDate;
   private int BoardHits;
   //파일을 담기위한 필드
   private MultipartFile boardFile;
   //원본파일 이름용 필드
   private String  originalFileName;
   //서버관리 이름용 필드
   private String storedFileName;
}
