package com.salody.mapper;

import java.util.ArrayList;

import com.salody.dto.BoardDTO;
import com.salody.dto.BrdCriteria;

public interface BoardDAO {
	//글쓰기를 위한 DAO
	public void write2(BoardDTO bdto);
  
	//리스트 보기
	public ArrayList<BoardDTO> list2(BrdCriteria bcri);
  
	//상세리스트 보기
	public BoardDTO detail2(BoardDTO bdto);
	
  //수정하기
	public void update2(BoardDTO bdto);
	
  //삭제하기
	public void delete2(BoardDTO bdto);
	
	//페이징 처리
	public int getTotal();
	
	
}
