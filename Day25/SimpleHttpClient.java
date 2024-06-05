package com.Day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class SimpleHttpClient {
    public static void main(String[] args) {
        String urlString = "http://www.example.com"; // Change this to the desired URL

        try {
            // Create a URL object
            @SuppressWarnings("deprecation")
			URL url = new URL(urlString);
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method
            connection.setRequestMethod("GET");
            
            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Get and print the response headers
            Map<String, List<String>> headers = connection.getHeaderFields();
            System.out.println("Response Headers:");
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            
            // Get and print the response body
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responseBody = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseBody.append(inputLine).append("\n");
            }
            in.close();

            System.out.println("Response Body:");
            System.out.println(responseBody.toString());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
