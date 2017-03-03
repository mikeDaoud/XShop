/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jetsmad.xshop.util.creditcards;

/**
 *
 * @author markoiti
 */
public class CreditCard {
    
    String id;
    String creditCardNumber;
    int expiryMonth;
    int expiryYear;
    double balance;
    String securityCode;

    public CreditCard() {
        
    }

    public CreditCard(String id, String creditCardNumber, int expiryMonth, int expiryYear, double balance, String securityCode) {
        this.id = id;
        this.creditCardNumber = creditCardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.balance = balance;
        this.securityCode = securityCode;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
    
}
