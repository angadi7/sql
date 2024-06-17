package com.ShoppingApp;

import java.util.LinkedList;

class ShoppingCart {
    private LinkedList<String> cart;

    public ShoppingCart() {
        cart = new LinkedList<>();
    }

    public void addItem(String item) {
        cart.add(item);
    }

    public void removeItem(String item) {
        cart.remove(item);
    }

    public void viewCart() {
        System.out.println("Shopping Cart: " + cart);
    }

    public LinkedList<String> getCart() {
        return new LinkedList<>(cart);
    }

    public void clearCart() {
        cart.clear();
    }
}

