package com.edu.mall.product.bean;

import java.sql.Timestamp;

/**
 * @author box
 * @date 2019/5/11 - 11:47
 */
public class Product {

    private Integer pid;
    private String pname;
    private String type;
    private double price;
    private Timestamp createTime;

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                '}';
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPname() {

        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPid() {

        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
