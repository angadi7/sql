package com.Day25;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOFileCopy {
    public static void main(String[] args) {
        // Paths to the input and output files
        Path inputFile = Paths.get("Rufthan.txt");
        Path outputFile = Paths.get("example.txt");

        // Open the input file channel for reading
        try (FileChannel inputChannel = FileChannel.open(inputFile, StandardOpenOption.READ);
             // Open the output file channel for writing
             FileChannel outputChannel = FileChannel.open(outputFile, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            
            // Allocate a buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            
            // Read data from the input file into the buffer
            while (inputChannel.read(buffer) > 0) {
                // Flip the buffer from reading mode to writing mode
                buffer.flip();
                
                // Write data from the buffer to the output file
                outputChannel.write(buffer);
                
                // Clear the buffer for the next read
                buffer.clear();
            }
            
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
