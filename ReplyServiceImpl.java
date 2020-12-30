package com.salody.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salody.dto.ReplyDTO;
import com.salody.mapper.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	ReplyDAO rdao;
	
	@Override
	public int replyIns(ReplyDTO rdto) {
		return rdao.replyIns(rdto);
	}

	public ArrayList<ReplyDTO> replyList(int bno) {
		return rdao.replyList(bno);
	}
	
	public int replyDel(ReplyDTO rdto) {
		return rdao.replyDel(rdto);
	}	
	
	public int replyUpt(ReplyDTO rdto) {
		return rdao.replyUpt(rdto);
	}



}
