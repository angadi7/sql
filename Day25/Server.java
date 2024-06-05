package com.Day25;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started. Waiting for a client ...");
        Socket socket = serverSocket.accept();
        System.out.println("Client accepted.");

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        Operation op = (Operation) ois.readObject();
        int result = op.performOperation();
        oos.writeInt(result);

        ois.close();
        oos.close();
        socket.close();
        serverSocket.close();
    }
}

@SuppressWarnings("serial")
class Operation implements Serializable {
    private int number1;
    private int number2;
    private String operation;

    public Operation(int number1, int number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public int performOperation() {
        switch (operation) {
            case "+": return number1 + number2;
            case "-": return number1 - number2;
            case "*": return number1 * number2;
            case "/": return number1 / number2;
            default: return 0;
        }
    }
}
