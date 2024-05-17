package QueueSorting;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSorter {

    public static void sortQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            
            while (!stack.isEmpty() && stack.peek() > current) {
                queue.offer(stack.pop());
            }

            
            stack.push(current);
        }

       
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(3);
        queue.offer(1);
        queue.offer(4);
        queue.offer(1);
        queue.offer(5);
        queue.offer(9);
        queue.offer(2);
        queue.offer(6);
        queue.offer(5);
        queue.offer(3);
        queue.offer(5);

        System.out.println("Original Queue: " + queue);

        sortQueue(queue);

        System.out.println("Sorted Queue: " + queue);
    }
}

