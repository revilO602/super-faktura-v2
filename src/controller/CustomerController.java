/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import exceptions.MissingDataException;
import javax.swing.DefaultComboBoxModel;
import model.Customer;

/**
 *
 * @author leont
 */
public class CustomerController {
    private final DefaultComboBoxModel<Customer> customers = new DefaultComboBoxModel<>();;
    
    public CustomerController(){
    }
    
    public DefaultComboBoxModel getCustomers(){
        return this.customers;
    }
    
    public void addCustomer(int result, String[] info)
        throws MissingDataException{
        if (result == 0){
            for (int i=0; i<4; i++){
                if (info[i].trim().isEmpty()){
                    throw new MissingDataException("Customer data missing!");
                }
            }
            this.customers.addElement(new Customer(info[0], info[1],
                                               info[2], info[3]));
        }
    }
    
    public void editCustomer(int result, int index, String[] info)
        throws MissingDataException{
        if (result == 1){
            for (int i=0; i<4; i++){
                if (info[i].trim().isEmpty()){
                    throw new MissingDataException("Customer data missing!");
                }
            }
            Customer customer = this.customers.getElementAt(index);
            customer.setName(info[0]);
            customer.setAddress(info[1]);
            customer.setCity(info[2]);
            customer.setPostalCode(info[3]);
        }  
        else if (result == 0){
            this.customers.removeElementAt(index);
        }
    }
    
    public String[] getCustomerInfo(int index){
        Customer customer = this.customers.getElementAt(index);
        String[] info = {customer.getName(),customer.getAddress(),
            customer.getCity(), customer.getPostalCode()};
        return info;
    }
    
    public Customer getCustomer(int index){
        return this.customers.getElementAt(index);
    }
}
