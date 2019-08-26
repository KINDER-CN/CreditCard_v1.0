package com.zl.pojo.mklFenYe;

import org.springframework.stereotype.Component;

@Component
public class FenYeClientApplyCard {

	// 分页查询sql语句select * from talblename limit startRows,rows
	private Integer page;// 当前请求页码
	private Integer rows = 10;// 每页显示条数
	private Integer rowsCount;// 查询符合条件总记录条数
	private Integer pageCount;// 总页码数
	private Integer startRows;// 起始条数
	private QueryClientApplyCard queryClientApplyCard;// 条件

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		// 判断最后一页显示的条数是否小于每页显示的条数，是则获取剩余条数的显示
		/*
		 * if((rows+getStartRows())>getRowsCount()) {
		 * rows=getRowsCount()-getStartRows(); }else { return rows; }
		 */
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

	public QueryClientApplyCard getQueryClientApplyCard() {
		return queryClientApplyCard;
	}

	public void setQueryClientApplyCard(QueryClientApplyCard queryClientApplyCard) {
		this.queryClientApplyCard = queryClientApplyCard;
	}

	
}
