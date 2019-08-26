package com.zl.pojo.htfenye;

public class FenYe {
	private Integer page;// 当前请求页码
	private Integer rows = 5;// 每页显示条数
	private Integer rowsCount;// 查询符合条件总记录条数
	private Integer pageCount;// 总页码数
	private Integer startRows;// 起始条数 1
	private String clientIDcard;
	private String clientName;
	private String cardName;
	private String mangerName;
	private long cardNum;
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(Integer rowsCount) {
		this.rowsCount = rowsCount;
	}

	public Integer getPageCount() {
		if (getRowsCount() % getRows() == 0) {
			pageCount = getRowsCount() / getRows();
		} else {
			pageCount = getRowsCount() / getRows() + 1;
		}
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getStartRows() {
		startRows = (getPage() - 1) * getRows();
		return startRows;
	}

	public void setStartRows(Integer startRows) {
		this.startRows = startRows;
	}

	public String getClientIDcard() {
		return clientIDcard;
	}

	public void setClientIDcard(String clientIDcard) {
		this.clientIDcard = clientIDcard;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getMangerName() {
		return mangerName;
	}

	public void setMangerName(String mangerName) {
		this.mangerName = mangerName;
	}

	public long getCardNum() {
		return cardNum;
	}

	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	@Override
	public String toString() {
		return "FenYe [page=" + page + ", rows=" + rows + ", rowsCount=" + rowsCount + ", pageCount=" + pageCount
				+ ", startRows=" + startRows + ", clientIDcard=" + clientIDcard + ", clientName=" + clientName
				+ ", cardName=" + cardName + ", mangerName=" + mangerName + ", cardNum=" + cardNum + "]";
	}
	

}
