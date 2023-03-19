/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.NoItemsAddedException;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import model.Customer;
import model.Invoice;
import model.InvoiceItem;
import model.Item;
import view.InvoiceDisplayPanel;


/**
 *
 * @author leont
 */
public class InvoiceController {
    private final DefaultListModel<InvoiceItem> listedItems = new DefaultListModel<>();
    private final CustomerController customerController;
    private final ItemController itemController;
    private int totalAmount = 0;
    private BigDecimal totalPrice = new BigDecimal("0");
    private final ArrayList<Invoice> invoices = new ArrayList<>();
    private int displayedIndex = 0;
    
    
    public InvoiceController(CustomerController customerController, ItemController itemController){
        this.customerController = customerController;
        this.itemController = itemController;
    }
    
    public DefaultListModel getListedItems(){
        return this.listedItems;
    }
    
    public void addItemToList(int itemIndex, int amount, JLabel totalAmountLbl, JLabel totalPriceLbl){
        Item item = this.itemController.getItem(itemIndex);
        InvoiceItem newItem = new InvoiceItem(item, amount);
        this.listedItems.addElement(newItem);
        this.totalAmount += amount;
        this.totalPrice = this.totalPrice.add(newItem.totalPrice());
        totalAmountLbl.setText("Total amount: " + Integer.toString(this.totalAmount));
        totalPriceLbl.setText("Total price: " + this.totalPrice.toString());
    }
    
    public void removeItemFromList(int index, JLabel totalAmountLbl, JLabel totalPriceLbl){
        InvoiceItem removedItem = this.listedItems.remove(index);       
        this.totalAmount -= removedItem.getAmount();
        this.totalPrice = this.totalPrice.subtract(removedItem.totalPrice());
        totalAmountLbl.setText("Total amount: " + Integer.toString(this.totalAmount));
        totalPriceLbl.setText("Total price: " + this.totalPrice.toString());
    }
    
    public void createInvoice(String date, int customerIndex, InvoiceDisplayPanel invoicePanel)
     throws NoItemsAddedException{
        Customer customer = new Customer(this.customerController.getCustomer(customerIndex));
        int array_len = this.listedItems.getSize();
        if (array_len < 1){
            throw new NoItemsAddedException("No items added to invoice");
        }
        InvoiceItem[] itemArray = new InvoiceItem[array_len];
        for (int i=0; i<array_len; i++){
            itemArray[i] = new InvoiceItem(this.listedItems.getElementAt(i));
        }
        Invoice newInvoice = new Invoice(date, customer, itemArray, this.totalAmount, this.totalPrice);
        this.listedItems.removeAllElements();
        this.totalAmount = 0;
        this.totalPrice = new BigDecimal("0");
        this.invoices.add(newInvoice);
        this.displayedIndex = this.invoices.size()-1;
        this.newestInvoice(invoicePanel);
    }
    
    // Returns true if an invoice exists
    public Boolean newestInvoice(InvoiceDisplayPanel invoicePanel){
        int index = this.invoices.size()-1;       
        if (index >= 0){
            this.displayedIndex = index;
            Invoice invoice = this.invoices.get(this.displayedIndex);
            invoice.display(invoicePanel);
            return true;
        }
       return false;
    }
    
    public void prevInvoice(InvoiceDisplayPanel invoicePanel){
        int index = this.displayedIndex - 1;
        if (index >= 0){
            this.displayedIndex = index;
            Invoice invoice = this.invoices.get(this.displayedIndex);
            invoice.display(invoicePanel);
        }
    }
    
    public void nextInvoice(InvoiceDisplayPanel invoicePanel){
        int index = this.displayedIndex + 1;
        if (index < this.invoices.size()){
            this.displayedIndex = index;
            Invoice invoice = this.invoices.get(this.displayedIndex);
            invoice.display(invoicePanel);
        }
    }
}
