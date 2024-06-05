package com.Day25;

import java.io.*;

@SuppressWarnings("serial")
//Define a custom class that implements Serializable
class MyObject implements Serializable {
 private String name;
 private int value;

 public MyObject(String name, int value) {
     this.name = name;
     this.value = value;
 }

 public String getName() {
     return name;
 }

 public int getValue() {
     return value;
 }
}

public class SerializationExample {
 public static void main(String[] args) {
     // Create an instance of MyObject
     MyObject myObj = new MyObject("Test", 123);

     // Serialize the object to a file
     try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("myObject.ser"))) {
         out.writeObject(myObj);
     } catch (IOException e) {
         e.printStackTrace();
     }

     // Deserialize the object from the file
     MyObject recoveredObj = null;
     try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("myObject.ser"))) {
         recoveredObj = (MyObject) in.readObject();
     } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
     }

     if (recoveredObj != null) {
         // Verify the deserialization
         System.out.println("Name: " + recoveredObj.getName());  // Output: Test
         System.out.println("Value: " + recoveredObj.getValue()); // Output: 123
     }
 }
}