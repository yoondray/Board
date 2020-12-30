package com.salody.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salody.dto.BoardDTO;
import com.salody.dto.BrdCriteria;
import com.salody.mapper.BoardAttachDAO;
import com.salody.mapper.BoardDAO;

@Service
public class Board2ServiceImpl implements Board2Service {
	
	@Autowired
	BoardDAO bdao;	
	@Autowired
	BoardAttachDAO battdao;
	
	@Transactional

	public void write2(BoardDTO bdto) {
		bdao.write2(bdto);
    
		// 첨부파일이 있을 때, 실행
		if(bdto.getAttachList()!=null) {
			bdto.getAttachList().forEach(attach->{
      
				attach.setBno(bdto.getBno());
				battdao.insert(attach);
			
			});			
		}

	}
  //게시판 리스트
	public ArrayList<BoardDTO> list2(BrdCriteria bcri){
		return bdao.list2(bcri);
	}
  
  //게시판 상세보기
	public BoardDTO detail2(BoardDTO bdto) {
		return bdao.detail2(bdto);
	}
  
 //게시글 수정
	public void update2(BoardDTO bdto) {
		bdao.update2(bdto);
	}
  
  //게시글 
	public void delete2(BoardDTO bdto) {
		bdao.delete2(bdto);		
	}
  
	//페이징 처리하기위한 전체 건 수
	public int getTotal() {
		return bdao.getTotal();
	}

}
