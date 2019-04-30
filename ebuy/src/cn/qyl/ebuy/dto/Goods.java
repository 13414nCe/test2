package cn.qyl.ebuy.dto;

import org.springframework.format.annotation.DateTimeFormat;

public class Goods {

	private int id;
	private String title;
	private String brandName;
	private double price;
	private double favorablePrice;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date groundingDate;
	private int storage;
	private String image;
	private String description;
	private GoodsType goodsType;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date createDate;
	private int buyNum;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getFavorablePrice() {
		return favorablePrice;
	}
	public void setFavorablePrice(double favorablePrice) {
		this.favorablePrice = favorablePrice;
	}
	public java.util.Date getGroundingDate() {
		return groundingDate;
	}
	public void setGroundingDate(java.util.Date groundingDate) {
		this.groundingDate = groundingDate;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", title=" + title + ", brandName="
				+ brandName + ", price=" + price + ", favorablePrice="
				+ favorablePrice + ", groundingDate=" + groundingDate
				+ ", storage=" + storage + ", image=" + image
				+ ", description=" + description + ", goodsType=" + goodsType
				+ ", createDate=" + createDate + "]";
	}
	
	
	
}
