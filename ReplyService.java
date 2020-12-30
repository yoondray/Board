package com.salody.service;

import java.util.ArrayList;

import com.salody.dto.ReplyDTO;

public interface ReplyService {

	//댓글 쓰기
	public int replyIns(ReplyDTO rdto);
  
	//댓글 조회
	public ArrayList<ReplyDTO> replyList(int bno);
  
	//댓글 수정
	public int replyUpt(ReplyDTO rdto);
  
	//댓글 삭제
	public int replyDel(ReplyDTO rdto);
}
