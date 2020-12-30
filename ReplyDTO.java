package com.salody.dto;

public class PageDTO {
	/*for문
	1페이지 (1부터 10까지) 
	for(int i=1; i<11; i++) {}
	2페이지 (11부터 20까지)
	21부터 30까지 for문으로 만들어라 (이전,다음 버튼이 있기때문)
	for(int i=11; i<=20; i++) {}*/
	
	
	//처음페이지 - 1, 11, 21, 31
	private int startPage;
	//끝 페이지 - 10, 20, 30, 40
	private int endPage;
	//tb1_board의 전체 데이터 수
	private int total;
	//이전버튼() - true or false
	private boolean prev;
	//다음버튼() - true or false
	private boolean next;
	//BrdCriteria DAO필통 추가
	private BrdCriteria bcri;

	
	public PageDTO(BrdCriteria bcri, int total) {
	//계산식 정의	
		this.bcri=bcri;
		this.total=total;
		
		//endPage (criteria의 this.pageNum -> getter -> private -> DTO)
		this.endPage=(int)(Math.ceil(bcri.getPageNum()/10.0))*10;
		//startPage
		this.startPage=this.endPage-9;
		
		//nowendPage 계산식 (마지막 페이지가 40이 아닌 30대 일때)
		int nowendPage=(int)(Math.ceil((total*1.0)/bcri.getInAmount()));
		//마지막 페이지만 30대로 다르게 나온다.
		if(nowendPage<endPage) {
			this.endPage=nowendPage;
		}
		//prev 버튼
		this.prev=this.startPage >1;
		//next 버튼
		this.next=this.endPage < nowendPage;
		
	}	
	
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public BrdCriteria getBcri() {
		return bcri;
	}
	public void setBcri(BrdCriteria bcri) {
		this.bcri = bcri;
	}
	
	
	
	
}
