package com.salody.sldcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.salody.dto.BoardDTO;
import com.salody.dto.BrdCriteria;
import com.salody.dto.PageDTO;
import com.salody.service.Board2ServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(Board2Controller.class);
	
	@Autowired
	Board2ServiceImpl bservice;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void brdwrite2() {	
	}
	@RequestMapping(value="/writePost", method=RequestMethod.POST)
	public String postWrite(BoardDTO bdto, Model model) {
		System.out.println("writePost");
		
		bservice.write2(bdto);
		model.addAttribute("loadSult", "success");
		return "redirect:/board/list";	
	}
  
	//페이징 목록 리스트
	@GetMapping("/list")
	public void getListPaging(BrdCriteria bcri, Model model) {
		int total=bservice.getTotal();
    
		logger.info("criterita = " + bcri);
		logger.info("전체건수 = " + total);

		model.addAttribute("list2",bservice.list2(bcri));
		model.addAttribute("pageMaker",new PageDTO(bcri,total));
	}
	
  //상세보기 리스트
	@GetMapping("/read")
	public String detail2(Model model, BoardDTO bdto) {
		model.addAttribute("detail2",bservice.detail2(bdto));
    
		return "board/read";
	}
	
  //게시글 수정
	@GetMapping("/update")
	public void GetUpdate(BoardDTO bdto,Model model) {
		model.addAttribute("update2",bservice.detail2(bdto));
	}
	
	@PostMapping("/update")
	public String update2(BoardDTO bdto) {
		bservice.update2(bdto);

		return "redirect:/board/list";
	}
	
  //게시글 삭제
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete2(BoardDTO bdto) {
		logger.info("삭제하시겠습니까?");
		bservice.delete2(bdto);
		
		return "redirect:/board/list";
	}
	
}
