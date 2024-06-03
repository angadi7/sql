package com.Day23;

import java.util.Arrays;

public class SwapElements {

    public static <T> void swap(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid indices");
        }
        
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Original Integer Array: " + Arrays.toString(intArray));
        swap(intArray, 1, 3);
        System.out.println("After Swapping: " + Arrays.toString(intArray));

        // String array
        String[] strArray = {"apple", "banana", "cherry", "date"};
        System.out.println("\nOriginal String Array: " + Arrays.toString(strArray));
        swap(strArray, 0, 2);
        System.out.println("After Swapping: " + Arrays.toString(strArray));

        // Double array
        Double[] doubleArray = {1.5, 2.5, 3.5, 4.5, 5.5};
        System.out.println("\nOriginal Double Array: " + Arrays.toString(doubleArray));
        swap(doubleArray, 2, 4);
        System.out.println("After Swapping: " + Arrays.toString(doubleArray));
    }
}
