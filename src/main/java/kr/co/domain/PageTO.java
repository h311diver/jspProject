package kr.co.domain;

import java.util.List;

public class PageTO {
	private int curPage;
	private int perPage = 10;
	private int amount;
	private int perLine = 10;
	
	private int totalPage;
	private int startNum;
	private int endNum;
	private List<PostingDTO> listPosting;
	private List<MemberDTO> listMember;
	private List<InformationDTO> listInformation;
	
	private int beginPageNum;
	private int endPageNum;
	
	
	
	public PageTO() {
		
		calc();
	}
		
	public PageTO(int curPage) {
		this.curPage = curPage;
		
		calc();
	}
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
		calc();
	}

	public int getPerPage() {
		return perPage;
	}


	public void setPerPage(int perPage) {
		this.perPage = perPage;
		calc();
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
		calc();
	}


	public int getPerLine() {
		return perLine;
	}


	public void setPerLine(int perLine) {
		this.perLine = perLine;
		calc();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getStartNum() {
		return startNum;
	}


	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}


	public List<PostingDTO> getListPosting() {
		return listPosting;
	}


	public void setListPosting(List<PostingDTO> listPosting) {
		this.listPosting = listPosting;
	}
	
	
	
	

	public List<MemberDTO> getListMember() {
		return listMember;
	}

	public void setListMember(List<MemberDTO> listMember) {
		this.listMember = listMember;
	}

	

	

	public int getBeginPageNum() {
		return beginPageNum;
	}


	
	
	
	

	public List<InformationDTO> getListInformation() {
		return listInformation;
	}

	public void setListInformation(List<InformationDTO> listInformation) {
		this.listInformation = listInformation;
	}

	public void setBeginPageNum(int beginPageNum) {
		this.beginPageNum = beginPageNum;
	}


	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

	
	
	
	
	private void calc() {
		totalPage = (amount-1)/perPage +1;
		
		startNum = (curPage-1)*perPage + 1;

		endNum =  startNum + perPage -1;
		if(endNum > amount){
			endNum = amount;
		}
		
		beginPageNum = ((curPage-1)/perLine)*perLine + 1;


		endPageNum = beginPageNum + perLine - 1;
		if(endPageNum > totalPage){
			endPageNum = totalPage;
		}
	}
	
	
	
	
	
	

}
