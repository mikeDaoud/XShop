/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.beans;

/**
 *
 * @author michael
 */
public class CartItem {

    public Product product;
    public int quantity;

    public CartItem() {

    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOne() {
        if (quantity <= 1) {
            return true;
        }
        return false;
    }

    public void addOne(){
        quantity++;
    }
    
    public boolean removeOne(){
        if(isOne()){
            return false;
        }
        else{
            quantity--;
            return true;
        }
        
    }
}
