package cn.qyl.ebuy.dto;

import org.springframework.format.annotation.DateTimeFormat;

public class Timlimited {

	private int id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date limitDate;
	private Goods goods;
	private int isEnd;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.util.Date getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(java.util.Date limitDate) {
		this.limitDate = limitDate;
	}
	
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	
	
}
