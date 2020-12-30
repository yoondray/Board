package com.salody.mapper;

import java.util.List;

import com.salody.dto.BoardDTO;


public interface BoardMapper {

	//1. 게시판 리스트
	public List<BoardDTO> getList();
	
	//2. 게시판 글쓰기
	public void boardInsert(BoardDTO bdto);
	
	//3. 게시판 글 수정
	public void boardUpdate(BoardDTO bdto);
	
	//4. 게시판 글 삭제
	public void boardDelete(BoardDTO bdto);
	
	//5. 게시판 글 1건 리스트
	//public void boardDetail(BoardDTO bdtd);
}
