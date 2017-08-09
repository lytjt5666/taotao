package com.taotao.common.pojo;

import java.util.List;

public class EasyUIDataGridResult {
	
	private Long total;
	private List<?> rows; //类型不确定
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
