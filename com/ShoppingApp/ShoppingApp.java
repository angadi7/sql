package com.ShoppingApp;

import java.util.LinkedList;

public class ShoppingApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        PurchaseHistory history = new PurchaseHistory();
        CustomerService service = new CustomerService();

        // Shopping cart operations
        cart.addItem("Apple");
        cart.addItem("Banana");
        cart.viewCart();

        cart.removeItem("Apple");
        cart.viewCart();

        // Purchase history operations
        history.saveCart(cart.getCart());
        cart.addItem("Orange");
        cart.viewCart();

        history.saveCart(cart.getCart());
        history.viewPurchaseHistory();

        LinkedList<String> lastPurchase = history.undoLastPurchase();
        System.out.println("Undo last purchase: " + lastPurchase);
        history.viewPurchaseHistory();

        // Customer service operations
        service.addRequest("Help with order #1234");
        service.addRequest("Change delivery address");
        service.viewPendingRequests();

        service.processNextRequest();
        service.viewPendingRequests();

        service.processNextRequest();
        service.viewPendingRequests();
    }
}

