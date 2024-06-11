package com.Day28;



//Strategy interface
interface SortingStrategy {
 void sort(int[] numbers);
}

//Concrete strategy for Bubble Sort
class BubbleSortStrategy implements SortingStrategy {
 @Override
 public void sort(int[] numbers) {
     int n = numbers.length;
     for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < n - i - 1; j++) {
             if (numbers[j] > numbers[j + 1]) {
                 // Swap numbers[j] and numbers[j+1]
                 int temp = numbers[j];
                 numbers[j] = numbers[j + 1];
                 numbers[j + 1] = temp;
             }
         }
     }
     System.out.println("Sorted using Bubble Sort");
 }
}

//Concrete strategy for Quick Sort
class QuickSortStrategy implements SortingStrategy {
 @Override
 public void sort(int[] numbers) {
     quickSort(numbers, 0, numbers.length - 1);
     System.out.println("Sorted using Quick Sort");
 }

 private void quickSort(int[] array, int low, int high) {
     if (low < high) {
         int pi = partition(array, low, high);
         quickSort(array, low, pi - 1);
         quickSort(array, pi + 1, high);
     }
 }

 private int partition(int[] array, int low, int high) {
     int pivot = array[high];
     int i = (low - 1);
     for (int j = low; j < high; j++) {
         if (array[j] <= pivot) {
             i++;
             // Swap array[i] and array[j]
             int temp = array[i];
             array[i] = array[j];
             array[j] = temp;
         }
     }
     // Swap array[i + 1] and array[high] (or pivot)
     int temp = array[i + 1];
     array[i + 1] = array[high];
     array[high] = temp;

     return i + 1;
 }
}

//Context class that uses different sorting strategies
class Context {
 private SortingStrategy strategy;

 public void setSortingStrategy(SortingStrategy strategy) {
     this.strategy = strategy;
 }

 public void sortNumbers(int[] numbers) {
     if (strategy != null) {
         strategy.sort(numbers);
     } else {
         System.out.println("No sorting strategy set");
     }
 }
}

//Example usage
public class Main4 {
 public static void main(String[] args) {
     Context context = new Context();

     int[] numbers = {5, 2, 9, 1, 5, 6};

     // Using Bubble Sort
     context.setSortingStrategy(new BubbleSortStrategy());
     context.sortNumbers(numbers);
     printArray(numbers);

     // Using Quick Sort
     numbers = new int[]{3, 7, 8, 5, 2, 1, 9, 5, 4};
     context.setSortingStrategy(new QuickSortStrategy());
     context.sortNumbers(numbers);
     printArray(numbers);
 }

 public static void printArray(int[] array) {
     for (int num : array) {
         System.out.print(num + " ");
     }
     System.out.println();
 }
}
