/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author leont
 */
public class Item {
    private String name;
    private String desc;
    private BigDecimal price;

    public Item(String name, String desc, BigDecimal price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.price = this.price.setScale(2, BigDecimal.ROUND_UP);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        this.price = this.price.setScale(2, BigDecimal.ROUND_UP);
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
