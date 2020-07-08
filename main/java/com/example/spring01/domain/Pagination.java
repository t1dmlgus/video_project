package com.example.spring01.domain;
public class Pagination {

	
	/** �� �������� �Խñ� �� **/
    private int pageSize = 10;
    
    /** �� ��(range)�� ������ �� **/
    private int rangeSize = 10;
    
    /** ���� ������ **/
    private int curPage = 1;
    
    /** ���� ��(range) **/
    private int curRange = 1;
    
    /** �� �Խñ� �� **/
    private int listCnt;
    
    /** �� ������ �� **/
    private int pageCnt;
    
    /** �� ��(range) �� **/
    private int rangeCnt;
    
    /** ���� ������ **/
    private int startPage = 1;
    
    /** �� ������ **/
    private int endPage = 1;
    
    /** ���� index **/
    private int startIndex = 0;
    
    /** ���� ������ **/
    private int prevPage;
    
    /** ���� ������ **/
    private int nextPage;
 
	
	
    public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getCurRange() {
		return curRange;
	}

	public void setCurRange(int curRange) {
		this.curRange = curRange;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getRangeCnt() {
		return rangeCnt;
	}

	public void setRangeCnt(int rangeCnt) {
		this.rangeCnt = rangeCnt;
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

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}


}