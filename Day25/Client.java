package com.Day25;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to the server.");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Operation op = new Operation(2, 2, "+");
        oos.writeObject(op);

        int result = ois.readInt();
        System.out.println("Result received from the server: " + result);

        ois.close();
        oos.close();
        socket.close();
    }
}