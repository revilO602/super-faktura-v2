/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import view.InvoiceDisplayPanel;

/**
 *
 * @author leont
 */
public class Invoice {
    private final String creationDate;
    private final Customer customer;
    private final InvoiceItem[] items;
    private final int totalAmount;
    private final BigDecimal totalPrice;

    public Invoice(String creationDate, Customer customer, InvoiceItem[] items, int totalAmount, BigDecimal totalPrice){
        this.creationDate = creationDate;
        this.customer = customer;
        this.items = items;
        this.totalPrice = totalPrice;
        this.totalAmount = totalAmount;
    }

    public void display(InvoiceDisplayPanel invoicePanel){
        invoicePanel.setCustomerInfo(this.customer.getName() + ", " + this.customer.getAddress() +
                                     ", " + this.customer.getPostalCode() + " " + this.customer.getCity());
        invoicePanel.setDate(this.creationDate);
        invoicePanel.clearTable();
        for (InvoiceItem i : this.items){
            String itemInfo[] = {i.getName(), i.getDesc(), i.getPrice().toString(), 
                                 Integer.toString(i.getAmount()), i.totalPrice().toString()};
            invoicePanel.insertRow(itemInfo);
        }
        invoicePanel.displayTotalPrice(this.totalPrice.toString());
        invoicePanel.displayTotalAmount(this.totalAmount);
    }
}
