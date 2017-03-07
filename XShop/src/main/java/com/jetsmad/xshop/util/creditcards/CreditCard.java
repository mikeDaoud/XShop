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
    
    String creditCardNumber;
    String expiryMonth;
    String expiryYear;
    double balance;
    String securityCode;
    String holderName;

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderName() {
        return holderName;
    }

    public CreditCard() {
        
    }

     public CreditCard(String creditCardNumber, String expiryMonth, String expiryYear, double balance, String securityCode, String holderName) {
        this.creditCardNumber = creditCardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.balance = balance;
        this.securityCode = securityCode;
        this.holderName = holderName;
    }
    
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
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
