package Stacksorting;

import java.util.Stack;

public class StackSorter {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int current = stack.pop();

            // Move elements from tempStack back to stack until the correct position for current is found
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                stack.push(tempStack.pop());
            }

            // Push the current element onto the tempStack
            tempStack.push(current);
        }

        // Transfer elements back from tempStack to stack so that the smallest items are on top
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(5);
        stack.push(9);
        stack.push(2);
        stack.push(6);
        
        
        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

