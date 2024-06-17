package com.ShoppingApp;

import java.util.LinkedList;
import java.util.Queue;

class CustomerService {
    private Queue<String> serviceRequests;

    public CustomerService() {
        serviceRequests = new LinkedList<>();
    }

    public void addRequest(String request) {
        serviceRequests.offer(request);
    }

    public void processNextRequest() {
        if (!serviceRequests.isEmpty()) {
            System.out.println("Processing request: " + serviceRequests.poll());
        } else {
            System.out.println("No pending customer service requests.");
        }
    }

    public void viewPendingRequests() {
        System.out.println("Pending Requests: " + serviceRequests);
    }
}
