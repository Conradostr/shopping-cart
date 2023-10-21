package br.com.conradostr.models;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Purchase> shopping;

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.shopping = new ArrayList<>();
    }

    public boolean addPurchase(Purchase purchase){
        if(this.balance > purchase.getValue()){
            this.balance -= purchase.getValue();
            shopping.add(purchase);
            return true;
        }
        return false;
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getShopping() {
        return shopping;
    }
}
