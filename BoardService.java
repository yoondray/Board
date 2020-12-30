package com.salody.service;

import java.util.ArrayList;

import com.salody.dto.BoardDTO;
import com.salody.dto.BrdCriteria;

//Interface - class의 표준이 되는 파일
public interface Board2Service {

	//게시판 글쓰기(추상메소드)
	public void write2(BoardDTO bdto);
	
	//게시판 리스트
	public ArrayList<BoardDTO> list2(BrdCriteria bcri);
	
	//게시판 상세 페이지
	public BoardDTO detail2(BoardDTO bdto);
	
	//게시판 글 수정
	public void update2(BoardDTO bdto);
	
	//게시판 글 삭제
	public void delete2(BoardDTO bdto);
	
	//페이징 처리
	public int getTotal();
	
}
