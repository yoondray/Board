package com.salody.dto;

public class BrdCriteria {

	//페이지 수
	private int pageNum;
	
	//한 페이지에 몇개의 게시글이 있는지
	private int inAmount;
	
	private String search;
	
	private String keyword;

	@Override
	public String toString() {
		return "BrdCriteria [pageNum=" + pageNum + ", inAmount=" + inAmount + ", search=" + search + ", keyword="
				+ keyword + "]";
	}
  
   //기본생성자
	public BrdCriteria() {
		this(1,10); //다른 생성자 호출 (페이지 1번부터 10번까지)
		
	}
	public BrdCriteria(int pageNum, int inAmount) {
		this.pageNum=pageNum;
		this.inAmount=inAmount;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getInAmount() {
		return inAmount;
	}
	public void setInAmount(int inAmount) {
		this.inAmount = inAmount;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
