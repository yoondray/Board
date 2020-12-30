package com.salody.mapper;

import java.util.ArrayList;

import com.salody.dto.ReplyDTO;

public interface ReplyDAO {

	//댓글쓰기
	  public int replyIns(ReplyDTO rdto);	
	
	//댓글조회
	  public ArrayList<ReplyDTO> replyList(int bno);
	
	//댓글삭제
	  public int replyDel(ReplyDTO rdto); 
	  
	//댓글수정
	  public int replyUpt(ReplyDTO rdto);
	  

}
