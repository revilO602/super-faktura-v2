/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.MissingDataException;
import java.math.BigDecimal;
import javax.swing.DefaultComboBoxModel;
import model.Item;

/**
 *
 * @author leont
 */
public class ItemController {
    private final DefaultComboBoxModel<Item> items = new DefaultComboBoxModel<>();;
    
    public ItemController(){
    }
    
    public DefaultComboBoxModel getItems(){
        return this.items;
    }
    
    public void addItem(int result, String[] info)
        throws MissingDataException{
        if (result == 0){
            if (info[0].trim().isEmpty()){
                throw new MissingDataException("Item name missing!");
            }
            this.items.addElement(new Item(info[0], info[1], new BigDecimal(info[2])));
        }
    }
    
    public Item getItem(int index){
        return this.items.getElementAt(index);
    }
    
    public String[] getItemInfo(int index){
        Item item = this.items.getElementAt(index);
        String[] info = {item.getName(),item.getDesc(),
            item.getPrice().toString()};
        return info;
    }
    
    public void editItem(int result, int index, String[] info)
        throws MissingDataException{
        if (result == 1){
            if (info[0].trim().isEmpty()){
                throw new MissingDataException("Item name missing!");
            }
            Item item = this.items.getElementAt(index);
            item.setName(info[0]);
            item.setDesc(info[1]);
            item.setPrice(new BigDecimal(info[2]));
        }  
        else if (result == 0){
            this.items.removeElementAt(index);
        }
    }
}
