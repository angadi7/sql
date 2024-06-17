package com.ShoppingApp;

import java.util.Stack;
import java.util.LinkedList;

class PurchaseHistory {
    private Stack<LinkedList<String>> history;

    public PurchaseHistory() {
        history = new Stack<>();
    }

    public void saveCart(LinkedList<String> cart) {
        history.push(cart);
    }

    public LinkedList<String> undoLastPurchase() {
        if (!history.isEmpty()) {
            return history.pop();
        } else {
            System.out.println("No purchase history available.");
            return null;
        }
    }

    public void viewPurchaseHistory() {
        System.out.println("Purchase History: " + history);
    }
}

