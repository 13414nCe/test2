package cn.qyl.ebuy.dto;

public class OrderItem {

	private Order order;
	private Goods goods;
	private int orderNum;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
	@Override
	public String toString() {
		return "OrderItem [order=" + order + ", goods=" + goods + ", orderNum="
				+ orderNum + "]";
	}
	
	
	
}
