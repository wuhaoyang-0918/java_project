package com.demo.pojo;

import java.util.Date;

/**
 * @author why
 * @date 2021/10/20 14:32
 * @PackageName com.demo.pojo
 * @description
 */
public class Order {
    private Integer id;
    private Date createtime;
    private Integer price;
    private String remark;
    private Integer userId;
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createtime=" + createtime +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Order(Integer id, Date createtime, Integer price, String remark, Integer userId) {
        this.id = id;
        this.createtime = createtime;
        this.price = price;
        this.remark = remark;
        this.userId = userId;
    }
}
