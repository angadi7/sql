package com.Day28;



//Interface for the sensitive object
interface SecretObject {
 String getSecretKey();
}

//Concrete implementation of the sensitive object
class RealSecretObject implements SecretObject {
 private String secretKey;

 public RealSecretObject() {
     // Initialize the secret key (in a real-world scenario, this might be fetched from a secure source)
     this.secretKey = "SuperSecretKey123";
 }

 @Override
 public String getSecretKey() {
     return secretKey;
 }
}

//Proxy class for accessing the sensitive object
class SecretObjectProxy implements SecretObject {
 private RealSecretObject realSecretObject;
 private String password;

 public SecretObjectProxy(String password) {
     this.password = password;
 }

 @Override
 public String getSecretKey() {
     if (authenticate()) {
         if (realSecretObject == null) {
             realSecretObject = new RealSecretObject();
         }
         return realSecretObject.getSecretKey();
     } else {
         return "Access Denied: Incorrect Password";
     }
 }

 private boolean authenticate() {
     // In a real-world scenario, password validation would be more complex and secure
     return "correct_password".equals(password);
 }
}

//Example usage
public class Proxy {
 public static void main(String[] args) {
     // Attempt to access the secret key with the incorrect password
     SecretObjectProxy proxyWithWrongPassword = new SecretObjectProxy("wrong_password");
     System.out.println(proxyWithWrongPassword.getSecretKey());  // Output: Access Denied: Incorrect Password

     // Attempt to access the secret key with the correct password
     SecretObjectProxy proxyWithCorrectPassword = new SecretObjectProxy("correct_password");
     System.out.println(proxyWithCorrectPassword.getSecretKey());  // Output: SuperSecretKey123
 }
}
