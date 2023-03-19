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
public class InvoiceItem extends Item {
    private final int amount;
    
    public InvoiceItem(Item item, int amount) {
        super(item.getName(), item.getDesc(), item.getPrice());
        this.amount = amount;
    }
    
    //Copy constructor
    public InvoiceItem(InvoiceItem invoiceItem){
        super(invoiceItem.getName(),invoiceItem.getDesc(),invoiceItem.getPrice());
        this.amount = invoiceItem.amount;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    public BigDecimal totalPrice(){
        return this.getPrice().multiply(new BigDecimal(this.amount));
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(this.amount);
        str.append("x   ");
        str.append(this.getName());
        str.append("    ");
        str.append(this.totalPrice());
        return str.toString();
    }
}
