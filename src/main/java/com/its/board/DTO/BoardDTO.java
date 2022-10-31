package com.its.board.DTO;

import lombok.*;

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
   private LocalDateTime BoardCreatedDate;
   private int BoardHits;

}
