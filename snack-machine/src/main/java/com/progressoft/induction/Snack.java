package com.progressoft.induction;

public class Snack {
    private int quantity;
    private Money price;
    private SnackType type;

    public Snack(int quantity, Money price, SnackType type) {
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public int quantity() {
        return quantity;
    }
    public Money price(){
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
